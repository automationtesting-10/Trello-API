package com.foundation.trello.step;

import com.foundation.trello.model.ReadConfiguration;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * RequestManager class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class RequestManager {

    private RequestSpecification request;
    private Response response;
    private String method;
    private String endpoint;
    private String baseUrl;

    private ReadConfiguration reader = new ReadConfiguration();


    public RequestManager(String method, String endpoint) {
        this.method = method;
        this.endpoint = endpoint;
        initAuthentication();
    }

    private void initAuthentication() {
        String consumerKey = reader.readConfigurationFile("consumerKey");
        String consumerSecret = reader.readConfigurationFile("consumerSecret");
        String accessToken = reader.readConfigurationFile("accessToken");
        String tokenSecret = reader.readConfigurationFile("tokenSecret");
        request.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret);
    }


}
