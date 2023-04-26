package com.xrius.recipes.recipe.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GetRecipeController {
    @GetMapping("/recipes")
    public Map<String, String> handle() {
        return Map.of("recipe", "ok");
    }
}
