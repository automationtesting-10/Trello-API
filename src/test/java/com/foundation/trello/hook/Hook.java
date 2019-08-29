package com.foundation.trello.hook;

import com.foundation.trello.model.Context;
import io.cucumber.java.After;

/**
 * Hook class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Hook {

    private Context context;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public Hook(Context context) {
        this.context = context;
    }

    /**
     * this method cleans ids from context.
     */
    @After(order = 1)
    public void afterEachScenario() {
        context.getMapIds().clear();
    }
}
