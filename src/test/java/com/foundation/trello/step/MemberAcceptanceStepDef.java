package com.foundation.trello.step;

import com.foundation.trello.util.Authentication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class MemberAcceptanceStepDef {
    RequestSpecification requestSpecification;
    String endpoint;
    Response response;
    String newName;
    @Given("I set up a GET request to {string} endpoint wit id")
    public void i_set_up_a_GET_request_to_endpoint_wit_id(String endpoint) {
        requestSpecification = Authentication.getInstance().getRequestSpecification();
        this.endpoint = endpoint;
    }

    @When("I sent the request")
    public void i_sent_the_request() {
        response = given().
                contentType(ContentType.JSON).
                spec(requestSpecification).
                when().get(endpoint);
    }

    @Then("I get a {int} status code as response")
    public void i_get_a_status_code_as_response(int status) {
        Assert.assertEquals(response.getStatusCode(), status);
    }

    //*****PUT REQUEST*****
    @Given("I update a PUT request to {string} endpoint")
    public void i_update_a_PUT_request_to_endpoint(String endpoint) {
        requestSpecification = Authentication.getInstance().getRequestSpecification();
        this.endpoint = endpoint;
    }

    @Given("I set up the data with the new name:")
    public void i_set_up_the_data(String newName) {
       this.newName = newName;
    }

    @When("I sent the request for update de member name's")
    public void i_sent_the_request_for_update_de_member_name_s() {
        response = given().
                contentType(ContentType.JSON).
                body(newName).
                spec(requestSpecification).
                when().put(endpoint);
    }

    @Then("I get a {int} status code as response of the upadte.")
    public void i_get_a_status_code_as_response_of_the_upadte(int status) {
        Assert.assertEquals(response.getStatusCode(),status);
    }

//    @Then("I verify the board schema")
//    public void i_verify_the_board_schema() {
//
//    }
//
//    @Then("Sent Data should be the same info of the response")
//    public void sent_Data_should_be_the_same_info_of_the_response() {
//
//    }

}
