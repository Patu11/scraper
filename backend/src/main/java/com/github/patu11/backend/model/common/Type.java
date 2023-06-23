package com.github.patu11.backend.model.common;

public enum Type {
    ANIME("anime"),
    SERIES("series"),
    COMIC("comic");

    private final String name;


    Type(String name) {
        this.name = name;
    }
}
