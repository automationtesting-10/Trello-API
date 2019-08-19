package com.foundation.trello.step;

import com.foundation.trello.util.Authentication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ListAcceptanceStepDef {
    RequestSpecification requestSpecification;
    String endpoint = null;
    JSONObject bodyJson;
    String json = null;
    Response response;

    @Given("I create a LIST request to {string} endpoint")
    public void i_create_a_LIST_request_to_endpoint(String endpoint) {
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
        response = given().contentType(ContentType.JSON).spec(requestSpecification).body(json).when().post(endpoint);
    }

    @Then("I get a {int} status code as response")
    public void i_get_a_status_code_as_response(int status) {
        Assert.assertEquals(response.getStatusCode(),status);
    }

    @Then("I verify the list schema")
    public void i_verify_the_list_schema() {
    }

    @Then("Sent Data should be the same info of the response")
    public void sent_data_should_be_the_same_info_of_the_response() {
    }
}
