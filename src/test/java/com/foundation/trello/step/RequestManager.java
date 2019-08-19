package com.foundation.trello.step;

import com.foundation.trello.util.Authentication;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestManager class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestManager {

    private RequestSpecification request;
    private String endPoint;
    private String data;
    private String method;

    /**
     *
     */
    public RequestManager(String method, String endPoint) {
        request = Authentication.getInstance().getRequestSpecification();
        this.method = method;
        this.endPoint = endPoint;
        data = "";
    }

    /**
     *
     * @param endPoint
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     *
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     *
     * @return
     */
    public Response makeRequest() {
        if (method.compareTo("POST") == 0) {
            return given().
                    spec(request).
                    contentType(JSON).
                    body(data).
                    when().
                    get(endPoint);
        } else {
            if (method.compareTo("GET") == 0) {
                return given().
                        spec(request).
                        when().
                        get(endPoint);
            } else {
                if (method.compareTo("Put") == 0) {
                    return given().
                            spec(request).
                            contentType(JSON).
                            body(data).
                            when().
                            put(endPoint);
                } else {
                    return given().
                            spec(request).
                            when().
                            get(endPoint);
                }
            }
        }
    }
}
