package fatty.arbuckle.minecraft.util;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.bukkit.entity.Player;
import org.bukkit.Location;
import java.util.Set;



/**
 * Created by phatty on 12/28/17.
 */
public class PlayerUtil {

    public static void addIfDoesnt(Inventory inventory, Material item, int count) {
        if (!inventory.contains(item, count)) {
            inventory.addItem(new ItemStack(item, count));
        }
    }

    public static Location findOpenSpace(Player p) {
      final int RANGE = 20;

      // Return where player is looking
      Location target = p.getTargetBlock((Set<Material>)null, RANGE).getLocation();

      // Find the ground
      int i=0;
      while(i<RANGE && target.getBlock().getType() == Material.AIR) {
        target = target.subtract(0, 1, 0);
        i--;
      }

      return target.add(0,1,0);
    }

}
