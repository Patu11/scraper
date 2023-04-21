package com.github.patu11.backend.model.comics;

import java.util.List;

public record Comic(String title, List<Chapter> chapters) {
}
