package com.foundation.trello.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Authentication {

    private static Authentication oauth;
    private RequestSpecification request;

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

    public static Authentication getInstance(){
        if (oauth == null) {
            oauth = new Authentication();
        }
        return oauth;
    }

    public RequestSpecification getRequestSpecification() {
        return request;
    }
}
