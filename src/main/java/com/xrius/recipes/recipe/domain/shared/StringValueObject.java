package com.xrius.recipes.recipe.domain.shared;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@AllArgsConstructor
@EqualsAndHashCode
public abstract class StringValueObject {
    @NonNull
    private String value;
    private String value() {
        return value;
    }
}
