package com.foundation.trello.step;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

/**
 * ManagerStepDef class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class ManagerStepDef {
    private RequestManagerAbstract requestManager;
    private Response response;
    private Board board;

    /**
     * This method constructor initializes variables.
     *
     * @param context The context parameter defines the input context.
     */
    public ManagerStepDef(Context context) {
        this.board = context.getBoard();
    }

    /**
     * This method makes request.
     *
     * @param method   The method parameter defines a input method.
     * @param endPoint The endpoint parameter defines a input endpoint.
     */
    @Given("I create a {string} request to {string} endpoint")
    public void iCreateRequest(String method, String endPoint) {
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
    }

    /**
     * This method sets the data.
     *
     * @param data The data parameter defines input data.
     */
    @Given("I set up the data:")
    public void iSetUpData(String data) {
        requestManager.setData(data);
    }

    /**
     * This method is used for send the request to the API.
     */
    @When("I send the request")
    public void sentRequest() {
        response = requestManager.makeRequest();
        String idBoard = response.body().jsonPath().get("id");
        board.setId(idBoard);
    }

    /**
     * This method verifies that the response to the requirement is correct.
     *
     * @param statusCode The statusCode parameter defines the input status.
     */
    @Then("I get a {int} status code as response")
    public void getStatusCodeAsResponse(int statusCode) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, response.getStatusCode());
    }
}
