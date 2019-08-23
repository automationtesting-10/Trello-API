package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import com.foundation.trello.util.NamesGenerator;
import io.cucumber.java.Before;
import io.restassured.response.Response;

/**
 * ListHook class create the tagger hooks for the steps.
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
        String name = NamesGenerator.newName();
        String idBoard = context.getId();
        String data = "{ \"name\":\"" + name + "\" ,"
                + "\"idBoard\":\"" + idBoard + "\"}";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
    }
}
