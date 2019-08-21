package com.foundation.trello.model;

/**
 * This Context class is used for implement objects.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Context {
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
     * This method getBoard() returns a board.
     *
     * @return a board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * This method getCard() returns a card.
     *
     * @return a card.
     */
    public Card getCard() {
        return card;
    }
}
