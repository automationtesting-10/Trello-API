package com.foundation.trello.util;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * This class validates the schema of a request response.
 *
 * @author Josue Rodriguez
 */
public final class SchemaValidator {
    /**
     * This method constructor initializes the variables.
     */
    private SchemaValidator() {
    }

    /**
     * This method validates the right schemaJson of the response for a request.
     *
     * @param response   The response parameter defines the input response obtained for a request.
     * @param schemaName The schemaJson parameter defines the input schemaJson obtaned of a "<File>.json"
     * @return a boolean that represent the response validation.
     */
    public static boolean validator(Response response, String schemaName) {
        boolean result = false;
        String schemaPath = "schemaJson/" + schemaName + "Schema.json";
        try {
            response.then().assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
            result = true;
            Log.getInstance().getLog().info("The json is valid");
        } catch (Exception e) {
            Log.getInstance().getLog().error("The json is not valid", e);
        }
        return result;
    }
}
