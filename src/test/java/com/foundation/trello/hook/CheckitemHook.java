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
 * CheckitemHook class create the tagger hooks for the steps.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public class CheckitemHook {
    private Context context;
    private Response response;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public CheckitemHook(Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Checkitem by id.
     */
    @After(order = 1, value = "@delete-checkitem")
    public void afterScenario() {
        String idChecklist = context.getMapIds().get("idChecklist");
        String id = context.getMapIds().containsKey("idCheckItem")
                ? context.getMapIds().get("idCheckItem") : context.getMapIds().get("id");
        String endPoint = "/checklists/"+idChecklist +"/checkItems/".concat(id);
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }

    /**
     * Makes a request for create a Checkitem.
     */
    @Before(order = 5, value = "@create-checkitem")
    public void beforeScenario() {
        String idChecklist = context.getMapIds().get("idChecklist");
        String endPoint = "/checklists/"+ idChecklist+"/checkItems";
        String method = "post";
        String name = NamesGenerator.newName();
        String data = "{ \"name\":\"" + name + "\" }";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.getMapIds().put("idCheckItem", response.jsonPath().get("id"));
    }
}
