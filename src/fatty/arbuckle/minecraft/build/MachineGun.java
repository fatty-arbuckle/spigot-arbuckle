package fatty.arbuckle.minecraft.build;

import fatty.arbuckle.minecraft.util.LocationUtil;
import fatty.arbuckle.minecraft.util.PlayerUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Set;

/**
 * Created by phatty on 12/28/17.
 */
public class MachineGun {

    private MachineGun() {
    }

    public static void build(Player player) {

        ReplacementDrone drone = new ReplacementDrone(player.getTargetBlock((Set<Material>) null, 25).getLocation());

        Block dispenser = drone.up().getBlock();
        dispenser.setType(Material.DISPENSER);

        setFacingDirection(dispenser.getState(), drone.turnAround());
        setInventory(dispenser.getState());



//        Vector normalizedPlayerVector = player.getLocation().getDirection().normalize();
//        Block underBlock = player.getTargetBlock((Set<Material>) null, 25);
//        Block targetBlock = LocationUtil.getBlockAbove(underBlock);
//
//        targetBlock.setType(Material.DISPENSER);
//
//        BlockState targetState = targetBlock.getState();
//
//        setFacingDirection(targetState, normalizedPlayerVector);
//        setInventory(targetState);
//
//        Block redstoneWire1 = LocationUtil.getBlockInBack(targetBlock, normalizedPlayerVector);
//        redstoneWire1.setType(Material.REDSTONE_WIRE);
//        Block redstoneWire2 = LocationUtil.getBlockInBack(redstoneWire1, normalizedPlayerVector);
//        redstoneWire2.setType(Material.REDSTONE_WIRE);
//        Block redstoneWire3 = LocationUtil.getBlockInBack(redstoneWire2, normalizedPlayerVector);
//        redstoneWire3.setType(Material.REDSTONE_WIRE);
//        Block redstoneWire4 = LocationUtil.getBlockInBack(redstoneWire3, normalizedPlayerVector);
//        redstoneWire4.setType(Material.REDSTONE_WIRE);
//        Block redstoneWire5 = LocationUtil.getBlockInBack(redstoneWire4, normalizedPlayerVector);
//        redstoneWire5.setType(Material.REDSTONE_WIRE);
//
//        Block repeaterBlockL = LocationUtil.getBlockToLeft(redstoneWire4, normalizedPlayerVector);
//        repeaterBlockL.setType(Material.STONE);
//        Block repeaterBlockR = LocationUtil.getBlockToRight(redstoneWire4, normalizedPlayerVector);
//        repeaterBlockR.setType(Material.STONE);
//


//        triggerBlock.getState().update();
    }

    private static void setInventory(BlockState targetState) {
        org.bukkit.block.Dispenser dispenser = (org.bukkit.block.Dispenser)targetState;
        dispenser.update();

        Inventory dispenserInventory = dispenser.getInventory();
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
        dispenserInventory.addItem(new ItemStack(Material.ARROW, 64));
    }

    private static void setFacingDirection(BlockState targetState, BlockFace blockFace) {
        org.bukkit.material.Dispenser dispenser = (org.bukkit.material.Dispenser) targetState.getData();
        dispenser.setFacingDirection(blockFace);
    }


}