package com.foundation.trello.model;

import com.foundation.trello.util.ReadConfiguration;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * This class is used for testing of ReadConfiguration class.
 */
public class ReadConfigurationTest {
    private ReadConfiguration reader = ReadConfiguration.getInstance();
    private String consumerKey = reader.getConsumerKey();
    private String consumerSecret = reader.getConsumerSecret();
    private String accessToken = reader.getAccessToken();
    private String tokenSecret = reader.getTokenSecret();

    /**
     * This test verifies that the consumerKey is correct get of the properties file.
     */
    @Test
    public void readConfigurationFileConsumerKey() {
        String actual = consumerKey;
        String expected = "0c5256a20e5f26b03836fa01c1ac68c3";
        Assert.assertEquals(actual, expected);
    }

    /**
     * This test verifies that the consumerSecret is correct get of the properties file.
     */
    @Test
    public void readConfigurationFileConsumerSecret() {
        String actual = consumerSecret;
        String expected = "94f824bca09faa7d28eec919171da5e89de0552dceae1e7e03db239ba190ed67";
        Assert.assertEquals(actual, expected);
    }

    /**
     * This test verifies that the accessToken is correct get of the properties file.
     */
    @Test
    public void readConfigurationFileAccessToken() {
        String actual = accessToken;
        String expected = "e3228d269f332facfbc1a638a1874bfb6d6a09173469968bcb419e165d926142";
        Assert.assertEquals(actual, expected);
    }

    /**
     * This test verifies that the tokenSecret is correct get of the properties file.
     */
    @Test
    public void readConfigurationFileTokenSecret() {
        String actual = tokenSecret;
        String expected = "e3228d269f332facfbc1a638a1874bfb6d6a09173469968bcb419e165d926142";
        Assert.assertEquals(actual, expected);
    }

    /**
     * This test verifies that the GET return a state 200.
     */
    @Test
    public void getRequest() {
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                //param("actions", "all").log().all().
                        when().
                get("https://api.trello.com/1/boards/9reOdft6").
                then().assertThat().statusCode(200).log().all().
                extract().response();
    }

    /**
     * This test verifies that the PUT return a state 200.
     */
    @Test
    public void putRequestName() {
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                param("name", "HelloWorld").log().all().
                when().
                put("https://api.trello.com/1/boards/9reOdft6").
                then().
                assertThat().statusCode(200).log().all().
                extract().response();
    }

    /**
     * This test verifies that the POST return a state 200.
     */
    @Test
    public void postRequest() {
        Map<String, Object> mymap = new HashMap<String, Object>();
        mymap.put("name", "Testeando");
        given().contentType(JSON).body(mymap).
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                when().
                post("https://api.trello.com/1/boards/").
                then().
                assertThat().statusCode(200);
    }

    /**
     * This test verifies that the DELETE return a state 200.
     */
    @Test
    public void deleteRequest() {
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                when().
                delete("https://api.trello.com/1/boards/jVLf29ab").
                then().
                assertThat().statusCode(404).
                extract().response();
    }

    /**
     * This test verifies that the POST return a state 200.
     */
    @Test
    public void postRequestWithQueryParams() {
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                queryParams("name", "Testeando3").
                contentType(ContentType.JSON).
                when().
                post("https://api.trello.com/1/boards/").
                then().
                assertThat().statusCode(200).log().all().
                extract().response();
    }
}
