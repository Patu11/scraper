package com.github.patu11.backend.controller;


import com.github.patu11.backend.service.SeriesService;
import common.UrlTitle;
import lombok.AllArgsConstructor;
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

    @GetMapping("/series/{seriesUrl}")
    public SeriesResponse series(@PathVariable String seriesUrl) {
        System.out.println("Received request for series: " + seriesUrl);
        return seriesService.getSeries(seriesUrl);
    }

    @GetMapping("/series/titles")
    public List<UrlTitle> allTitles() {
        return seriesService.getAllSeriesTitles();
    }

    @GetMapping("/series/{seriesUrl}/episodes/next")
    public Episode nextEpisode(@PathVariable String seriesUrl) {
        return seriesService.getNextEpisode(seriesUrl);
    }
}