package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

/**
 * BoardHook class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class BoardHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public BoardHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Board by id.
     */
    @After(order = 2, value = "@delete-board")
    public void afterScenario() {
        String endPoint = "/boards/".concat(context.getId());
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create a Board.
     */
    @Before(order = 1, value = "@create-board")
    public void beforeScenario() {
        String endPoint = "/boards/";
        String method = "post";
        String data = "{ \"name\":\"New board test in hook\" }";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
    }
}
