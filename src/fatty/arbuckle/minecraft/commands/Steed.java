package fatty.arbuckle.minecraft.commands;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse;
import org.bukkit.entity.EntityType;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.CreatureSpawnEvent;

import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

import fatty.arbuckle.minecraft.util.PlayerUtil;

public class Steed {

  // TODO shared with Spawn: refactor
  private static Location findOpenSpace(Player p) {
      return p.getTargetBlock((Set<Material>)null, 20).getLocation();
  }

  private static String playerNameToHorseName(String playerName) {
    return playerName;
  }

	public static boolean run(CommandSender sender, String label, String[] args) {

    Player targetPlayer = null;
    if (sender instanceof Player) {
				targetPlayer = (Player) sender;
		} else if (args.length >= 1) {
        targetPlayer = sender.getServer().getPlayer(args[0]);
    }

    if (targetPlayer != null) {
      World theWorld = targetPlayer.getWorld();
      Horse horse = (Horse)theWorld.spawnEntity(findOpenSpace(targetPlayer), EntityType.HORSE);
      horse.setCustomName(playerNameToHorseName(targetPlayer.getName()));
      horse.setCustomNameVisible(true);
      horse.setAdult();
      horse.setOwner(targetPlayer);

      HorseInventory horseInventory = horse.getInventory();
      horseInventory.setSaddle(new ItemStack(Material.SADDLE, 1));
      horseInventory.setArmor(new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1));

      return true;

    } else {
      System.out.println(args[0] + " is not a player!");
      return false;
    }

	}
}
