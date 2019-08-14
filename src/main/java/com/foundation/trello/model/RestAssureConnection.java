package com.foundation.trello.model;

import io.restassured.RestAssured;

public class RestAssureConnection {
    private static RestAssureConnection connection;
    private RestAssureConnection() {
        initConnection();
    }

    public static RestAssureConnection getInstance() {
        if (connection == null) {
            connection = new RestAssureConnection();
        }
        return connection;
    }

    private static void initConnection() {
        RestAssured.baseURI = "https://api.trello.com";
    }
}
