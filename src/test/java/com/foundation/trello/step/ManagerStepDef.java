package com.foundation.trello.step;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.NamesGenerator;

import com.foundation.trello.util.Regex;
import com.foundation.trello.util.SchemaValidator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

/**
 * ManagerStepDef class.
 *
 * @author Raul Choque, Josue Rodriguez, Maday Alcala.
 * @version 0.0.1
 */
public class ManagerStepDef {
    private RequestManagerAbstract requestManager;
    private Response response;
    private SoftAssert softAssert;
    private Context context;

    /**
     * This method constructor initializes variables.
     *
     * @param context The context parameter defines the input context.
     */
    public ManagerStepDef(Context context) {
        this.context = context;
    }

    /**
     * This method makes request.
     *
     * @param method   The method parameter defines a input method.
     * @param endPoint The endpoint parameter defines a input endpoint.
     */
    @Given("I create a ([[GET][POST][DELETE][PUT]]+) request to (.*) endpoint")
    public void iCreateRequest(String method, String endPoint) {
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        context.getMapIds();
        String completeEndPoint = Regex.getInstance().replaceID(endPoint, context.getMapIds());
        requestManager.setEndPoint(completeEndPoint);
    }

    /**
     * This method sets the data.
     *
     * @param data The data parameter defines input data.
     */
    @Given("I set up the data:")
    public void iSetUpData(String data) {
        String aleatoryName = data.replaceAll("\\[(.*?)\\]", NamesGenerator.newName());
        requestManager.setData(aleatoryName);
        String completeData = Regex.getInstance().replaceID(data, context.getMapIds());
        requestManager.setData(completeData);
    }

    /**
     * This method is used for send the request to the API.
     */
    @When("I send the request")
    public void sentRequest() {
        response = requestManager.makeRequest();
        String id = response.getStatusCode() == 200 ? response.body().jsonPath().get("[0].id") : "";
        context.getMapIds().put("id", id);
    }

    /**
     * This method verifies that the response to the requirement is correct.
     *
     * @param statusCode The statusCode parameter defines the input status.
     */
    @Then("I get a {int} status code as response")
    public void getStatusCodeAsResponse(int statusCode) {
        softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        softAssert.assertAll();
    }

    /**
     * This method verifies that the schema response to the requirement is correct.
     *
     * @param schemaName The schema parameter defines the input file name schema.
     */
    @And("I verify the response schema with (.*)")
    public void iGetASchema(String schemaName) {
        boolean validator = SchemaValidator.validator(response, schemaName);
        softAssert = new SoftAssert();
        softAssert.assertTrue(validator);
    }

    /**
     * This method is in charge of clean after the class.
     */
    @AfterClass
    public void afterClass() {
        context.setId(null);
    }
}
