package fatty.arbuckle.minecraft.build;


import org.bukkit.Location;

import static fatty.arbuckle.minecraft.build.Drone.Direction.*;

/**
 * Created by phatty on 7/21/16.
 */
public class Drone {

    public enum Direction { NORTH, EAST, SOUTH, WEST, LOST }

    Location start = null;
    Direction facing = NORTH;

    public Drone(Location loc) {
        start = loc;
        facing = setDirection(loc.getYaw());
    }

    public Direction getDirection() {
        return facing;
    }

    private Direction setDirection(float yaw) {
        /*
            Gets the yaw of this location, measured in degrees.
            A yaw of 0 or 360 represents the positive z direction.
                A yaw of 180 represents the negative z direction.
                A yaw of 90 represents the negative x direction.
                A yaw of 270 represents the positive x direction.
                Increasing yaw values are the equivalent of turning to your right-facing, increasing the scale of the
                next respective axis, and decreasing the scale of the previous axis.
        */

        if (yaw >= 315.0 || yaw < 45.0) {
            return EAST;
        }
        else if (yaw >= 45.0 && yaw < 135.0) {
            return SOUTH;
        }
        else if (yaw >= 135.0 && yaw < 225.0) {
            return WEST;
        }
        else if (yaw >= 225.0 && yaw < 315.0) {
            return NORTH;
        }
        return Direction.LOST;
    }

    protected Location forward(int blocks) {
        switch (facing) {
            case NORTH:
                return incrX(blocks);
            case SOUTH:
                return decrX(blocks);
            case EAST:
                return incrZ(blocks);
            case WEST:
                return decrZ(blocks);
        }
        throw new IllegalStateException("Not facing any know direction!");
    }

    public Location backward(int blocks) {
        switch (facing) {
            case NORTH:
                return decrX(blocks);
            case SOUTH:
                return incrX(blocks);
            case EAST:
                return decrZ(blocks);
            case WEST:
                return incrZ(blocks);
        }
        throw new IllegalStateException("Not facing any know direction!");
    }

    public Location left(int blocks) {
        switch (facing) {
            case NORTH:
                return decrZ(blocks);
            case SOUTH:
                return incrZ(blocks);
            case EAST:
                return incrX(blocks);
            case WEST:
                return decrX(blocks);
        }
        throw new IllegalStateException("Not facing any know direction!");
    }

    public Location right(int blocks) {
        switch (facing) {
            case NORTH:
                return incrZ(blocks);
            case SOUTH:
                return decrZ(blocks);
            case EAST:
                return decrX(blocks);
            case WEST:
                return incrX(blocks);
        }
        throw new IllegalStateException("Not facing any know direction!");
    }

    private Location incrX(int blocks) {
        return new Location(start.getWorld(), start.getX() + blocks, start.getY(), start.getZ(), start.getYaw(), start.getPitch());
    }
    private Location decrX(int blocks) {
        return new Location(start.getWorld(), start.getX() - blocks, start.getY(), start.getZ(), start.getYaw(), start.getPitch());
    }
    private Location incrZ(int blocks) {
        return new Location(start.getWorld(), start.getX(), start.getY(), start.getZ() + blocks, start.getYaw(), start.getPitch());
    }
    private Location decrZ(int blocks) {
        return new Location(start.getWorld(), start.getX(), start.getY(), start.getZ() - blocks, start.getYaw(), start.getPitch());
    }

}
