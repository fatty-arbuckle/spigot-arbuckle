package fatty.arbuckle.minecraft.commands;

import org.bukkit.command.CommandSender;

public class Ahoy {
	public static boolean run(CommandSender sender, String label, String[] args) {
        sender.sendMessage("Ahoy there, " + sender.getName() + " !");
        return true;
	}
}
