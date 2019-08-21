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
    private String[] ids;
    private String result;

    /**
     * This method constructor initialize the parameters.
     *
     * @param string The oldString parameter defines the endpoint input.
     * @param ids The id parameter defines the list of id.
     */
    private Regex(String string, String[] ids) {
        this.string = string;
        this.ids = ids;
    }

    /**
     * This method verify if of object Regex was created, if not creates it.
     *
     * @param string The string parameter defines the endpoint input.
     * @param ids The id parameter defines the list of id.
     * @return Regex.
     */
    public static Regex getInstance(String string, String[] ids) {
        if (ourInstance == null) {
            ourInstance = new Regex(string, ids);
        }
        return ourInstance;
    }

    /**
     * This method return a new endpoint replacing {id}.
     *
     * @return new endpoint with id.
     */
    public String getString() {
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        for(int index = 0; index < ids.length; index++){
            Matcher matcher = pattern.matcher(string);
            string = matcher.replaceFirst(ids[index]);
        }
        return result;
    }
}
