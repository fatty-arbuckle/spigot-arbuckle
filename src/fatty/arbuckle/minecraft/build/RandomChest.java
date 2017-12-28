package fatty.arbuckle.minecraft.build;

import fatty.arbuckle.minecraft.util.PlayerUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import fatty.arbuckle.minecraft.util.LocationUtil;

public class RandomChest {
    private RandomChest() {
    }

    public static void build(Player player, Location target) {

        // get block above (y+1) target
        Block targetBlock = target.getWorld().getBlockAt(target.add(new Vector(0, 1, 0)));
        targetBlock.setType(Material.CHEST);
        BlockState targetState = targetBlock.getState();

        Vector playerVector = player.getLocation().getDirection().normalize();
        setFacingDirection(targetState, playerVector);
        setInventory(targetState);
    }

    private static void setFacingDirection(BlockState targetState, Vector playerVector) {
        org.bukkit.material.Chest chest = (org.bukkit.material.Chest) targetState.getData();
        BlockFace compassDirection = LocationUtil.getCompassDirection(playerVector);
        BlockFace blockFace = LocationUtil.flipCompassDirection(compassDirection);
        chest.setFacingDirection(blockFace);
    }

    private static void setInventory(BlockState targetState) {
        org.bukkit.block.Chest chest = (org.bukkit.block.Chest)targetState;
        chest.update();

        Inventory chestInventory = chest.getInventory();

        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_SWORD, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.BOW, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_AXE, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_PICKAXE, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_HELMET, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_SWORD, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.DIAMOND_SPADE, 1);
        PlayerUtil.addIfDoesnt(chestInventory, Material.ARROW, 64);
        PlayerUtil.addIfDoesnt(chestInventory, Material.ARROW, 64);
        PlayerUtil.addIfDoesnt(chestInventory, Material.ARROW, 64);
        PlayerUtil.addIfDoesnt(chestInventory, Material.COOKED_MUTTON, 64);

    }

}
