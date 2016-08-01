package fatty.arbuckle.minecraft;

import org.bukkit.potion.PotionEffectType;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
	private static Configuration instance = null;

	public enum ArrowType {
		NORMAL, FLAMING, LIGHTNING, TELEPORT, EXPLODING, POTION
	}

	private Map<String, ArrowType> playerArrowType = new HashMap<String, ArrowType>();
	private Map<String, PotionEffectType> playerArrowPotionType = new HashMap<String, PotionEffectType>();
	private String datDirectory = null;

	protected Configuration() {

	}

	public static Configuration getInstance() {
		if (instance == null) {
			synchronized (Configuration.class) {
				if (instance == null) {
					instance = new Configuration();
				}
			}
		}
		return instance;
	}

	public void setDatDirectory(String datDirectory) {
		this.datDirectory = datDirectory;
	}

	public Path getDatData(String datName) {
		return Paths.get(datDirectory, datName + ".dat");
	}

	public ArrowType getArrowType(String playerName) {
		if (playerArrowType.containsKey(playerName)) {
			return playerArrowType.get(playerName);
		}
		return ArrowType.NORMAL;
	}

	public PotionEffectType getArrowPotionType(String playerName) {
		if (playerArrowPotionType.containsKey(playerName)) {
			return playerArrowPotionType.get(playerName);
		}
		return PotionEffectType.POISON;
	}

	synchronized
	public void setArrowType(String playerName, ArrowType arrowType) {
		playerArrowType.put(playerName, arrowType);
	}

	synchronized
	public void setArrowPotionType(String playerName, PotionEffectType type) {
		playerArrowPotionType.put(playerName, type);
	}
}
