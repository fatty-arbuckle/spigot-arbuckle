package fatty.arbuckle.minecraft.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Set;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

import fatty.arbuckle.minecraft.util.PlayerUtil;


/**
 * Created by phatty on 7/31/16.
 */
public class Spawn {

  private static List<String> NAMES = Arrays.asList(new String[] {
    "Aragog", "Bane", "Beedle the Bard", "The Bloody Baron", "Bogrod",
    "Buckbeak", "Sir Cadogan", "Crookshanks", "Dobby", "Errol", "Fang",
    "Fawkes", "Firenze", "Fluffy", "Gornuk", "Grawp", "Griphook", "Hedwig",
    "Hokey", "Kreacher", "Magorian", "Great Aunt Muriel", "Nagini",
    "Nearly Headless Nick", "Norbert", "Peeves", "Pigwidgeon",
    "Madam Rosmerta", "Ronan", "Scabbers", "Scabior", "Travers", "Trevor",
    "Winky"
  });

  private static int nameIndex = 0;

  {
    Collections.shuffle(NAMES);
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
          Entity spawnee = theWorld.spawnEntity(PlayerUtil.findOpenSpace(targetPlayer), entityType);
          spawnee.setCustomName(getCreatureName());
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

  private static String getCreatureName() {
    nameIndex++;
    nameIndex = nameIndex % NAMES.size();
    return NAMES.get(nameIndex);
  }
}
