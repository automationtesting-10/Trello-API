package com.foundation.trello.model;

import io.restassured.response.Response;

/**
 * FactoryRequest class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class FactoryRequest {
    public static final String MESSAGE_FOR_UNKNOWN_METHOD = "Unknown method type";

    public Response getResponse(String method) {
        String nameMethod = method.toUpperCase();
        RequestMethod requestMethod = RequestMethod.valueOf(nameMethod);
        switch (requestMethod) {
            case POST:
                return new RequestPost().makeRequest();
            case GET:
                return new RequestGet().makeRequest();
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_METHOD);
        }
    }
    public RequestManagerAbstract getRequest(String method) {
        String nameMethod = method.toUpperCase();
        RequestMethod requestMethod = RequestMethod.valueOf(nameMethod);
        switch (requestMethod) {
            case POST:
                return new RequestPost();
            case GET:
                return new RequestGet();
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_METHOD);
        }
    }
}
