package fatty.arbuckle.minecraft.build;

import org.bukkit.Material;

/**
 * Created by kurt on 7/31/16.
 */
public class Data {
    private int mX = 10;
    private int mY = 10;
    private Material[][] data = null;

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