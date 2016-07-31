package fatty.arbuckle.minecraft.build;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.OptionalDouble;

/**
 * Created by phatty on 7/21/16.
 */
public class Wall {
    private Wall() {
    }

    // TODO build a better wall
    // TODO enhance the drone to set blocks in a tower
    public static void build(Location loc, int length) {

        final int WALL_HEIGHT = 4;

        boolean wantArches = true;

        Drone d = new Drone(loc);
        d.up(WALL_HEIGHT);

        Deque<Integer> heights = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int h = d.buildToGround(Material.STONE);
            d.forward(1);
            heights.addFirst(h);
            while (heights.size() > 3) {
                heights.removeLast();
            }

            if (wantArches && (i%10 == 9)) {

                System.out.println("ARCHES: h=" + Integer.toString(h));

                Drone archDrone = new Drone(d.getLocation());
                archDrone.down(h-1);
                archDrone.backward(6);
                archDrone.setBlock(Material.AIR);
                archDrone.forward(1);
                archDrone.setBlock(Material.AIR);
                archDrone.forward(1);
                archDrone.setBlock(Material.AIR);
                archDrone.up(1);
                archDrone.setBlock(Material.AIR);
                archDrone.backward(1);
                archDrone.setBlock(Material.AIR);
                archDrone.backward(1);
                archDrone.setBlock(Material.AIR);
                archDrone.up(1);
                archDrone.forward(1);
                archDrone.setBlock(Material.AIR);
            }

            if (heights.size() == 3) {
                OptionalDouble average = heights.stream().mapToInt(a -> a).average();

                StringBuilder sb = new StringBuilder();
                for (Integer e : heights) {
                    sb.append(",").append(e.toString());
                }
                //System.out.println("Heights: " + sb + " (" + new Double(average.getAsDouble()).toString() + ")");

                if (average.getAsDouble() > WALL_HEIGHT + 1) {
                    d.down(1);
                } else if (average.getAsDouble() < WALL_HEIGHT - 1) {
                    d.up(1);
                }
            }
        }
    }
}
