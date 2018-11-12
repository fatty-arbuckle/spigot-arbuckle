package fatty.arbuckle.minecraft.util;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

/**
 * Created by phatty on 12/28/17.
 */
public class LocationUtil {

    private static final Vector aboveVector = new Vector(0, 1, 0);  // ABOVE    +y
    private static final Vector belowVector = new Vector(0, -1, 0); // BELOW    -y
    private static final Vector northVector = new Vector(0,0,-1);   // NORTH    -z
    private static final Vector eastVector  = new Vector(1,0,0);    // EAST     +x
    private static final Vector southVector = new Vector(0,0,1);    // SOUTH    +z
    private static final Vector westVector  = new Vector(-1,0,0);   // WEST     -x

    public static BlockFace getCompassDirection(Vector playerVector) {

        // greatest dot product is the closest direction
        double northDot = playerVector.dot(northVector);
        double eastDot = playerVector.dot(eastVector);
        double southDot = playerVector.dot(southVector);
        double westDot = playerVector.dot(westVector);

        if (northDot >= eastDot && northDot >= southDot && northDot >= westDot) {
            return BlockFace.NORTH;
        }
        if (eastDot >= northDot && eastDot >= southDot && eastDot >= westDot) {
            return BlockFace.EAST;
        }
        if (southDot >= northDot && southDot >= eastDot && southDot >= westDot) {
            return BlockFace.SOUTH;
        }
        if (westDot >= northDot && westDot >= southDot && westDot >= eastDot) {
            return BlockFace.WEST;
        }

        return BlockFace.NORTH;
    }

    public static BlockFace flipCompassDirection(BlockFace blockFace) {
        switch (blockFace) {
            case NORTH:
                return BlockFace.SOUTH;
            case EAST:
                return BlockFace.WEST;
            case SOUTH:
                return BlockFace.NORTH;
            case WEST:
                return BlockFace.EAST;
            default:
                return BlockFace.NORTH;
        }
    }

    public static Block getBlockAbove(Block block) {
        return block.getLocation().add(aboveVector).getBlock();
    }

    public static Block getBlockInBack(Block block, Vector reference) {
        switch (getCompassDirection(reference)) {
            case NORTH:
                return block.getLocation().add(northVector).getBlock();
            case EAST:
                return block.getLocation().add(eastVector).getBlock();
            case SOUTH:
                return block.getLocation().add(southVector).getBlock();
            case WEST:
                return block.getLocation().add(westVector).getBlock();
            default:
                return block.getLocation().add(northVector).getBlock();
        }
    }

    public static Block getBlockToLeft(Block block, Vector reference) {
        switch (getCompassDirection(reference)) {
            case NORTH:
                return block.getLocation().add(westVector).getBlock();
            case EAST:
                return block.getLocation().add(northVector).getBlock();
            case SOUTH:
                return block.getLocation().add(eastVector).getBlock();
            case WEST:
                return block.getLocation().add(southVector).getBlock();
            default:
                return block.getLocation().add(northVector).getBlock();
        }
    }

    public static Block getBlockToRight(Block block, Vector reference) {
        switch (getCompassDirection(reference)) {
            case NORTH:
                return block.getLocation().add(eastVector).getBlock();
            case EAST:
                return block.getLocation().add(southVector).getBlock();
            case SOUTH:
                return block.getLocation().add(westVector).getBlock();
            case WEST:
                return block.getLocation().add(northVector).getBlock();
            default:
                return block.getLocation().add(northVector).getBlock();
        }
    }

}
