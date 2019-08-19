package com.foundation.trello.hook;

import com.foundation.trello.model.Board;
import com.foundation.trello.model.Context;
import com.foundation.trello.model.RequestManager;
//import cucumber.api.java.After;
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

    public BoardHook(Context context) {
        this.context = context;
        this.board = context.getBoard();
    }

    @After("@delete-board")
    public void afterScenario() {
        String endPoint = "/boards/".concat(board.getId());
        RequestManager requestManager = new RequestManager("DELETE", endPoint);
        Response response = requestManager.makeRequest();
        System.out.println(response.getStatusCode() + " : Status Code");
    }
}
