package com.foundation.trello.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

/**
 * BoardStepDef class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class BoardStepDef {

    RequestManager request = new RequestManager();

    @Given("I set up a GET request to {string} endpoint")
    public void i_set_up_a_request_to_endpoint( String string2) {
        Response response = request.getRequest(string2);
        System.out.println(response.body() + "----response");
    }

    @When("I send the request")
    public void i_send_the_request() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I get a {string} status code as response")
    public void i_get_a_status_code_as_response(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
