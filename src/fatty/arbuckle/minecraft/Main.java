package fatty.arbuckle.minecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fatty.arbuckle.minecraft.commands.Ahoy;
import fatty.arbuckle.minecraft.commands.Arrow;
import fatty.arbuckle.minecraft.commands.Equip;
import fatty.arbuckle.minecraft.events.EventRegistration;

public class Main extends JavaPlugin {

	@Override
    public void onEnable() {
		// side-effects: registers all of the event listeners
		new EventRegistration(getServer().getPluginManager(), this);
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

        } else {
        	return false;
        }
    }
}
