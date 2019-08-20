package com.foundation.trello.hook;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.Context;
import com.foundation.trello.model.FactoryRequest;
import com.foundation.trello.model.RequestManagerAbstract;
import io.cucumber.java.After;
import io.restassured.response.Response;

/**
 * BoardHook class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class BoardHook {
    private Context context;
    private Board board;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     */
    private BoardHook() {
    }

    /**
     * This is the constructor method.
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
        String endPoint = "/boards/".concat(board.getId());
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        Response response = requestManager.makeRequest();
    }
}
