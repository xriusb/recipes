package com.xrius.recipes.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Recipe {
    private RecipeId id;
    private RecipeName name;
    private RecipeIngredients ingredients;
}
