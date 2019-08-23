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
    private Map<String, String> map;

    /**
     * This method constructor initializes the variables.
     *
     * @param board the board parameter defines the input board.
     */
    public Context(Board board) {
        this.board = board;
        map = new HashMap<>();
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

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
