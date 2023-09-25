package com.xrius.recipes.recipe.application;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeId;
import com.xrius.recipes.recipe.domain.RecipeRepository;
import com.xrius.recipes.recipe.infrastructure.RecipeIngredientsMother;
import com.xrius.recipes.recipe.infrastructure.RecipeNameMother;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.UUID;

final class RecipeCreatorShould {
    @Test
    void save_a_valid_recipe(){

        String id = UUID.randomUUID().toString();
        String name = "name";
        List<String > ingredients = List.of("pepper", "salt");
        Recipe recipe = new Recipe(
                new RecipeId(id),
                RecipeNameMother.create(name),
                RecipeIngredientsMother.create(ingredients));

        RecipeRepository recipeRepository = mock(RecipeRepository.class);

        RecipeCreator recipeCreator = new RecipeCreator(recipeRepository);
        CreateRecipeRequest createRecipeRequest = new CreateRecipeRequest(id, name, ingredients);

        recipeCreator.execute(createRecipeRequest);

        verify(recipeRepository).save(recipe);
    }
}