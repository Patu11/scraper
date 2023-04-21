package com.github.patu11.gateway.model;

import com.github.patu11.gateway.model.comics.Comic;

import java.io.Serializable;

public record ComicResponse(Comic comic) implements Serializable {
}
