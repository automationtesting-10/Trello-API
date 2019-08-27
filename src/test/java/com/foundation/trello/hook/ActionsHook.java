package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import com.foundation.trello.util.NamesGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

public class ActionsHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ActionsHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Action by id.
     */
    @After("@delete-action")
    public void afterScenario() {
        String idCard = context.getMapIds().get("idCard");
        String idAction = context.getMapIds().get("idAction");
        String endPoint = "/cards/"+idCard+"/actions/"+idAction+"/comments";
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create a Action.
     */
    @Before(order = 4, value = "@create-action")
    public void beforeScenario() {
        String idCard = context.getMapIds().get("idCard");
        String endPoint = "/cards/"+idCard+"/actions/comments";
        String method = "post";
        String data = "{ \"text\":\"new comments for card\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.getMapIds().put("idAction", response.jsonPath().get("id"));
    }
}
