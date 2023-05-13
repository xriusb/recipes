package com.xrius.recipes.recipe.application;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeId;
import com.xrius.recipes.recipe.domain.RecipeIngredients;
import com.xrius.recipes.recipe.domain.RecipeName;
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
                new RecipeId(createRecipeRequest.getId()),
                new RecipeName(createRecipeRequest.getName()),
                new RecipeIngredients(createRecipeRequest.getIngredients())
        );

        recipeRepository.save(recipe);
    }
}
