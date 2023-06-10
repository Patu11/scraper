package com.github.patu11.backend.model.comics;

import java.io.Serializable;
import java.util.List;

public record Chapter(String title, List<Page> pages) implements Serializable {
}
