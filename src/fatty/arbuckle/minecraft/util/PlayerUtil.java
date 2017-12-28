package fatty.arbuckle.minecraft.util;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by phatty on 12/28/17.
 */
public class PlayerUtil {

    public static void addIfDoesnt(Inventory inventory, Material item, int count) {
        if (!inventory.contains(item, count)) {
            inventory.addItem(new ItemStack(item, count));
        }
    }

}
