package com.github.patu11.backend.scraper.anime;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Season;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImdbScraper implements AnimeScrapeService {
    private static final String BASE_URL = "https://www.imdb.com/title/";
    private static final String ALL_EPISODES_URL = BASE_URL + "{title}/episodes";
    private static final String SEASON_URL = ALL_EPISODES_URL + "?season={number}";

    @Override
    public Anime getAnime(String animeId) {
        String title = getTitle(animeId);
        List<Season> seasons = getSeasons(animeId);
        return new Anime(title, seasons);
    }

    @Override
    public String getTitle(String animeId) {
        return connect(BASE_URL + animeId).getElementsByClass("sc-afe43def-1 fDTGTb").text();
    }

    @Override
    public List<Season> getSeasons(String animeId) {
        int numberOfSeasons = getNumberOfSeasons(animeId);
        return Stream
                .iterate(1, n -> n + 1)
                .limit(numberOfSeasons)
                .map(num -> SEASON_URL
                        .replace("{title}", animeId)
                        .replace("{number}", String.valueOf(num)))
                .map(this::mapSeason)
                .toList();
    }

    @Override
    public List<Episode> getEpisodes(String animeId) {
        return getSeasons(animeId).stream()
                .map(Season::episodes)
                .flatMap(List::stream)
                .toList();
    }

    private Season mapSeason(String seasonUrl) {
        int seasonNumber = getSeasonNumber(seasonUrl);
        List<Episode> seasonEpisodes = getSeasonEpisodes(seasonUrl);
        return new Season(seasonNumber, seasonEpisodes);
    }

    private List<Episode> getSeasonEpisodes(String seasonUrl) {
        return connect(seasonUrl).getElementsByClass("list_item").stream()
                .map(this::mapEpisode)
                .toList();
    }

    private Episode mapEpisode(Element element) {
        String title = element.getElementsByAttribute("title").attr("title");
        String premiere = element.getElementsByClass("airdate").text();
        return new Episode(title, premiere);
    }

    private int getSeasonNumber(String seasonUrl) {
        String[] split = seasonUrl.split("=");
        return Integer.parseInt(split[split.length - 1]);
    }

    private int getNumberOfSeasons(String animeId) {
        return Optional.ofNullable(connect(ALL_EPISODES_URL.replace("{title}", animeId)).getElementById("bySeason"))
                .map(el -> el.getElementsByTag("option"))
                .map(ArrayList::size)
                .orElse(0);
    }
}
