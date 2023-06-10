package com.github.patu11.backend.scraper.series;


import com.github.patu11.backend.scraper.ConnectionService;
import com.github.patu11.backend.model.series.Season;
import com.github.patu11.backend.model.series.Series;

import java.util.List;

public interface SeriesScrapeService extends ConnectionService {
    String getTitle(String seriesUrl);

    Series getSeries(String seriesUrl);

    List<Season> getSeasons(String seriesUrl);
}
