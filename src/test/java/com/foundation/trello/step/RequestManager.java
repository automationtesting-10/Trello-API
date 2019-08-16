package com.foundation.trello.step;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.ReadConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
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
    private String baseUrl;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String tokenSecret;

    private ReadConfiguration reader = new ReadConfiguration();

    private Board board;

    public RequestManager(Board board) {
        this.board = board;
    }


    public RequestManager() {
        consumerKey = reader.readConfigurationFile("consumerKey");
        consumerSecret = reader.readConfigurationFile("consumerSecret");
        accessToken = reader.readConfigurationFile("accessToken");
        tokenSecret = reader.readConfigurationFile("tokenSecret");
        baseUrl = reader.readConfigurationFile("urlBase");
        request = new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret, accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }

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

    @Test
    public void test_GETAlbumsById1_ShouldBeTitle_quidem_molestiae_enim() {
        Response response =
                given().
                    spec(request).
                when().
                    get("/boards/9reOdft6");
        board = response.body().as(Board.class);
        System.out.println(board.getName() + ": NAME");
        Assert.assertEquals("HelloWorld", board.getName());

    }
}
