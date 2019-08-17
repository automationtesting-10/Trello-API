package com.foundation.trello.step;

import com.foundation.trello.util.Authentication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.xml.ws.Endpoint;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

public class BoardAcceptanceStepDef {
    RequestSpecification requestSpecification;
    String endpoint = null;
    JSONObject bodyJson;
    String json = null;
    Response response;
    @Given("I create a POST request to {string} endpoint")
    public void i_create_a_POST_request_to_endpoint(String endpoint) {
        requestSpecification = Authentication.getInstance().getRequestSpecification();
        this.endpoint = endpoint;
    }

    @Given("I set up the data:")
    public void i_set_up_the_data(String paramName) {
        bodyJson = new JSONObject(paramName);
        this.json = paramName;
    }

    @When("I sent the request")
    public void i_sent_the_request() {
        response= given().
                contentType(ContentType.JSON).
                spec(requestSpecification).body(json).
                when().post(endpoint);
    }

    @Then("I get a {int} status code as response")
    public void i_get_a_status_code_as_response(int status) {
        Assert.assertEquals(status,response.getStatusCode());
    }

    @Then("I verify the board schema")
    public void i_verify_the_board_schema() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Sent Data should be the same info of the response")
    public void sent_Data_should_be_the_same_info_of_the_response() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
