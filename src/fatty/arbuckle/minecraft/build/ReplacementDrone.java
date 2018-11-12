package fatty.arbuckle.minecraft.build;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

/**
 * A drone is a location agent
 */
public class ReplacementDrone {

    private static final Vector aboveVector = new Vector(0, 1, 0);  // ABOVE    +y
    private static final Vector belowVector = new Vector(0, -1, 0); // BELOW    -y
    private static final Vector northVector = new Vector(0,0,-1);   // NORTH    -z
    private static final Vector eastVector  = new Vector(1,0,0);    // EAST     +x
    private static final Vector southVector = new Vector(0,0,1);    // SOUTH    +z
    private static final Vector westVector  = new Vector(-1,0,0);   // WEST     -x

    private Location location = null;

    public ReplacementDrone(Location location) {
        this.location = location.clone();
    }

    public Block getBlock() {
        return location.getBlock();
    }

    public BlockFace getCompassDirection() {

        Vector normalizedVector = location.getDirection().normalize();

        // greatest dot product is the closest direction
        double northDot = normalizedVector.dot(northVector);
        double eastDot = normalizedVector.dot(eastVector);
        double southDot = normalizedVector.dot(southVector);
        double westDot = normalizedVector.dot(westVector);

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

    public BlockFace turnAround() {
        switch (getCompassDirection()) {
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

    public Block getBlockAbove() {
        return location.add(aboveVector).getBlock();
    }

    public Block getBlockInBack() {
        switch (getCompassDirection()) {
            case NORTH:
                return location.add(northVector).getBlock();
            case EAST:
                return location.add(eastVector).getBlock();
            case SOUTH:
                return location.add(southVector).getBlock();
            case WEST:
                return location.add(westVector).getBlock();
            default:
                return location.add(northVector).getBlock();
        }
    }

    public Block getBlockToLeft() {
        switch (getCompassDirection()) {
            case NORTH:
                return location.add(westVector).getBlock();
            case EAST:
                return location.add(northVector).getBlock();
            case SOUTH:
                return location.add(eastVector).getBlock();
            case WEST:
                return location.add(southVector).getBlock();
            default:
                return location.add(northVector).getBlock();
        }
    }

    public Block getBlockToRight() {
        switch (getCompassDirection()) {
            case NORTH:
                return location.add(eastVector).getBlock();
            case EAST:
                return location.add(southVector).getBlock();
            case SOUTH:
                return location.add(westVector).getBlock();
            case WEST:
                return location.add(northVector).getBlock();
            default:
                return location.add(northVector).getBlock();
        }
    }

    public ReplacementDrone up() {
        location = location.add(aboveVector);
        return this;
    }
}
