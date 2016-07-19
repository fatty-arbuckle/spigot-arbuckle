package fatty.arbuckle.minecraft.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

// TODO: explosive arrows
// TODO: tree arrows
// TODO: Effect arrows? (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html) getWorld().playEffect()

public class ProjectileHitEvent implements Listener {
	@EventHandler
    public void onEvent(org.bukkit.event.entity.ProjectileHitEvent event)
    {
		Projectile arrow = event.getEntity();
		if (arrow instanceof Arrow) {
			if (arrow.isGlowing()) {
				arrow.setGlowing(false);
				arrow.getWorld().strikeLightning(arrow.getLocation());
			} else if (arrow.getFireTicks() > 0) {
				// TODO: lessen explosion?
				arrow.getWorld().createExplosion(arrow.getLocation(), 1, true);
			}
		}
    }
}
