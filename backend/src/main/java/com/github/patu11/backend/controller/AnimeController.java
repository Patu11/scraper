package com.github.patu11.backend.controller;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.service.AnimeService;
import lombok.AllArgsConstructor;
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

    @Cacheable(value = "anime")
    @GetMapping("/anime/{animeId}")
    public Anime anime(@PathVariable("animeId") String animeId) {
        System.out.println("Received request for anime with id: " + animeId);
        return animeService.getAnime(animeId);
    }

    @GetMapping("/anime/titles")
    public List<UrlTitle> allTitles() {
        return animeService.getAllAnimeIds();
    }

    @Cacheable(value = "animeNextEpisode")
    @GetMapping("/anime/{animeId}/episodes/next")
    public Episode nextEpisode(@PathVariable("animeId") String animeId) {
        return animeService.getNextEpisode(animeId);
    }
}
