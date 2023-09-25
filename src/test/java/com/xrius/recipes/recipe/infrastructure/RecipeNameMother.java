package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.RecipeName;
import org.apache.commons.lang3.RandomStringUtils;

public final class RecipeNameMother {
    public static RecipeName create(String value) {
        return new RecipeName(value);
    }

    public static RecipeName random() {
        return new RecipeName(RandomStringUtils.randomAlphabetic(10));
    }
}
