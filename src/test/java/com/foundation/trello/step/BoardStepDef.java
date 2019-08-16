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
    private RequestManager request = new RequestManager();

    /**
     * @param endpoint the endpoint parameter defines a input endpoint.
     */
    @Given("I set up a GET request to {string} endpoint")
    public void iSetUpRequestToEndpoint(String endpoint) {
        Response response = request.getRequest(endpoint);
        System.out.println(response.body() + "----response");
    }

    /**
     *  This method sends request.
     */
    @When("I send the request")
    public void iSendTheRequest() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * @param status The status parameter defines input status.
     */
    @Then("I get a {string} status code as response")
    public void iGetStatusCodeAsResponse(String status) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
