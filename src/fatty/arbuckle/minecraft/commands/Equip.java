package fatty.arbuckle.minecraft.commands;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Equip {

	private static void addIfDoesnt(PlayerInventory inventory, Material item, int count) {
		if (!inventory.contains(item, count)) {
			inventory.addItem(new ItemStack(item, count));
		}
	}

	private static void equipPlayer(Player p) {
		PlayerInventory inventory = p.getInventory();

		// add whatever the player doesn't have
		addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
		addIfDoesnt(inventory, Material.BOW, 1);
		addIfDoesnt(inventory, Material.DIAMOND_AXE, 1);
		addIfDoesnt(inventory, Material.DIAMOND_PICKAXE, 1);
		addIfDoesnt(inventory, Material.DIAMOND_HELMET, 1);
		addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
		addIfDoesnt(inventory, Material.DIAMOND_SPADE, 1);
		addIfDoesnt(inventory, Material.ARROW, 64);
		addIfDoesnt(inventory, Material.ARROW, 64);
		addIfDoesnt(inventory, Material.ARROW, 64);
		addIfDoesnt(inventory, Material.COOKED_MUTTON, 64);

		inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		inventory.setItemInOffHand(new ItemStack(Material.SHIELD));
	}

	public static boolean run(CommandSender sender, String label, String[] args) {

		// equip all of the players
		if (args.length > 0) {
			Server server = sender.getServer();
			for (String playerName : args) {
				Player player = server.getPlayerExact(playerName);
				if (player != null) {
					equipPlayer(player);
				} else {
					System.out.println(playerName + " could not be found!");
				}
			}
			return true;
		}

		// equip the caller
		else if (sender instanceof Player) {
				Player player = (Player) sender;
				equipPlayer(player);
				return true;
		}

		// oops
        else {
        	System.out.println(sender.getName() + " is not a player and cannot be equipped!");
            return false;
		}
	}
}
