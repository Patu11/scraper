package com.github.patu11.backend.service;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.scraper.anime.AnimeScrapeService;
import com.github.patu11.backend.utils.AnimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AnimeService implements CommonService {
    private final List<String> animeIds;
    private final AnimeScrapeService animeScrapeService;

    public Anime getAnime(String animeId) {
        return animeScrapeService.getAnime(animeId);
    }

    public List<UrlTitle> getAllAnimeIds() {
        return this.animeIds.stream()
                .map(entry -> new UrlTitle(entry, animeScrapeService.getTitle(entry), Type.ANIME))
                .toList();
    }

    public Episode getNextEpisode(String animeId) {
        return animeScrapeService.getEpisodes(animeId).stream()
                .filter(this::isPremiereAfterToday)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("[Anime] Next episode not found."));
    }

    private boolean isPremiereAfterToday(Episode episode) {
        LocalDate premiereDate = AnimeUtils.parseDate(episode.premiere());
        return premiereDate.isAfter(LocalDate.now());
    }
}
