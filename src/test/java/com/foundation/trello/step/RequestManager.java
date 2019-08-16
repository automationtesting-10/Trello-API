package com.foundation.trello.step;

import com.foundation.trello.util.Authentication;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestManager class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestManager {
    private RequestSpecification request = Authentication.getInstance().getRequestSpecification();

    /**
     * @param endpoint the endpoint parameter defines a input string.
     * @return a response.
     */
    public Response getRequest(final String endpoint) {
        Response response =
                given().
                        spec(request).
                        when().
                        get(endpoint).
                        then().
                        extract().
                        response();
        return response;
    }

    /**
     * @param endpoint the endpoint parameter define a input string.
     * @return a response.
     */
    public Response deleteRequest(final String endpoint) {
        Response response =
                given().
                        spec(request).
                        when().
                        delete(endpoint).
                        then().
                        extract().
                        response();
        return response;
    }

    /**
     * @param endpoint The endpoint parameter defines a input string.
     * @param data The data parameter defines a input map object.
     * @return a response.
     */
    public Response postRequest(final String endpoint, final Map<String, Object> data) {
        Response response =
                given().
                        spec(request).
                        contentType(JSON).
                        body(data).
                        when().
                        post(endpoint).
                        then().
                        extract().
                        response();
        return response;
    }

    /**
     * @param endpoint The endpoint parameter defines a input string.
     * @param data The data parameter defines a input map object.
     * @return a response.
     */
    public Response putRequest(final String endpoint, final Map<String, Object> data) {
        Response response =
                given().
                        spec(request).
                        contentType(JSON).
                        body(data).
                        when().
                        put(endpoint).
                        then().
                        extract().
                        response();
        return response;
    }
}
