package fatty.arbuckle.minecraft.commands;

import fatty.arbuckle.minecraft.build.BuildDat;
import fatty.arbuckle.minecraft.build.Data;
import fatty.arbuckle.minecraft.build.Wall;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

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

                Location target = player.getTargetBlock((Set<Material>)null, 25).getLocation();
                target.setYaw(player.getLocation().getYaw());  // does the block already have the right yaw?

                if (args[0].equalsIgnoreCase("wall")) {
                    Integer length = new Integer(15);
                    if (args.length >= 2) {
                        length = new Integer(args[1]);
                    }

                    Wall.build(target, length);

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

                    BuildDat.build(target, new Data(15,15, level00));
                    BuildDat.build(target, new Data(15,15, level01));
                    BuildDat.build(target, new Data(15,15, level02));
                    BuildDat.build(target, new Data(15,15, level03));
                    BuildDat.build(target, new Data(15,15, level04));
                    BuildDat.build(target, new Data(15,15, level05));

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
