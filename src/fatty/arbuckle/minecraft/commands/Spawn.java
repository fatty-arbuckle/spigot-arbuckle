package fatty.arbuckle.minecraft.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Set;

/**
 * Created by phatty on 7/31/16.
 */
public class Spawn {

    private static Location findOpenSpace(Player p) {
        return p.getTargetBlock((Set<Material>)null, 20).getLocation();
    }

    public static boolean run(CommandSender sender, String label, String[] args) {
        if (args.length >= 1) {

            Player targetPlayer = sender.getServer().getPlayer(args[0]);

            if (targetPlayer != null) {

                EntityType entityType = EntityType.SKELETON;
                if (args.length >= 2) {
                    entityType = EntityType.valueOf(args[1].toUpperCase());
                }


                int count = 10;
                if (args.length >= 3) {
                    count = Integer.valueOf(args[2]);
                }

                World theWorld = targetPlayer.getWorld();

                for (int i = 0; i < count; i++) {
                    Entity spawnee = theWorld.spawnEntity(findOpenSpace(targetPlayer), entityType);
                    spawnee.setCustomName("Sparky");
                    spawnee.setCustomNameVisible(true);
                    if (spawnee instanceof Creature) {
                        // spawnee.setGlowing(true);
                        ((Creature)spawnee).setTarget(targetPlayer);

                    } else {
                        System.out.println("Spawned a skeleton, but dod not get a skeleton!");
                        return false;
                    }
                }

            } else {
                System.out.println(args[0] + " is not a player!");
                return false;
            }
        } else {
            System.out.println("BAD ARGS!!");
            return false;
        }

        return true;
    }
}
