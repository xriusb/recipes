package com.xrius.recipes.controller.recipe;

import com.xrius.recipes.ApplicationTestCase;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

public class RecipesPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_recipe() throws Exception {
        var recipeId = UUID.randomUUID().toString();
        var endpoint = "/recipes/" + recipeId;
        var body = """
             {
               "name": "Meatballs with squid",
               "ingredients": [
                 "meat",
                 "tomato sauce"
               ]
             }
                """;

        assertRequestWithBody(
                PUT.name(),
                endpoint,
                body,
                HTTP_CREATED
        );
    }
}
