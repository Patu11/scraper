package com.github.patu11.backend.service;


import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.model.series.Season;
import com.github.patu11.backend.model.series.SeriesResponse;
import com.github.patu11.backend.scraper.series.SeriesScrapeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SeriesService {
    private final List<String> seriesUrls;
    private final SeriesScrapeService seriesScrapeService;

    public SeriesResponse getSeries(String seriesUrl) {
        return new SeriesResponse(seriesScrapeService.getSeries(seriesUrl));
    }

    public List<UrlTitle> getAllSeriesTitles() {
        return this.seriesUrls.stream()
                .map(entry -> new UrlTitle(entry, seriesScrapeService.getTitle(entry)))
                .toList();
    }

    public Episode getNextEpisode(String seriesUrl) {
        return seriesScrapeService.getSeasons(seriesUrl).stream()
                .map(Season::episodes)
                .flatMap(List::stream)
                .filter(this::isPremiereAfterToday)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isPremiereAfterToday(Episode episode) {
        String premiere = episode.premiere();
        if (premiere.split("-").length == 1) {
            return Integer.parseInt(premiere.split("-")[0]) >= LocalDate.now().getYear();
        }
        LocalDate premiereDate = LocalDate.parse(premiere);
        return premiereDate.isAfter(LocalDate.now());
    }
}
