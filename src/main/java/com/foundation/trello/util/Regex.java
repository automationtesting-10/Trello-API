package com.foundation.trello.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used for apply Regular Expression.
 *
 * @author Josue Rodriguez.
 */
public final class Regex {
    private static Regex ourInstance;
    private String string;
    private String id;
    private String result;

    /**
     * This method constructor initialize the parameters.
     *
     * @param string The oldString parameter defines the endpoint input.
     * @param id The id parameter defines the id of the card.
     */
    private Regex(String string, String id) {
        this.string = string;
        this.id = id;
    }

    /**
     * This method verify if of object Regex was created, if not creates it.
     *
     * @param string The string parameter defines the endpoint input.
     * @param id The id parameter defines the id of the card.
     * @return Regex.
     */
    public static Regex getInstance(String string, String id) {
        if (ourInstance == null) {
            ourInstance = new Regex(string, id);
        }
        return ourInstance;
    }

    /**
     * This method return a new endpoint replacing {id}.
     *
     * @return new endpoint with id.
     */
    public String getString() {
        Pattern pattern = Pattern.compile("\\{id\\}");
        Matcher matcher = pattern.matcher(string);
        result = matcher.replaceAll(id);
        return result;
    }
}
