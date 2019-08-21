package com.foundation.trello.util;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * This class validates the schema of a request response.
 * @author Josue Rodriguez
 */
public final class SchemaValidator {
    /**
     * This method constructor initializes the variables.
     */
    private SchemaValidator() { }

    /**
     * This method validates the right schema of the response for a request.
     * @param response The response parameter defines the input response obtained for a request.
     * @param schema The schema parameter defines the input schema obtaned of a "<File>.json"
     */
    public static void validator(Response response, String schema) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(schema));
    }
}

