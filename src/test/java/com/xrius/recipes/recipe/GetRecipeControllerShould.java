package com.xrius.recipes.recipe;

import com.xrius.recipes.ApplicationTestCase;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;

class GetRecipeControllerShould extends ApplicationTestCase {

    @Test
    void get_recipe() throws Exception {
        var endpoint = "/recipes";
        var expectedResponse = "{'recipe': 'ok'}";

        assertResponse(
                endpoint,
                HTTP_OK,
                expectedResponse);
    }
}