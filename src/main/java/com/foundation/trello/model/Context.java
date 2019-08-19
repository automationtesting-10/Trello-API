package com.foundation.trello.model;

/**
 * Context class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Context {
    private Board board;

    public Context(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
