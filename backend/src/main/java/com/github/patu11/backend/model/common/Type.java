package com.github.patu11.backend.model.common;

import java.util.Arrays;

public enum Type {
    ANIME("anime"),
    SERIES("series"),
    COMIC("comic");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Type fromString(String name) {
        return Arrays.stream(Type.values())
                .filter(value -> value.name.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
