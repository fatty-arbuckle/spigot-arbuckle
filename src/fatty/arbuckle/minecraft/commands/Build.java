package fatty.arbuckle.minecraft.commands;

import fatty.arbuckle.minecraft.build.BuildDat;
import fatty.arbuckle.minecraft.build.Data;
import fatty.arbuckle.minecraft.build.Wall;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

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
                    Material [][] someData = {{Material.STONE}, {}};
                    Data fortData = new Data(15,15, someData);
                    BuildDat.build(target, fortData);

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
