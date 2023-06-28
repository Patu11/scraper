package com.github.patu11.backend.service;


import com.github.patu11.backend.exception.EmptyDateException;
import com.github.patu11.backend.model.show.Episode;
import com.github.patu11.backend.model.show.Season;
import com.github.patu11.backend.model.show.Show;
import com.github.patu11.backend.scraper.show.ShowScrapeService;
import com.github.patu11.backend.utils.ShowUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {
    private final ShowScrapeService showScrapeService;

    public Show getShow(String showId) {
        return showScrapeService.getShow(showId);
    }

    public String getTitle(String showId) {
        return showScrapeService.getTitle(showId);
    }

    public Episode getNextEpisode(String showId) {
        return showScrapeService.getSeasons(showId).stream()
                .map(Season::episodes)
                .flatMap(List::stream)
                .filter(this::isPremiereTodayOrAfter)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("[Show] Next episode not found for: " + showId));
    }

    private boolean isPremiereTodayOrAfter(Episode episode) {
        try {
            return ShowUtils.parseDate(episode.premiere()).isAfter(LocalDate.now().minusDays(1));
        } catch (EmptyDateException e) {
            return false;
        }
    }
}
