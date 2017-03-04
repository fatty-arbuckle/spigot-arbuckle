package fatty.arbuckle.minecraft.build;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.material.Directional;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RandomChest {
    private RandomChest() {
    }

    public static void build(Location player, Location loc) {
      Block target = loc.getWorld().getBlockAt(loc);
      Block playerBlock = loc.getWorld().getBlockAt(player);

      BlockFace facingTowards = target.getFace(playerBlock);
      org.bukkit.material.Chest theChest = new org.bukkit.material.Chest(facingTowards);

      target.setType(Material.CHEST);
      // target.setType(theChest);


      BlockState targetState = target.getState();

      Chest chest = (Chest)targetState;
      // chest.setFacingDirection(facingTowards);
      Inventory chestInventory = chest.getInventory();

      addIfDoesnt(chestInventory, Material.DIAMOND_SWORD, 1);
      addIfDoesnt(chestInventory, Material.BOW, 1);
      addIfDoesnt(chestInventory, Material.DIAMOND_AXE, 1);
      addIfDoesnt(chestInventory, Material.DIAMOND_PICKAXE, 1);
      addIfDoesnt(chestInventory, Material.DIAMOND_HELMET, 1);
      addIfDoesnt(chestInventory, Material.DIAMOND_SWORD, 1);
      addIfDoesnt(chestInventory, Material.DIAMOND_SPADE, 1);
      addIfDoesnt(chestInventory, Material.ARROW, 64);
      addIfDoesnt(chestInventory, Material.ARROW, 64);
      addIfDoesnt(chestInventory, Material.ARROW, 64);
      addIfDoesnt(chestInventory, Material.COOKED_MUTTON, 64);

    }

    private static void addIfDoesnt(Inventory inventory, Material item, int count) {
      if (!inventory.contains(item, count)) {
        inventory.addItem(new ItemStack(item, count));
      }
    }

}
