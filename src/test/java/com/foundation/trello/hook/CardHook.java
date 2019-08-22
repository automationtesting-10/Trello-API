package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

/**
 * CardHook class.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public final class CardHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public CardHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Card by id.
     */
    @After(order = 1, value = "@delete-card")
    public void afterScenario() {
        String endPoint = "/cards/".concat(context.getId());
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
    @Before(order = 3, value = "@create-card")
    public void beforeScenario() {
        String endPoint = "/cards/";
        String method = "post";
        String data = "{ \"name\":\"New card test in hook\" ,"
                + "\"idList\":\"" + context.getId() + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
    }
}
