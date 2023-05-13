package com.xrius.recipes.recipe.domain.shared;

import lombok.EqualsAndHashCode;

import java.util.UUID;
@EqualsAndHashCode
public abstract class Identifier {
    private UUID value;

    public Identifier(String value) {
        ensureValidUUID(value);
        this.value = ensureValidUUID(value);
    }

    private UUID ensureValidUUID(String value) {
        return UUID.fromString(value);
    }

    public String value() {
        return value.toString();
    }
}
