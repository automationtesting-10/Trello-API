package com.foundation.trello.model;

/**
 * This Context class is used for implement objects.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Context {
    private String id;
    private Board board;

    /**
     * This method constructor initializes the variables.
     *
     * @param board the board parameter defines the input board.
     */
    public Context(Board board) {
        this.board = board;
    }

    /**
     * This method getBoard() returns a board.
     *
     * @return a board.
     */
    public Board getBoard() {
        return board;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
