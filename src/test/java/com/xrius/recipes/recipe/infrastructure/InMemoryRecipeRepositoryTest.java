package com.xrius.recipes.recipe.infrastructure;

import com.xrius.recipes.recipe.domain.Recipe;
import com.xrius.recipes.recipe.domain.RecipeId;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class InMemoryRecipeRepositoryTest {

    @Test
    void save_a_valid_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        inMemoryRecipeRepository.save(new Recipe(
                new RecipeId(randomUUID().toString()),
                RecipeNameMother.random(),
                RecipeIngredientsMother.random()
        ));
    }

    @Test
    void search_an_existing_recipe() {
        InMemoryRecipeRepository inMemoryRecipeRepository = new InMemoryRecipeRepository();

        Recipe recipe = new Recipe(
                new RecipeId(randomUUID().toString()),
                RecipeNameMother.random(),
                RecipeIngredientsMother.random()
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