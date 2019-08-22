package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import io.cucumber.java.Before;
import io.restassured.response.Response;

/**
 * ListHook class.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public final class ListHook {
    private Context context;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ListHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for create a List.
     */

    @Before(order = 2, value = "@create-list")
    public void beforeScenario() {
        String endPoint = "/lists/";
        String method = "post";
        String data = "{ \"name\":\"New list test in hook\" ,"
                + "\"idBoard\":\"" + context.getId() + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
    }
}
