package com.foundation.trello.step;

import com.foundation.trello.model.RequestManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

/**
 * ManagerStepDef class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class ManagerStepDef {
    private RequestManager requestManager;
    private Response response;
    @Given("I create a {string} request to {string} endpoint")
    public void i_create_a_request_to_endpoint(String method, String endPoint) {
        requestManager = new RequestManager(method, endPoint);
    }

    @Given("I set up the data:")
    public void i_set_up_the_data(String data) {
        requestManager.setData(data);
    }

    @When("I sent the request")
    public void i_sent_the_request() {
        response = requestManager.makeRequest();
    }

    @Then("I get a {int} status code as response")
    public void i_get_a_status_code_as_response(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
}
