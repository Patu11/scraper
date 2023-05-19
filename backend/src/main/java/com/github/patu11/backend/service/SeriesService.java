package com.github.patu11.backend.service;


import com.github.patu11.backend.scraper.SeriesScrapeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import series.SeriesResponse;

import java.util.List;

@Service
@AllArgsConstructor
public class SeriesService {
    private final List<String> seriesUrls;
    private final SeriesScrapeService seriesScrapeService;

    public SeriesResponse getSeries(String seriesUrl) {
        return new SeriesResponse(seriesScrapeService.getSeries(seriesUrl));
    }

    public List<String> getAllSeriesTitles() {
        return seriesUrls;
    }
}
