package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeId;
import com.xrius.recipes.recipe.domain.RecipeIngredients;
import com.xrius.recipes.recipe.domain.RecipeName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InMemoryRecipeRepositoryTest {

    @Test
    void save_a_valid_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        inMemoryRecipeRepository.save(new Recipe(
                new RecipeId(randomUUID().toString()),
                new RecipeName("name"),
                new RecipeIngredients(List.of("ingredient 1", "ingredient 2"))
        ));
    }

    @Test
    void search_an_existing_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        Recipe recipe = new Recipe(
                new RecipeId(randomUUID().toString()),
                new RecipeName("name"),
                new RecipeIngredients(List.of("ingredient 1", "ingredient 2"))
        );

        inMemoryRecipeRepository.save(recipe);

        assertEquals(Optional.of(recipe), inMemoryRecipeRepository.search(recipe.getId().value()));
    }

    @Test
    void not_find_a_non_existing_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        assertFalse(inMemoryRecipeRepository.search(randomUUID().toString()).isPresent());
    }
}