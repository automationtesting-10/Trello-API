package com.foundation.trello.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * This class is used for authentication.
 *
 * @author Andres Burgos
 */
public final class Authentication {

    private static Authentication oauth;
    private RequestSpecification request;

    /**
     * This is constructor that initializes variables.
     */
    private Authentication() {
        ReadConfiguration reader = ReadConfiguration.getInstance();
        String consumerKey = reader.getConsumerKey();
        String consumerSecret = reader.getConsumerSecret();
        String accessToken = reader.getAccessToken();
        String tokenSecret = reader.getTokenSecret();
        String baseUrl = reader.getUrlBase();
        request = new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret,
                accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }

    /**
     * Gives the class instance according Singleton pattern.
     * @return an instance.
     */
    public static Authentication getInstance() {
        if (oauth == null) {
            oauth = new Authentication();
        }
        return oauth;
    }

    /**
     * Gives the request specification resultant of oauth.
     * @return an request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return request;
    }
}
