package fatty.arbuckle.minecraft.commands;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import fatty.arbuckle.minecraft.util.PlayerUtil;

public class Equip {

	private static void equipPlayer(Player p) {
		PlayerInventory inventory = p.getInventory();

		// add whatever the player doesn't have
		PlayerUtil.addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
		PlayerUtil.addIfDoesnt(inventory, Material.BOW, 1);
		PlayerUtil.addIfDoesnt(inventory, Material.DIAMOND_AXE, 1);
		PlayerUtil.addIfDoesnt(inventory, Material.DIAMOND_PICKAXE, 1);
		PlayerUtil.addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
		// PlayerUtil.addIfDoesnt(inventory, Material.DIAMOND_SPADE, 1);
		inventory.addItem(new ItemStack(Material.ARROW, 64));
		inventory.addItem(new ItemStack(Material.ARROW, 64));
		PlayerUtil.addIfDoesnt(inventory, Material.COOKED_MUTTON, 64);
		PlayerUtil.addIfDoesnt(inventory, Material.SADDLE, 1);

		inventory.setHelmet(new ItemStack(Material.LEATHER_HELMET));
		inventory.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		inventory.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		inventory.setBoots(new ItemStack(Material.LEATHER_BOOTS));

//		// add whatever the player doesn't have
//		addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
//		addIfDoesnt(inventory, Material.BOW, 1);
//		addIfDoesnt(inventory, Material.DIAMOND_AXE, 1);
//		addIfDoesnt(inventory, Material.DIAMOND_PICKAXE, 1);
//		addIfDoesnt(inventory, Material.DIAMOND_SWORD, 1);
//		addIfDoesnt(inventory, Material.DIAMOND_SPADE, 1);
//		inventory.addItem(new ItemStack(Material.ARROW, 64));
//		inventory.addItem(new ItemStack(Material.ARROW, 64));
//		addIfDoesnt(inventory, Material.COOKED_MUTTON, 64);
//
//		inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
//		inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
//		inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
//		inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
//		inventory.setItemInOffHand(new ItemStack(Material.SHIELD));
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
