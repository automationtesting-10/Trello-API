package com.foundation.trello.model;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ReadConfigurationTest {

    ReadConfiguration reader = new ReadConfiguration();
    String consumerKey = reader.readConfigurationFile("consumerKey");
    String consumerSecret = reader.readConfigurationFile("consumerSecret");
    String accessToken = reader.readConfigurationFile("accessToken");
    String tokenSecret = reader.readConfigurationFile("tokenSecret");

    @Test
    public void readConfigurationFile_consumerKey(){
        String actual = consumerKey;
        String expected = "0c5256a20e5f26b03836fa01c1ac68c3";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void readConfigurationFile_consumerSecret(){
        String actual = consumerSecret;
        String expected = "94f824bca09faa7d28eec919171da5e89de0552dceae1e7e03db239ba190ed67";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void readConfigurationFile_accessToken(){
        String actual = accessToken;
        String expected = "e3228d269f332facfbc1a638a1874bfb6d6a09173469968bcb419e165d926142";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void readConfigurationFile_tokenSecret(){
        String actual = tokenSecret;
        String expected = "e3228d269f332facfbc1a638a1874bfb6d6a09173469968bcb419e165d926142";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getRequest() {

        RestAssured.baseURI = "https://api.trello.com";
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                //param("actions", "all").log().all().
                when().
                get("/1/boards/9reOdft6").
                then().assertThat().statusCode(200).log().all().
                extract().response();
    }

    @Test
    public void putRequest_name() {

        RestAssured.baseURI = "https://api.trello.com";
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                param("name", "HelloWorld").log().all().
                when().
                put("/1/boards/9reOdft6").
                then().assertThat().statusCode(200).log().all().
                extract().response();
    }

    @Test
    public void postRequest_name() {
        RestAssured.baseURI = "https://api.trello.com";
        Map<String, Object> mymap = new HashMap<String, Object>();
        mymap.put("name", "Testeando");
        given().contentType(JSON).body(mymap).
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                when().
                post("/1/boards/").
                then().assertThat().statusCode(200);
    }

    @Test
    public void deleteRequest() {

        RestAssured.baseURI = "https://api.trello.com";
        given().
                auth().
                oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                when().
                delete("/1/boards/jVLf29ab").
                then().assertThat().statusCode(200).
                extract().response();
    }
}
