package com.github.patu11.backend.model.anime;

import com.github.patu11.backend.model.common.Season;

import java.io.Serializable;
import java.util.List;

public record Anime(String title, List<Season> seasons) implements Serializable {
}
