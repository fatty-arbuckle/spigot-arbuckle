package fatty.arbuckle.minecraft.build;

import org.bukkit.Material;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;


/**
 * Created by kurt on 7/31/16.
 */
public class Data {
    private int mFwd = 0;
    private int mSide = 0;
    private Material[][] data = null;

    public static Vector<Data> load(Path datPath) {
        Vector loaded = new Vector();

        int tmpFwd = 0;
        int tmpSide = 0;
        Material [][] tmpMaterials = null;
        String tmpName = "";

        if (datPath.toFile().exists()) {
            try {
                int currentFwd = 0;
                for (Object o : Files.lines(datPath).toArray()) {
                    String s = (String)o;
                    if (s.startsWith(":")) {

                        if (tmpMaterials != null) {
                            System.out.println("adding dat: [" + tmpName + "]");
                            loaded.add(new Data(tmpFwd, tmpSide, tmpMaterials));
                        }

                        String[] values = s.split(":");
                        if (values.length == 4) {
                            tmpFwd = Integer.valueOf(values[1]);
                            tmpSide = Integer.valueOf(values[2]);
                            tmpMaterials = new Material[tmpFwd][tmpSide];
                            tmpName = values[3];
                            currentFwd = 0;
                        } else {
                            tmpMaterials = null;
                        }
                    } else if (s.startsWith("{")) {
                        if (tmpMaterials != null) {
                            String line = s.replaceAll("[\\{\\}]", "");
                            String[] blocks = line.split(",");

                            if (blocks.length != tmpSide) {
                                throw new RuntimeException("Too many columns for declaration [" + tmpName + "]");
                            }

                            if (currentFwd >= tmpFwd) {
                                throw new RuntimeException("Too many rows for declaration [" + tmpName + "]");
                            }

                            for (int i = 0; i < blocks.length; i++) {
                                String material = blocks[i].trim();
                                if (!material.isEmpty()) {
                                    tmpMaterials[currentFwd][i] = Material.valueOf(material);
                                } else {
                                    tmpMaterials[currentFwd][i] = null;
                                }
                            }
                            currentFwd += 1;
                        }
                    }
                }

                if (tmpMaterials != null) {
                    System.out.println("adding dat: [" + tmpName + "]");
                    loaded.add(new Data(tmpFwd, tmpSide, tmpMaterials));
                }
            } catch (IOException e) {
                throw new RuntimeException("Problem processing: " + datPath.toAbsolutePath());
            }
        } else {
            throw new RuntimeException("No such dat file for building: " + datPath.toAbsolutePath());
        }

        return loaded;
    }

    public Data(int fwd, int side, Material[][] data) {
        this.mFwd = fwd;
        this.mSide = side;
        this.data = data;
    }

    public int getMaxFwd() {
        return mFwd;
    }

    public int getMaxSide() {
        return mSide;
    }

    public Material getMaterial(int fwd, int side) {
        return data[fwd][side];
    }
}