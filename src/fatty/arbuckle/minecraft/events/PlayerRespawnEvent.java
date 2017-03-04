package fatty.arbuckle.minecraft.events;

import fatty.arbuckle.minecraft.Configuration;
import fatty.arbuckle.minecraft.commands.Equip;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.projectiles.ProjectileSource;


/**
 * Created by phatty on 7/31/16.
 */
public class PlayerRespawnEvent implements Listener {

    public PlayerRespawnEvent() {
        System.out.println("Registering listener for PlayerRespawnEvent");
    }

    @EventHandler
    public void onEvent(org.bukkit.event.player.PlayerRespawnEvent event) {
        Entity entity = event.getPlayer();
        Equip.run((Player) entity, "", new String[]{});
    }
}
