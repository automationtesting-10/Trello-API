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
 * CardHook BoardHook class create the tagger hooks for the steps.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public final class LabelHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public LabelHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Card by id.
     */
    @After("@delete-label")
    public void afterScenario() {
        String id = context.getMapIds().containsKey("idLabel")
                ? context.getMapIds().get("idLabel") : context.getMapIds().get("id");
        String endPoint = "/labels/".concat(id);
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create a Card.
     */
    @Before(order = 3, value = "@create-label")
    public void beforeScenario() {
        String endPoint = "/labels/";
        String method = "post";
        String name = NamesGenerator.newName();
        String idBoard = context.getMapIds().get("idBoard");
        String data = "{ \"name\":\" " + name + "\" ,"
                + "\"color\":\"red\" ,"
                + "\"idBoard\":\"" + idBoard + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.getMapIds().put("idLabel", response.jsonPath().get("id"));
    }
}
