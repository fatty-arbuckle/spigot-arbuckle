package fatty.arbuckle.minecraft.build;

import static org.junit.Assert.assertEquals;

import org.bukkit.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by phatty on 7/21/16.
 */
public class DroneTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    private Drone createDroneWithYaw(Float yaw) {
        return new Drone(new Location(null, 0, 0, 0, yaw, 0));
    }

    @Test
    public void setDirectionTest_North() {
        Float yaw = new Float(225.0);
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 14.999;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.NORTH, createDroneWithYaw(yaw).getDirection());
    }

    @Test
    public void setDirectionTest_East() {
        Float yaw = new Float(315.0);
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw = (float) 0.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 14.999;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.EAST, createDroneWithYaw(yaw).getDirection());
    }

    @Test
    public void setDirectionTest_South() {
        Float yaw = new Float(45.0);
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 14.999;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.SOUTH, createDroneWithYaw(yaw).getDirection());
    }

    @Test
    public void setDirectionTest_West() {
        Float yaw = new Float(135.0);
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 15.0;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
        yaw += (float) 14.999;
        assertEquals("Testing " + yaw.toString() + " degrees", Drone.Direction.WEST, createDroneWithYaw(yaw).getDirection());
    }

    @Test
    public void northFacingTest() {
        Drone d = new Drone(new Location(null, 10, 10, 10, (float)270.0, 0));
        Location loc1 = d.forward(5);
        assertEquals("Testing moving forward while facing north (X location)", loc1.getBlockX(), 15);
        assertEquals("Testing moving forward while facing north (Z location)", loc1.getBlockZ(), 10);
        Location loc2 = d.backward(5);
        assertEquals("Testing moving backward while facing north (X location)", loc2.getBlockX(), 10);
        assertEquals("Testing moving backward while facing north (Z location)", loc2.getBlockZ(), 10);
        Location loc3 = d.left(5);
        assertEquals("Testing moving left while facing north (X location)", loc3.getBlockX(), 10);
        assertEquals("Testing moving left while facing north (Z location)", loc3.getBlockZ(), 5);
        Location loc4 = d.right(5);
        assertEquals("Testing moving right while facing north (X location)", loc4.getBlockX(), 10);
        assertEquals("Testing moving right while facing north (Z location)", loc4.getBlockZ(), 10);
    }

    @Test
    public void southFacingTest() {
        Drone d = new Drone(new Location(null, 10, 10, 10, (float)90.0, 0));
        Location loc1 = d.forward(5);
        assertEquals("Testing moving forward while facing south (X location)", loc1.getBlockX(), 5);
        assertEquals("Testing moving forward while facing south (Z location)", loc1.getBlockZ(), 10);
        Location loc2 = d.backward(5);
        assertEquals("Testing moving backward while facing south (X location)", loc2.getBlockX(), 10);
        assertEquals("Testing moving backward while facing south (Z location)", loc2.getBlockZ(), 10);
        Location loc3 = d.left(5);
        assertEquals("Testing moving left while facing south (X location)", loc3.getBlockX(), 10);
        assertEquals("Testing moving left while facing south (Z location)", loc3.getBlockZ(), 15);
        Location loc4 = d.right(5);
        assertEquals("Testing moving right while facing south (X location)", loc4.getBlockX(), 10);
        assertEquals("Testing moving right while facing south (Z location)", loc4.getBlockZ(), 10);
    }

    @Test
    public void eastFacingTest() {
        Drone d = new Drone(new Location(null, 10, 10, 10, (float)0.0, 0));
        Location loc1 = d.forward(5);
        assertEquals("Testing moving forward while facing south (X location)", loc1.getBlockX(), 10);
        assertEquals("Testing moving forward while facing south (Z location)", loc1.getBlockZ(), 15);
        Location loc2 = d.backward(5);
        assertEquals("Testing moving backward while facing south (X location)", loc2.getBlockX(), 10);
        assertEquals("Testing moving backward while facing south (Z location)", loc2.getBlockZ(), 10);
        Location loc3 = d.left(5);
        assertEquals("Testing moving left while facing south (X location)", loc3.getBlockX(), 15);
        assertEquals("Testing moving left while facing south (Z location)", loc3.getBlockZ(), 10);
        Location loc4 = d.right(5);
        assertEquals("Testing moving right while facing south (X location)", loc4.getBlockX(), 10);
        assertEquals("Testing moving right while facing south (Z location)", loc4.getBlockZ(), 10);
    }

    @Test
    public void westFacingTest() {
        Drone d = new Drone(new Location(null, 10, 10, 10, (float)180.0, 0));
        Location loc1 = d.forward(5);
        assertEquals("Testing moving forward while facing south (X location)", loc1.getBlockX(), 10);
        assertEquals("Testing moving forward while facing south (Z location)", loc1.getBlockZ(), 5);
        Location loc2 = d.backward(5);
        assertEquals("Testing moving backward while facing south (X location)", loc2.getBlockX(), 10);
        assertEquals("Testing moving backward while facing south (Z location)", loc2.getBlockZ(), 10);
        Location loc3 = d.left(5);
        assertEquals("Testing moving left while facing south (X location)", loc3.getBlockX(), 5);
        assertEquals("Testing moving left while facing south (Z location)", loc3.getBlockZ(), 10);
        Location loc4 = d.right(5);
        assertEquals("Testing moving right while facing south (X location)", loc4.getBlockX(), 10);
        assertEquals("Testing moving right while facing south (Z location)", loc4.getBlockZ(), 10);
    }
}