package com.github.patu11.gateway.model.comics;

import java.io.Serializable;
import java.util.List;

public record Comic(String title, List<Chapter> chapters) implements Serializable {
}
