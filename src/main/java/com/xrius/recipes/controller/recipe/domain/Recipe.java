package com.xrius.recipes.controller.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Recipe {
    private String id;
    private List<String> ingredients;
}
