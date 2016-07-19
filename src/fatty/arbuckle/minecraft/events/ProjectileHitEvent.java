package fatty.arbuckle.minecraft.events;

import fatty.arbuckle.minecraft.Configuration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.projectiles.ProjectileSource;

// TODO: explosive arrows
// TODO: tree arrows
// TODO: Effect arrows? (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html) getWorld().playEffect()

public class ProjectileHitEvent implements Listener {
	@EventHandler
    public void onEvent(org.bukkit.event.entity.ProjectileHitEvent event)
    {
        Configuration.ArrowType arrowType = null;
		Projectile arrow = event.getEntity();
		if (arrow instanceof Arrow) {
            ProjectileSource projectileSource = arrow.getShooter();
            if (projectileSource instanceof Player) {
                Configuration cfg = Configuration.getInstance();
                Player shooter = (Player)projectileSource;
                arrowType = cfg.getArrowType(shooter.getName());

                switch (arrowType) {
                    case FLAMING:
                        // TODO: lessen explosion?
                        arrow.getWorld().createExplosion(arrow.getLocation(), 1, true);

                    case LIGHTNING:
                        arrow.setGlowing(false);
                        arrow.getWorld().strikeLightning(arrow.getLocation());
                        break;

                    case TELEPORT:
                        shooter.teleport(arrow.getLocation());
                        break;
                }
            }
		}
    }
}
