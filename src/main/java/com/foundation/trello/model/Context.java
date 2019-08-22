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
    private Card card;

    /**
     * This method constructor initializes the variables.
     *
     * @param board the board parameter defines the input board.
     * @param card the card parameter defines the input card.
     */
    public Context(Board board, Card card) {
        this.board = board;
        this.card = card;
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
}
