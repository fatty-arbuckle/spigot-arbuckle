package fatty.arbuckle.minecraft.build;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by kurt on 7/31/16.
 */
public class BuildDat {

    private BuildDat() {
    }

    public static void build(Location loc, Data data) {
        World w = loc.getWorld();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        for (int dx = 0; dx < data.getMaxX(); dx++) {
            for (int dz = 0; dz < data.getMaxY(); dz++) {
                try {
                    w.getBlockAt(x + dx, y, z + dz).setType(data.getMaterial(x + dx, z + dz));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
