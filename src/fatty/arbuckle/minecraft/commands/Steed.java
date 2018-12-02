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
import java.util.Collections;
import java.util.Arrays;
import java.util.List;


import fatty.arbuckle.minecraft.util.PlayerUtil;

public class Steed {

  private static List<String> NAMES = Arrays.asList(new String[] {
    "Tater Trotter", "Maple Stirrup", "Usain Colt", "Hermioneigh",
    "NeighSayer", "Trojan", "Colt Forty-Five", "Dappleganger", "Leon Trotsky"
  });

  private static int nameIndex = 0;

  {
    Collections.shuffle(NAMES);
  }

  private static String playerNameToHorseName(String playerName) {
    nameIndex++;
    nameIndex = nameIndex % NAMES.size();
    return NAMES.get(nameIndex);
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
      Horse horse = (Horse)theWorld.spawnEntity(PlayerUtil.findOpenSpace(targetPlayer), EntityType.HORSE);
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
