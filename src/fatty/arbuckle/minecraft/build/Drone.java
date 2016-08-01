package fatty.arbuckle.minecraft.build;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.omg.CORBA.LocalObject;

import static fatty.arbuckle.minecraft.build.Drone.Direction.*;

/**
 * Created by phatty on 7/21/16.
 *
 * * Drone always lives in its own compass orientation so forward is north
 *
 */
public class Drone {

    public enum Direction { NORTH, EAST, SOUTH, WEST, LOST }

    // holds the start location in case we want to go back
    Location start = null;

    // current location of the drone
    Location current = null;
    Direction facing = NORTH;

    public Drone(Location loc) {
        start = loc.clone();
        current = start.clone();
        facing = setDirection(loc.getYaw());
    }

    public void buildFromDat(Data dat) {
        World w = start.getWorld();
        Location checkpoint = current.clone();

        for (int dFwd = dat.getMaxFwd() - 1; dFwd >= 0; dFwd--) {
            for (int dSide = 0; dSide < dat.getMaxSide(); dSide++) {
                current = checkpoint.clone();
                forward(dat.getMaxFwd() - 1 - dFwd);
                right(dSide);
                Material m = dat.getMaterial(dFwd, dSide);
                if (m != null) {
                    w.getBlockAt(current).setType(m);
                }
            }
        }

        current = checkpoint.clone();
    }

    public void setBlock(Material m) {
        start.getWorld().getBlockAt(current).setType(m);
    }

    public int buildToGround(Material m) {
        setBlock(m);
        Location tmp = current.clone();

        int h = 1;

        boolean liquid = true;
        boolean empty = true;
        boolean grassy = true;
        while (empty || liquid || grassy) {
            tmp.subtract(0, 1, 0);
            Block b = start.getWorld().getBlockAt(tmp);

            //new HangingPlaceEvent(hanging, player, b, face);

 //           BlockFace face = b.getFace(b);

   //         ItemStack foo = new ItemStack(Material.TORCH);
     //       ItemMeta itemMeta = foo.getItemMeta();
       //     itemMeta.

            liquid = b.isLiquid();
            empty = b.isEmpty();
            grassy = b.getType() == Material.GRASS
                    || b.getType() == Material.LONG_GRASS
                    || b.getType() == Material.DOUBLE_PLANT
                    || b.getType() == Material.RED_ROSE;

            if (liquid || empty || grassy) {
                b.setType(m);
            } else {
                System.out.println("Bottom block: " + b.toString());
            }

            if (empty || grassy) {
                h++;
            }
        }

        return h;
    }

    public Location getLocation() {
        return current.clone();
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
                current = incrX(blocks);
                break;
            case SOUTH:
                current = decrX(blocks);
                break;
            case EAST:
                current = incrZ(blocks);
                break;
            case WEST:
                current = decrZ(blocks);
                break;
            default:
                throw new IllegalStateException("Not facing any know direction!");
        }
        return current;
    }

    public Location backward(int blocks) {
        switch (facing) {
            case NORTH:
                current = decrX(blocks);
                break;
            case SOUTH:
                current = incrX(blocks);
                break;
            case EAST:
                current = decrZ(blocks);
                break;
            case WEST:
                current = incrZ(blocks);
                break;
            default:
                throw new IllegalStateException("Not facing any know direction!");
        }
        return current;
    }

    public Location left(int blocks) {
        switch (facing) {
            case NORTH:
                current = decrZ(blocks);
                break;
            case SOUTH:
                current = incrZ(blocks);
                break;
            case EAST:
                current = incrX(blocks);
                break;
            case WEST:
                current = decrX(blocks);
                break;
            default:
                throw new IllegalStateException("Not facing any know direction!");
        }
        return current;
    }

    public Location right(int blocks) {
        switch (facing) {
            case NORTH:
                current = incrZ(blocks);
                break;
            case SOUTH:
                current = decrZ(blocks);
                break;
            case EAST:
                current = decrX(blocks);
                break;
            case WEST:
                current = incrX(blocks);
                break;
            default:
                throw new IllegalStateException("Not facing any know direction!");
        }
        return current;
    }

    // TODO add unit tests
    public Location up(int blocks) {
        current = new Location(current.getWorld(), current.getX(), current.getY() + blocks, current.getZ(), current.getYaw(), current.getPitch());
        return current;
    }

    // TODO add unit tests
    public Location down(int blocks) {
        current = new Location(current.getWorld(), current.getX(), current.getY() - blocks, current.getZ(), current.getYaw(), current.getPitch());
        return current;
    }

    private Location incrX(int blocks) {
        return new Location(current.getWorld(), current.getX() + blocks, current.getY(), current.getZ(), current.getYaw(), current.getPitch());
    }
    private Location decrX(int blocks) {
        return new Location(current.getWorld(), current.getX() - blocks, current.getY(), current.getZ(), current.getYaw(), current.getPitch());
    }
    private Location incrZ(int blocks) {
        return new Location(current.getWorld(), current.getX(), current.getY(), current.getZ() + blocks, current.getYaw(), current.getPitch());
    }
    private Location decrZ(int blocks) {
        return new Location(current.getWorld(), current.getX(), current.getY(), current.getZ() - blocks, current.getYaw(), current.getPitch());
    }

}
