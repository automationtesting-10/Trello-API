package com.foundation.trello.hook;

import com.foundation.trello.model.Card;
import com.foundation.trello.model.Context;
import com.foundation.trello.model.request.FactoryRequest;
import com.foundation.trello.model.request.RequestManagerAbstract;
import com.foundation.trello.util.Log;
import io.cucumber.java.After;
import io.restassured.response.Response;

/**
 * CardHook class.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public final class CardHook {
    private Card card;
    private RequestManagerAbstract requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initialize card and context attributes.
     */
    public CardHook(Context context) {
        this.card = context.getCard();
    }

    /**
     * Makes a request for delete a Card by id.
     */
    @After("@delete-card")
    public void afterScenario() {
        String endPoint = "/cards/".concat(card.getId());
        String method = "delete";
        requestManager = FactoryRequest.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLog().info(response);
    }
}
