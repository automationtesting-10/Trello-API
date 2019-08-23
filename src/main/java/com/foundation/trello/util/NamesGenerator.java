package com.foundation.trello.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class generates random names with their respective suffixes and prefixes.
 *
 * @author Maday Alcala Cuba.
 * @version 0.0.1
 */
public final class NamesGenerator {
    private static String newName;
    private static String suffix;
    private static String prefix;
    private static Date actual;

    /**
     * This is the constructor method that initializes the variables.
     */
    private NamesGenerator() {
    }

    /**
     * This method is in charge of joining a suffix with a random name and its prefix
     * in the following format: <prefix>_<name>_<suffix>.
     *
     * @return 'newName' that represent a name with its respective suffix and prefix.
     */
    public static String newName() {
        newName = prefix() + " " + aleatoryName() + " " + suffix();
        return newName;
    }

    /**
     * This class returns the string "AT10" as prefix.
     *
     * @return a prefix in string type.
     */
    public static String prefix() {
        prefix = "AT10";
        return prefix;
    }

    /**
     * This class takes the current date and returns it as a string in the variable suffix.
     *
     * @return a suffix in string type.
     */
    public static String suffix() {
        actual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        suffix = formatter.format(actual);
        return suffix;
    }

    /**
     * This method generates random names.
     *
     * @return the variable 'newName' which represents a random string name.
     */
    public static String aleatoryName() {
        char n;
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 7; i++) {
            n = (char) (rnd.nextDouble() * 26.0 + 65.0);
            buf.append(n);
            newName = buf.toString().toLowerCase();
        }
        return newName;
    }
}
