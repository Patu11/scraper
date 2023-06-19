package com.github.patu11.backend.model.series;

import com.github.patu11.backend.model.common.Episode;

import java.io.Serializable;
import java.util.List;

public record Season(int number, List<Episode> episodes) implements Serializable {
}
