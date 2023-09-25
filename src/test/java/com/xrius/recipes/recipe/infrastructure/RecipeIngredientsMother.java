package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.RecipeIngredients;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public final class RecipeIngredientsMother {
    public static RecipeIngredients create(List<String> ingredients) {
        return new RecipeIngredients(ingredients);
    }

    public static RecipeIngredients random() {
        return new RecipeIngredients(List.of(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10)
        ));
    }
}
