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
 * ChecklistHook class create the tagger hooks for the steps.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public class ChecklistHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ChecklistHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Checklist by id.
     */
    @After("@delete-checklist")
    public void afterScenario() {
        String endPoint = "/checklists/".concat(context.getId());
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create a Checklist.
     */
    @Before(order = 4, value = "@create-checklist")
    public void beforeScenario() {
        String endPoint = "/checklists/";
        String method = "post";
        String name = NamesGenerator.newName();
        String idCard = context.getId();
        String data = "{ \"name\":\"" + name + "\" ,"
                + "\"idCard\":\"" + idCard + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
    }
}

