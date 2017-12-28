package fatty.arbuckle.minecraft.util;

import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

/**
 * Created by phatty on 12/28/17.
 */
public class LocationUtil {

    public static BlockFace getCompassDirection(Vector playerVector) {
        Vector north = new Vector(0,0,-1);  // NORTH    -z
        Vector east = new Vector(1,0,0);    // EAST     +x
        Vector south = new Vector(0,0,1);   // SOUTH    +z
        Vector west = new Vector(-1,0,0);   // WEST     -x

        double northDot = playerVector.dot(north);
        double eastDot = playerVector.dot(east);
        double southDot = playerVector.dot(south);
        double westDot = playerVector.dot(west);

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

}
