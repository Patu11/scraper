package com.github.patu11.backend.scraper.anime;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.scraper.ConnectionService;

public interface AnimeScrapeService extends ConnectionService {
    Anime getAnime(String animeId);

    String getTitle(String animeId);
}
