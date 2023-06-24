package com.github.patu11.backend.controller;


import com.github.patu11.backend.model.show.Episode;
import com.github.patu11.backend.model.show.Show;
import com.github.patu11.backend.service.ShowService;
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
public class ShowController {
    private final ShowService showService;

    @GetMapping("/show/{showId}")
    @Cacheable(value = "show", condition = "#enableCache")
    public Show getShow(@PathVariable String showId, @Value("${show.cache.enable}") boolean enableCache) {
        System.out.println("Received request for show: " + showId);
        return showService.getShow(showId);
    }

    @GetMapping("/show/title/{showId}")
    public String getTitle(@PathVariable String showId) {
        return showService.getTitle(showId);
    }

    @GetMapping("/show/{showId}/episodes/next")
    @Cacheable(value = "showNextEpisode", condition = "#enableCache")
    public Episode nextEpisode(@PathVariable String showId, @Value("${show.cache.enable}") boolean enableCache) {
        return showService.getNextEpisode(showId);
    }
}
