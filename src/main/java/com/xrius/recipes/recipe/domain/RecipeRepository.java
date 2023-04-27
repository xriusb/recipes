package com.xrius.recipes.recipe.domain;

import java.util.Optional;

public interface RecipeRepository {

    void save(Recipe recipe);

    Optional<Recipe> search(String id);

}
