package fatty.arbuckle.minecraft;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
	private static Configuration instance = null;

	public enum ArrowType {
		NORMAL, FLAMING, LIGHTNING, TELEPORT, EXPLODING, TREE
	}

	private Map<String, ArrowType> playerArrowType = new HashMap<String, ArrowType>();

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

	public ArrowType getArrowType(String playerName) {
		if (playerArrowType.containsKey(playerName)) {
			return playerArrowType.get(playerName);
		}
		return ArrowType.NORMAL;
	}

	synchronized
	public void setArrowType(String playerName, ArrowType arrowType) {
		playerArrowType.put(playerName, arrowType);
	}
}
