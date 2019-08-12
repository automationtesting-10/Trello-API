package com.foundation.trello;

public class Auten {
    private static Auten ourInstance = new Auten();

    public static Auten getInstance() {
        return ourInstance;
    }

    private Auten() {
    }
}
