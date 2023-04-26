package com.xrius.recipes.recipe.application;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class RecipeCreatorShould {
    @Test
    void save_a_valid_recipe(){

        String id = "id";
        List<String > ingredients = List.of("pepper", "salt");
        Recipe recipe = new Recipe(id, ingredients);

        RecipeRepository recipeRepository = mock(RecipeRepository.class);

        RecipeCreator recipeCreator = new RecipeCreator(recipeRepository);

        recipeCreator.execute(id, ingredients);

        verify(recipeRepository).save(recipe);
    }
}