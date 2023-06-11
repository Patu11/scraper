package com.github.patu11.backend.model.series;

import java.io.Serializable;

public record Episode(String title, String premiere) implements Serializable {
}
