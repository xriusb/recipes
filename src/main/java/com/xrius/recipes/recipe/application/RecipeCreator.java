package com.xrius.recipes.recipe.application;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public final class RecipeCreator {
    private RecipeRepository recipeRepository;

    public void execute(String id, List<String> ingredients) {
        val recipe = new Recipe(id, ingredients);

        recipeRepository.save(recipe);
    }
}
