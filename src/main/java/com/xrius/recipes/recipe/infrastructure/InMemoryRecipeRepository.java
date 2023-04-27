package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public final class InMemoryRecipeRepository implements RecipeRepository {

    private HashMap<String, Recipe> recipes = new HashMap<>();
    @Override
    public void save(Recipe recipe) {
        this.recipes.put(recipe.getId(), recipe);

    }

    @Override
    public Optional<Recipe> search(String id) {
        return Optional.ofNullable(recipes.get(id));
    }
}
