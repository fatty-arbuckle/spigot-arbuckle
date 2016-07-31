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

    public class Data {
        private int mX = 10;
        private int mY = 10;
        private Material [][] data = null;

        public Data(int x, int y, Material[][] data) {
            this.mX = x;
            this.mY = y;
            this.data = data;
        }

        public int getMaxX() {
            return mX;
        }

        public int getMaxY() {
            return mY;
        }

        public Material getMaterial(int x, int y) {
            return data[x][y];
        }
    }

    private BuildDat() {
    }

    public static void build(Location loc, Data data) {
        World w = loc.getWorld();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        for (int dx = 0; dx < data.getMaxX(); dx++) {
            for (int dz = 0; dz < data.getMaxY(); dz++) {
                w.getBlockAt(x + dx, y, z + dz).setType(data.getMaterial(x+dx, z+dz));
            }
        }
    }
}
