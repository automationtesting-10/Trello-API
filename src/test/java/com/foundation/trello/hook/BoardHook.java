package com.foundation.trello.hook;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.Context;
import com.foundation.trello.model.FactoryRequest;
import com.foundation.trello.model.RequestManagerAbstract;
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
    private Board board;
    private Context context;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initialize board and context attributes.
     */
    public BoardHook(Context context) {
        this.context = context;
        this.board = context.getBoard();
    }

    /**
     * Makes a request for delete a Board by id.
     */
    @After("@delete-board")
    public void afterScenario() {
        System.out.println("I am into after hook");
        String endPoint = "/boards/".concat(context.getId());
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);

    }
    /**
     * Makes a request for delete a Board by id.
     */
    @Before("@create-board")
    public void beforeScenario() {
        String endPoint = "/boards/";
        String method = "post";
        String data = "{ \"name\":\"New board test in hook\" }";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
        context.setId(response.jsonPath().get("id"));
        String test = context.getId();
    }
}
