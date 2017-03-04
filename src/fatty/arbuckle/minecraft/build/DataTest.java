package fatty.arbuckle.minecraft.build;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

import static org.junit.Assert.*;

/**
 * Created by kurt on 7/31/16.
 */
public class DataTest {

    Path testDat = null;

    String data00 = ":10:3\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n";

    String data01 = ":10:3\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n";

    String data02 = ":10:3\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n";

    String data03 = ":10:3\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n"
            + "{STONE, AIR, STONE}\n";

    String data04 = ":10:3\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n"
            + "{STONE, STONE, STONE}\n";

    @Before
    public void setUp() throws Exception {
        testDat = Paths.get("test.dat");

        java.nio.file.Files.write(testDat, data00.getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        java.nio.file.Files.write(testDat, "".getBytes("utf-8"), StandardOpenOption.APPEND);
        java.nio.file.Files.write(testDat, data01.getBytes("utf-8"), StandardOpenOption.APPEND);
        java.nio.file.Files.write(testDat, data02.getBytes("utf-8"), StandardOpenOption.APPEND);
        java.nio.file.Files.write(testDat, data03.getBytes("utf-8"), StandardOpenOption.APPEND);
        java.nio.file.Files.write(testDat, data04.getBytes("utf-8"), StandardOpenOption.APPEND);
    }

    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(testDat);
    }

    @Test(expected=RuntimeException.class)
    public void loadTest_fileDoesNotExist() {
        Data.load(Paths.get("this","does","not","exist"));
    }

    @Test
    public void loadTest_goodData() {
        Vector<Data> vec = Data.load(testDat);
        assertEquals("number of levels", vec.size(), 5);
    }
}