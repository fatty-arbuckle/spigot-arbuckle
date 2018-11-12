package fatty.arbuckle.minecraft.events;

import fatty.arbuckle.minecraft.Configuration;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.TreeType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;

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
                    case EXPLODING:
                        arrow.getWorld().createExplosion(arrow.getLocation(), 1, true);
                        break;

                    // case NUKE:
                    //     if ((new Random()).nextInt(50) == 42) {
                    //         arrow.getWorld().createExplosion(arrow.getLocation(), 50, true);
                    //     }
                    //     break;

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

                    case TREE:
												TreeType[] treeTypes = TreeType.values();
												int tree = (new Random()).nextInt(treeTypes.length);
                        arrow.getWorld().generateTree(arrow.getLocation(), treeTypes[tree]);
                        break;

                    case ICE:
                        Block middle = arrow.getWorld().getBlockAt(arrow.getLocation());

                        int radius = 1;
                        middle.setType(Material.ICE);
                        for (int x = radius; x >= -radius; x--) {
                            for (int y = radius; y >= -radius; y--) {
                                for (int z = radius; z >= -radius; z--) {
                                    middle.getRelative(x, y, z).setType(Material.ICE);
                                }
                            }
                        }
                        break;

                    case LAVA:
                        Block block = arrow.getWorld().getBlockAt(arrow.getLocation());
												Material oldType = block.getType();
                        block.setType(Material.LAVA);

												new BukkitRunnable() {
												        public void run() {
												            block.setType(oldType);
												        }
												    }.runTaskLater(arrow.getServer().getPluginManager().getPlugin("Fatty.Arbuckle"), 100);

                        break;

										case POTION:

												Entity target = event.getHitEntity();
												if (target != null && target instanceof LivingEntity) {
													PotionEffectType effectType = cfg.getArrowPotionType(shooter.getName());
													((LivingEntity)target).addPotionEffect(new PotionEffect​(effectType, 100, 1));
												}
												break;
                }
            }
		}
    }
}
