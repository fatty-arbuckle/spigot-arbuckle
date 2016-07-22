package fatty.arbuckle.minecraft.build;

import org.bukkit.Location;
import org.bukkit.Material;

/**
 * Created by phatty on 7/21/16.
 */
public class Wall {
    private Wall() {
    }

    // TODO build a better wall
    // TODO enhance the drone to set blocks in a tower
    public static void build(Location loc, int length) {
        Drone d = new Drone(loc);
        for (int i = 0; i < length; i++) {
            d.setBlock(Material.STONE);
            d.up(1);
            d.setBlock(Material.STONE);
            d.up(1);
            d.setBlock(Material.STONE);
            d.down(2);
            d.forward(1);
        }
    }
}
