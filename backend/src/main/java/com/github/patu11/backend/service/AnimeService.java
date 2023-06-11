package com.github.patu11.backend.service;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.scraper.anime.AnimeScrapeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
