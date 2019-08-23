package com.foundation.trello.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used for apply Regular Expression.
 *
 * @author Josue Rodriguez.
 */
public final class Regex {
    private static Regex ourInstance;

    /**
     * This method constructor initializes the parameters.
     */
    private Regex() {
    }

    /**
     * This method verifies if of object Regex was created, if not creates it.
     *
     * @return a regex.
     */
    public static Regex getInstance() {
        if (ourInstance == null) {
            ourInstance = new Regex();
        }
        return ourInstance;
    }

    /**
     * This method returns a new endpoint.
     *
     * @param endpoint The string parameter defines the endpoint input.
     * @param id       The id parameter defines the list of id.
     * @return a string.
     */
    public String replaceID(String endpoint, Map<String, String> id) {
        for (Map.Entry<String, String> entry : id.entrySet()) {
            Pattern pattern = Pattern.compile("\\{" + entry.getKey() + "\\}");
            Matcher matcher = pattern.matcher(endpoint);
            endpoint = matcher.replaceAll(entry.getValue());
        }
        return endpoint;
    }
}

