package com.foundation.trello.model.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * RequestGet class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestGet extends RequestManagerAbstract {

    /**
     * Makes a get request and returns its response.
     *
     * @return a Response of a get request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                get(super.getEndPoint());
    }
}
