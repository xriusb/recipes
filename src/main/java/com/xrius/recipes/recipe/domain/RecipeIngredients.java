package com.xrius.recipes.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class RecipeIngredients {
    private final List<String> values;
}
