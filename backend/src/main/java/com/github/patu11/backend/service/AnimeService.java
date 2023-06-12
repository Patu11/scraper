package com.github.patu11.backend.service;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.scraper.anime.AnimeScrapeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AnimeService {
    private final List<String> animeIds;
    private final AnimeScrapeService animeScrapeService;

    public Anime getAnime(String animeId) {
        return animeScrapeService.getAnime(animeId);
    }

    public List<UrlTitle> getAllAnimeIds() {
        return this.animeIds.stream()
                .map(entry -> new UrlTitle(entry, animeScrapeService.getTitle(entry)))
                .toList();
    }

    public Episode getNextEpisode(String animeId) {
        return animeScrapeService.getEpisodes(animeId).stream()
                .filter(this::isPremiereAfterToday)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isPremiereAfterToday(Episode episode) {
        String premiere = episode.premiere();
        List<Integer> dateParts = Arrays.stream(premiere.split("\\.")).map(Integer::parseInt).toList();

        LocalDate premiereDate = LocalDate.of(dateParts.get(2), dateParts.get(1), dateParts.get(0));
        return premiereDate.isAfter(LocalDate.now());
    }
}
