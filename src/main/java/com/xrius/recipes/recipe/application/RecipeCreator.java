package com.xrius.recipes.recipe.application;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public final class RecipeCreator {
    private RecipeRepository recipeRepository;

    public void execute(CreateRecipeRequest createRecipeRequest) {
        val recipe = new Recipe(
                createRecipeRequest.getId(),
                createRecipeRequest.getName(),
                createRecipeRequest.getIngredients()
        );

        recipeRepository.save(recipe);
    }
}
