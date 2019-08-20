package com.foundation.trello.model;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestPost class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestPost extends RequestManagerAbstract {

    /**
     * Makes a post request and returns its response.
     *
     * @return a Response of a post request.
     */
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                contentType(JSON).
                body(getData()).
                when().
                post(getEndPoint());
    }
}
