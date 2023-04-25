package com.xrius.recipes.controller.recipe;

import com.xrius.recipes.controller.recipe.application.RecipeCreator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public final class RecipesPutController {
    private RecipeCreator recipeCreator;

    public RecipesPutController(RecipeCreator recipeCreator) {
        this.recipeCreator = recipeCreator;
    }

    @PutMapping("/recipes/{recipeId}")
    public ResponseEntity create(
            @PathVariable String recipeId,
            @RequestBody Request request
    ) {
        return ResponseEntity.status(CREATED).build();
    }
}

@Getter
@Setter
final class Request {
    private String name;
    private List<String> ingredients;
}