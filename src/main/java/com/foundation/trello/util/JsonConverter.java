package com.foundation.trello.util;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.Card;
import com.foundation.trello.model.List;
import com.google.gson.Gson;

/**
 * This JsonConverter class is used for convert a Json in object.
 *
 * @author Andres Burgos, Josue Rodriguez
 * @version 1.0
 */
public abstract class JsonConverter {
    /**
     * Converts a json to a Criteria instance according on given type.
     *
     * @param json - String corresponding to json.
     * @param type - Object's type.
     * @return Instance of Object class according on given type.
     */
    public static Object jsonToObject(String json, String type) {
        Gson gson = new Gson();
        switch (type) {
            case "Board":
                return gson.fromJson(json, Board.class);
            case "List":
                return gson.fromJson(json, List.class);
            case "Card":
                return gson.fromJson(json, Card.class);
            default:
                return null;
        }
    }

    /**
     * Converts an instance of ConvertCriteria class to json.
     *
     * @param object - Object to be convert to json.
     * @return json corresponding to given Object.
     */
    public static String convertObjectToJson(Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }
}
