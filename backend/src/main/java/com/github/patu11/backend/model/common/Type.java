package com.github.patu11.backend.model.common;

public enum Type {
    SHOW("show"),
    COMIC("comic");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
