package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InMemoryRecipeRepositoryTest {

    @Test
    void save_a_valid_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        inMemoryRecipeRepository.save(new Recipe("some id", List.of("ingredient 1", "ingredient 2")));
    }

    @Test
    void search_an_existing_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        Recipe recipe = new Recipe("some id", List.of("ingredient 1", "ingredient 2"));

        inMemoryRecipeRepository.save(recipe);

        assertEquals(Optional.of(recipe), inMemoryRecipeRepository.search(recipe.getId()));
    }

    @Test
    void not_find_a_non_existing_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        assertFalse(inMemoryRecipeRepository.search("random id").isPresent());
    }
}