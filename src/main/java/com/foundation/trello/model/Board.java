package com.foundation.trello.model;

/**
 * This class works with JsonConvert class.
 * @author Andres Burgos
 */
public class Board {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
