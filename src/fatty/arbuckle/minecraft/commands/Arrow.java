package fatty.arbuckle.minecraft.commands;

import org.bukkit.command.CommandSender;

import fatty.arbuckle.minecraft.Configuration;
import fatty.arbuckle.minecraft.Configuration.ArrowType;
import org.bukkit.potion.PotionEffectType;

public class Arrow {

	private static void setArrowType(CommandSender sender, Configuration.ArrowType type) {
		Configuration.getInstance().setArrowType(sender.getName(), type);
        sender.sendMessage("Arrows set to '" + type.toString() + "'");
	}

	private static void setArrowType(CommandSender sender, PotionEffectType type) {
		Configuration.getInstance().setArrowType(sender.getName(), ArrowType.POTION);
		Configuration.getInstance().setArrowPotionType(sender.getName(), type);
		sender.sendMessage("Arrows set to '" + type.toString() + "'");
	}

	public static boolean run(CommandSender sender, String label, String[] args) {
		try {
			if (args.length == 0) {
				setArrowType(sender, Configuration.ArrowType.NORMAL);
			} else if (args.length == 1) {
				String arrowTypeString = args[0].toUpperCase();
				String arrowSecondaryTypeString = null;
				if (args[0].contains(":")) {
					String[] types = args[0].split(":");
					arrowTypeString = types[0].toUpperCase();

					if (Configuration.ArrowType.valueOf(arrowTypeString) == ArrowType.POTION) {
						arrowSecondaryTypeString = types[1].toUpperCase();
						PotionEffectType potionEffectType = PotionEffectType.getByName(arrowSecondaryTypeString);
						setArrowType(sender, potionEffectType);
					} else {
						throw new IllegalArgumentException();
					}

				} else {
					Configuration.ArrowType arrowType = Configuration.ArrowType.valueOf(arrowTypeString);
					setArrowType(sender, arrowType);
				}
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

//			arrowTypeList = "";
//			for (PotionEffectType t : PotionEffectType.values()) {
//				arrowTypeList += t.toString() + " ";
//			}
//			sender.sendMessage("Potion arrow type must be one of: " + arrowTypeList);

		}

		return true;
	}
}
