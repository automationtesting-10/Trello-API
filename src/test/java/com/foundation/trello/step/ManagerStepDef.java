package com.foundation.trello.step;

import com.foundation.trello.model.*;
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
//    private RequestManager requestManager;
    private RequestManagerAbstract requestManager;
    private FactoryRequest factoryRequest;
    private Response response;
    private Context context;
    private Board board;
//    RequestPost requestPost = new RequestPost();

    /**
     *
     * @param context
     */
    public ManagerStepDef(Context context) {
        this.context = context;
        this.board = context.getBoard();
    }
    @Given("I create a {string} request to {string} endpoint")
    public void i_create_a_request_to_endpoint(String method, String endPoint) {
//        RequestMethod requestMethod = RequestMethod.valueOf(method.toUpperCase());
        factoryRequest = new FactoryRequest();
        requestManager = factoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
//        requestManager = new RequestManager(requestMethod, endPoint);
    }

    @Given("I set up the data:")
    public void i_set_up_the_data(String data) {
        requestManager.setData(data);
    }

    @When("I sent the request")
    public void i_sent_the_request() {
//        response = requestManager.makeRequest();
        System.out.println("request----" + requestManager.getRequest());
        System.out.println("method----" + requestManager.getMethod());
        System.out.println("data----" + requestManager.getData());
        System.out.println("endPoint----" + requestManager.getEndPoint());
        factoryRequest = new FactoryRequest();
        response = factoryRequest.getResponse(requestManager.getMethod());
        String idBoard = response.body().jsonPath().get("id");
        System.out.println("id_board: " + idBoard);
        board.setId(idBoard);
    }

    @Then("I get a {int} status code as response")
    public void i_get_a_status_code_as_response(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
}
