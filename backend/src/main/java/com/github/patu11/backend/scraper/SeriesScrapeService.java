package com.github.patu11.backend.scraper;

import com.github.patu11.backend.model.series.Series;

public interface SeriesScrapeService extends ConnectionService {
    String getTitle(String seriesUrl);

    Series getSeries(String seriesUrl);
}
