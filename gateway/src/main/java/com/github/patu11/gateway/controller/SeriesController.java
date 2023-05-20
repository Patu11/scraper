package com.github.patu11.gateway.controller;

import com.github.patu11.gateway.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import series.Episode;
import series.SeriesResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class SeriesController {
    private final SeriesService seriesService;

    @Cacheable(value = "series")
    @GetMapping("/series/{seriesUrl}")
    public SeriesResponse series(@PathVariable("seriesUrl") String seriesUrl) {
        return seriesService.getSeries(seriesUrl);
    }

    @GetMapping("/series/titles")
    public List<String> allTitles() {
        return seriesService.getAllTitles();
    }

    @Cacheable(value = "nextEpisode")
    @GetMapping("/series/{seriesUrl}/episodes/next")
    public Episode nextEpisode(@PathVariable String seriesUrl) {
        return seriesService.getNextEpisode(seriesUrl);
    }
}
