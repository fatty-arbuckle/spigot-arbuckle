package fatty.arbuckle.minecraft.commands;

import fatty.arbuckle.minecraft.Configuration;
import fatty.arbuckle.minecraft.build.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.nio.file.Path;
import java.util.Set;
import java.util.Vector;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.STONE;

/**
 * Created by phatty on 7/21/16.
 */
public class Build {
    public static boolean run(CommandSender sender, String label, String[] args) {
        if (args.length >= 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                Location target = player.getTargetBlock((Set<Material>)null, 25).getLocation().clone();
                target.setYaw(player.getLocation().getYaw());  // does the block already have the right yaw?

                if (args[0].equalsIgnoreCase("wall")) {
                    Integer length = new Integer(15);
                    if (args.length >= 2) {
                        length = new Integer(args[1]);
                    }

                    Wall.build(target, length);

                } else if (args[0].equalsIgnoreCase("chest")) {
                    RandomChest.build(player, target);

                } else if (args[0].equalsIgnoreCase("machine_gun")) {
                    MachineGun.build(player);

                } else if (args[0].equalsIgnoreCase("fort")) {
                    Material [][] level00 = {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                    Material [][] level01= {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                    Material [][] level02= {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                    Material [][] level03= {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                    Material [][] level04= {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR,   AIR, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                    Material [][] level05 = {
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE},
                            {STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE, STONE}
                    };
                } else if (args[0].equalsIgnoreCase("dat")) {

                    if (args.length >= 2) {
                        String datThing = args[1];

                        Drone d = new Drone(target);
                        Path datPath = Configuration.getInstance().getDatData(datThing);

                        try {
                            Vector<Data> datData = Data.load(datPath);

                            for (Data dat : datData) {
                                d.buildFromDat(dat);
                                d.up(1);
                            }
                        } catch (Exception e) {
                            System.out.println("build dat error: " + e.getMessage());
                        }
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            } else {
                System.out.println(sender.getName() + " is not a player and cannot build things!");
                return false;
            }
        } else {
            System.out.println("BAD ARGS!!");
            return false;
        }

        return true;
    }
}
