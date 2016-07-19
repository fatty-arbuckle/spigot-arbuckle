package fatty.arbuckle.minecraft.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.projectiles.ProjectileSource;

import fatty.arbuckle.minecraft.Configuration;
import fatty.arbuckle.minecraft.Configuration.ArrowType;

public class ProjectileLaunchEvent implements Listener {
	@EventHandler
    public void onEvent(org.bukkit.event.entity.ProjectileLaunchEvent event)
    {
		Projectile arrow = event.getEntity();
		if (arrow instanceof Arrow) {
			ProjectileSource source = arrow.getShooter();
			if (source instanceof Player) {
				Player player = (Player)source;
				Configuration cfg = Configuration.getInstance();
				ArrowType arrowType = cfg.getArrowType(player.getName());
				if (arrowType == Configuration.ArrowType.FLAMING) {
					arrow.setFireTicks(20 * 60);
				}
				else if (arrowType == Configuration.ArrowType.LIGHTNING) {
					arrow.setGlowing(true);
				}
			}
		}
    }
}
