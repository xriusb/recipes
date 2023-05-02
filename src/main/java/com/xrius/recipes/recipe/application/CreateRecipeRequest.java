package com.xrius.recipes.recipe.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public final class CreateRecipeRequest {
    private String id;
    private String name;
    private List<String> ingredients;

}
