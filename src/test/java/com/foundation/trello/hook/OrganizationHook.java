package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import com.foundation.trello.util.NamesGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

/**
 * OrganizationHook class create the tagger hooks for the steps.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public final class OrganizationHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public OrganizationHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete an Organization by id.
     */
    @After("@delete-organization")
    public void afterScenario() {
        String id = context.getMapIds().containsKey("idOrganization")
                ? context.getMapIds().get("idOrganization") : context.getMapIds().get("id");
        String endPoint = "/organizations/".concat(id);
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create an Organization.
     */
    @Before("@create-organization")
    public void beforeScenario() {
        String endPoint = "/organizations/";
        String method = "post";
        String displayName = NamesGenerator.newName();
        String data = "{ \"displayName\":\"" + displayName + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.getMapIds().put("idOrganization", response.jsonPath().get("id"));
    }
}
