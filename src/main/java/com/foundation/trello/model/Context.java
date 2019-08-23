package com.foundation.trello.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This Context class is used for implement objects.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Context {
    private String id;
    private Board board;
    private Map<String, String> mapIds;

    /**
     * This method constructor initializes the variables.
     *
     * @param board the board parameter defines the input board.
     */
    public Context(Board board) {
        this.board = board;
        this.mapIds = new HashMap<>();
    }

    /**
     * This method returns the board attribute.
     *
     * @return a board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * This method returns the id attribute.
     *
     * @return id as string.
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the id attribute.
     *
     * @param id defines the input id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the id attribute on map.
     *
     * @return mapId as map.
     */
    public Map<String, String> getMapIds() {
        return mapIds;
    }

    /**
     * This method sets the id attribute on map.
     *
     * @param mapIds defines the input id.
     */
    public void setMapIds(Map<String, String> mapIds) {
        this.mapIds = mapIds;
    }
}
