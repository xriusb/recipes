package com.xrius.recipes.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Recipe {
    private String id;
    private List<String> ingredients;
}
