package com.github.patu11.backend.model.show;

import java.io.Serializable;
import java.util.List;

public record Show(String title, String coverUrl, List<Season> seasons) implements Serializable {
}
