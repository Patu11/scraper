package com.github.patu11.backend.controller;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping("/anime/{animeId}")
    @Cacheable(value = "anime", condition = "#enableCache")
    public Anime anime(@PathVariable("animeId") String animeId, @Value("${anime.cache.enable}") boolean enableCache) {
        System.out.println("Received request for anime with id: " + animeId);
        return animeService.getAnime(animeId);
    }

    @GetMapping("/anime/titles")
    public List<UrlTitle> allTitles() {
        return animeService.getAllAnimeIds();
    }

    @GetMapping("/anime/{animeId}/episodes/next")
    @Cacheable(value = "animeNextEpisode", condition = "#enableCache")
    public Episode nextEpisode(@PathVariable("animeId") String animeId, @Value("${anime.cache.enable}") boolean enableCache) {
        return animeService.getNextEpisode(animeId);
    }
}
