package fatty.arbuckle.minecraft.events;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegistration {
	public EventRegistration(PluginManager pm, JavaPlugin plugin) {
		pm.registerEvents(new ProjectileHitEvent(), plugin);
		pm.registerEvents(new ProjectileLaunchEvent(), plugin);
		pm.registerEvents(new PlayerRespawnEvent(), plugin);
	}
}
