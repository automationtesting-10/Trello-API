package josue.rodriguez;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import java.util.Arrays;

/**
 * This class is use for testing of MexicanWave class.
 *
 * @author JosueRodriguez.
 */
public class MexicanWaveTest {

    /**
     * This test verify that MexicanWave class.
     */
    @Test
    public void basicTest1() {
        String[] result = new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"};
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result,
                MexicanWave.wave("hello"));
    }

    /**
     * This test verify that MexicanWave class works with input string of the length different.
     */
    @Test
    public void basicTest2() {
        String[] result = new String[]{"Codewars", "cOdewars", "coDewars", "codEwars",
                "codeWars", "codewArs", "codewaRs", "codewarS"};
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result,
                MexicanWave.wave("codewars"));
    }

    /**
     * This test verify that MexicanWave class works with empty input string.
     */
    @Test
    public void basicTest3() {
        String[] result = new String[]{};
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result,
                MexicanWave.wave(""));
    }

    /**
     * This test verify that MexicanWave class works with space on input String.
     */
    @Test
    public void basicTest4() {
        String[] result = new String[]{"Two words", "tWo words", "twO words", "two Words", "two wOrds",
                "two woRds", "two worDs", "two wordS"};
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result,
                MexicanWave.wave("two words"));
    }

    /**
     * This test verify that MexicanWave class works with spaces on start and end the input string.
     */
    @Test
    public void basicTest5() {
        String[] result = new String[]{" Gap ", " gAp ", " gaP "};
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result,
                MexicanWave.wave(" gap "));
    }
}
