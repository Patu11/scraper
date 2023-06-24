package com.github.patu11.backend.controller;


import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.series.SeriesResponse;
import com.github.patu11.backend.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping("/series/{seriesUrl}")
    @Cacheable(value = "series", condition = "#enableCache")
    public SeriesResponse series(@PathVariable String seriesUrl, @Value("${series.cache.enable}") boolean enableCache) {
        System.out.println("Received request for series: " + seriesUrl);
        return seriesService.getSeries(seriesUrl);
    }
    
    @GetMapping("/series/title/{seriesUrl}")
    public String getTitle(@PathVariable String seriesUrl) {
        return seriesService.getTitle(seriesUrl);
    }

    @GetMapping("/series/{seriesUrl}/episodes/next")
    @Cacheable(value = "seriesNextEpisode", condition = "#enableCache")
    public Episode nextEpisode(@PathVariable String seriesUrl, @Value("${series.cache.enable}") boolean enableCache) {
        return seriesService.getNextEpisode(seriesUrl);
    }
}
