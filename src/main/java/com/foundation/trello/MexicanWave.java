package josue.rodriguez;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a solution for problem of MexicanWave.
 *
 * @author JosueRodriguez.
 */
public final class MexicanWave {

    /**
     * Method constructor.
     */
    private MexicanWave() {

    }

    /**
     * @param str The Str parameter define the input to method.
     * @return A array the String.
     */
    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        int l = str.length();
        for (int index = 0; index < l; index++) {
            if (str.charAt(index) != ' ') {
                list.add(letterCapital(str, index));
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * @param str The str parameter defines the String to modify.
     * @param i   The parameter i defines the position the letter to change.
     * @return Return a un String.
     */
    public static String letterCapital(String str, int i) {
        String[] letter = str.split("");
        letter[i] = letter[i].toUpperCase();
        str = String.join("", letter);
        return str;
    }
}
