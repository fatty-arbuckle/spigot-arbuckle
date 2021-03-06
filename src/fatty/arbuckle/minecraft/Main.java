package fatty.arbuckle.minecraft;

import fatty.arbuckle.minecraft.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fatty.arbuckle.minecraft.events.EventRegistration;

public class Main extends JavaPlugin {

	@Override
    public void onEnable() {
			getLogger().info("");
			getLogger().info("     ───────████████████████████         ");
			getLogger().info("     ────████▀────────────────▀████      ");
			getLogger().info("     ──███▀──────────────────────▀███     ");
			getLogger().info("  F  ─██▀──────────────────────────▀██    ");
			getLogger().info("  A  █▀──────────────────────────────▀█   ");
			getLogger().info("  T  █───█████────────────────█████───█   ");
			getLogger().info("  T  █──██▓▓▓███────────────███▓▓▓██──█   ");
			getLogger().info("  Y  █──██▓▓▓▓▓██──────────██▓▓▓▓▓██──█   ");
			getLogger().info("     █──██▓▓▓▓▓▓██────────██▓▓▓▓▓▓██──█   ");
			getLogger().info("     █▄──████▓▓▓▓██──────██▓▓▓▓████──▄█   ");
			getLogger().info("  A  ▀█▄───▀███▓▓▓██────██▓▓▓███▀───██▀   ");
			getLogger().info("  R  ──█▄────▀█████▀────▀█████▀───▄█▀     ");
			getLogger().info("  B  ─▄██──────────▄█─█▄──────────███▄    ");
			getLogger().info("  U  ─███──────────██─██───────────███    ");
			getLogger().info("  C  ─███──────────────────────────███    ");
			getLogger().info("  K  ──▀██──██▀██──█──█──█──██▀██──██▀    ");
			getLogger().info("  L  ────▀███▀─██──█──█──█──██──████▀     ");
			getLogger().info("  E  ─────▀█▀──██──█──█──█──██──▀██▀      ");
			getLogger().info("     ──────────██──█──█──█──██            ");
			getLogger().info("     ───────────█▄▄█▄▄█▄▄█▄▄█             ");
			getLogger().info("");

			// side-effects: registers all of the event listeners
			new EventRegistration(getServer().getPluginManager(), this);
      Configuration.getInstance().setDatDirectory(this.getDataFolder().getAbsolutePath());
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {

        if (command.getName().equalsIgnoreCase("ahoy")) {
        	return Ahoy.run(sender, label, args);

        } else if (command.getName().equalsIgnoreCase("equip")) {
        	return Equip.run(sender, label, args);

        } else if (command.getName().equalsIgnoreCase("arrow")) {
        	return Arrow.run(sender, label, args);

        } else if (command.getName().equalsIgnoreCase("build")) {
            return Build.run(sender, label, args);

        } else if (command.getName().equalsIgnoreCase("spawn")) {
            return Spawn.run(sender, label, args);

				} else if (command.getName().equalsIgnoreCase("steed")) {
            return Steed.run(sender, label, args);

        } else {
        	return false;
        }
    }
}
