package com.github.patu11.backend.model.comics;

import java.io.Serializable;
import java.util.List;

public record Comic(String title, List<Chapter> chapters) implements Serializable {
}
