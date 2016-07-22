package fatty.arbuckle.minecraft.commands;

import fatty.arbuckle.minecraft.build.Wall;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

                // TODO handle wall vs other builds
                //if (args[0] == "wall") {
                    System.out.println("Building it here, boss.");

                    // TODO get wall length as args[1]
                    Wall.build(target, 10);
                //}

                return true;
            } else {
                System.out.println(sender.getName() + " is not a player and cannot build things!");
                return false;
            }
        } else {
            System.out.println("BAD ARGS!!");
            return false;
        }
    }
}
