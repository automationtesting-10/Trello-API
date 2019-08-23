package com.foundation.trello.model;

/**
 * This class works with JsonConvert class.
 *
 * @author Maday Alcala.
 */
public class Label {
    private String id;
    private String name;

    /**
     * This method is used to get id.
     *
     * @return a string that represent the id of the list.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to set id.
     *
     * @param id the id parameter defines of input id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to get name.
     *
     * @return a string that represent the name of the list.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set name.
     *
     * @param name the name parameter defines of input name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
