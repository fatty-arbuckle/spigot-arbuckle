package fatty.arbuckle.minecraft.commands;

import org.bukkit.command.CommandSender;

import fatty.arbuckle.minecraft.Configuration;
import fatty.arbuckle.minecraft.Configuration.ArrowType;

public class Arrow {

	private static void setArrowType(CommandSender sender, Configuration.ArrowType type) {
		Configuration.getInstance().setArrowType(sender.getName(), type);
        sender.sendMessage("Arrows set to '" + type.toString() + "'");
	}

	public static boolean run(CommandSender sender, String label, String[] args) {
		try {
			if (args.length == 0) {
				setArrowType(sender, Configuration.ArrowType.NORMAL);
			} else if (args.length == 1) {
				Configuration.ArrowType arrowType = Configuration.ArrowType.valueOf(args[0].toUpperCase());
				setArrowType(sender, arrowType);
			}
			else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			String arrowTypeList = "";
			for (ArrowType t : Configuration.ArrowType.values()) {
				arrowTypeList += t.toString() + " ";
			}
			sender.sendMessage("Arrow type must be one of: " + arrowTypeList);
		}

		return true;
	}
}
