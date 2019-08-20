package com.foundation.trello.model;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * RequestDelete class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestDelete extends RequestManagerAbstract {

    /**
     * Makes a delete request and returns its response.
     *
     * @return a Response of a delete request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                delete(super.getEndPoint());
    }
}