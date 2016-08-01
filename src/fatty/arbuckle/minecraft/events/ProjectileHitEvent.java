package fatty.arbuckle.minecraft.events;

import fatty.arbuckle.minecraft.Configuration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

// TODO: tree arrows
// TODO: Effect arrows? (https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html) getWorld().playEffect()

public class ProjectileHitEvent implements Listener {

    public ProjectileHitEvent() {
        System.out.println("Registering listener for ProjectileHitEvent");
    }

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
                    case EXPLODING:
                        arrow.getWorld().createExplosion(arrow.getLocation(), 1, true);
                        break;

                    case FLAMING:
                        arrow.getWorld().createExplosion(arrow.getLocation(), (float)0.25, true);
                        break;

                    case LIGHTNING:
                        arrow.setGlowing(false);
                        arrow.getWorld().strikeLightning(arrow.getLocation());
                        break;

                    case TELEPORT:
                        shooter.teleport(arrow.getLocation());
                        break;

                    case POTION:
                        PotionEffectType type = cfg.getArrowPotionType(shooter.getName());
                        PotionEffect effect = new PotionEffect(type, 15 * 20, 10, false, true);
                        shooter.addPotionEffect(effect);
                        break;
                }
            }
		}
    }
}
