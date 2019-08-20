package com.foundation.trello.model;

import com.foundation.trello.util.Authentication;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * RequestManagerAbstract class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public abstract class RequestManagerAbstract {
    private RequestSpecification request;
    private String endPoint;
    private String data;
    private String method;

//    /**
//     *
//     */
//    public RequestManager(String method, String endPoint) {
//        request = Authentication.getInstance().getRequestSpecification();
//        this.method = method;
//        this.endPoint = endPoint;
//        data = "";
//    }

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

    public String getData() {
        return data;
    }

    public String getMethod() {
        return method;
    }

    /**
     *
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    public RequestSpecification getRequest() {

        return Authentication.getInstance().getRequestSpecification();
    }

//    public void setRequest(RequestSpecification request) {
//        this.request = request;
//    }

    public String getEndPoint() {
        return endPoint;
    }
    public abstract Response makeRequest();

    /**
     *
     * @return
     */
//    public Response makeRequest() {
//        if (method.compareTo("POST") == 0) {
//            return given().
//                    spec(request).
//                    contentType(JSON).
//                    body(data).
//                    when().
//                    post(endPoint);
//        } else {
//            if (method.compareTo("GET") == 0) {
//                return given().
//                        spec(request).
//                        when().
//                        get(endPoint);
//            } else {
//                if (method.compareTo("PUT") == 0) {
//                    return given().
//                            spec(request).
//                            contentType(JSON).
//                            body(data).
//                            when().
//                            put(endPoint);
//                } else {
//                    return given().
//                            spec(request).
//                            when().
//                            delete(endPoint);
//                }
//            }
//        }
//    }
}
