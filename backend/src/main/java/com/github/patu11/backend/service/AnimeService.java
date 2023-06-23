package com.github.patu11.backend.service;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.scraper.anime.AnimeScrapeService;
import com.github.patu11.backend.utils.AnimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AnimeService implements CommonService {
    private final AnimeScrapeService animeScrapeService;

    public Anime getAnime(String animeId) {
        return animeScrapeService.getAnime(animeId);
    }

    @Override
    public String getTitle(String animeId) {
        return this.animeScrapeService.getTitle(animeId);
    }

    @Override
    public Episode getNextEpisode(String animeId) {
        return animeScrapeService.getEpisodes(animeId).stream()
                .filter(this::isPremiereAfterToday)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("[Anime] Next episode not found for: " + animeId));
    }

    private boolean isPremiereAfterToday(Episode episode) {
        LocalDate premiereDate = AnimeUtils.parseDate(episode.premiere());
        return premiereDate.isAfter(LocalDate.now());
    }
}
