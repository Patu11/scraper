package com.github.patu11.backend.model.series;

import com.github.patu11.backend.model.common.Season;

import java.io.Serializable;
import java.util.List;

public record Series(String title, String coverUrl, List<Season> seasons) implements Serializable {
}
