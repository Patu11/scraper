package com.github.patu11.backend.model.series;

import java.util.List;

public record Series(String title, List<Season> seasons) {
}
