package com.github.patu11.backend.scraper.anime;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Season;
import com.github.patu11.backend.scraper.ConnectionService;

import java.util.List;

public interface AnimeScrapeService extends ConnectionService {
    Anime getAnime(String animeId);

    String getTitle(String animeId);

    List<Season> getSeasons(String animeId);

    List<Episode> getEpisodes(String animeId);
}
