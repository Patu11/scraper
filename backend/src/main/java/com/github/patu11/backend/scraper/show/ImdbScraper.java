package com.github.patu11.backend.scraper.show;

import com.github.patu11.backend.model.show.Episode;
import com.github.patu11.backend.model.show.Season;
import com.github.patu11.backend.model.show.Show;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImdbScraper implements ShowScrapeService {
    private static final String BASE_URL = "https://www.imdb.com/title/";
    private static final String ALL_EPISODES_URL = BASE_URL + "{title}/episodes";
    private static final String SEASON_URL = ALL_EPISODES_URL + "?season={number}";

    @Override
    public Show getShow(String showId) {
        String title = getTitle(showId);
        List<Season> seasons = getSeasons(showId);
        String coverUrl = getCoverUrl(showId);
        return new Show(title, coverUrl, seasons);
    }

    @Override
    public String getTitle(String showId) {
        return connect(BASE_URL + showId).getElementsByClass("sc-afe43def-1 fDTGTb").text();
    }

    @Override
    public List<Season> getSeasons(String showId) {
        int numberOfSeasons = getNumberOfSeasons(showId);
        return Stream
                .iterate(1, n -> n + 1)
                .limit(numberOfSeasons)
                .map(num -> SEASON_URL
                        .replace("{title}", showId)
                        .replace("{number}", String.valueOf(num)))
                .map(this::mapSeason)
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

    private String getCoverUrl(String showId) {
        return connect(BASE_URL + showId).getElementsByAttributeValue("property", "og:image").stream()
                .findFirst()
                .map(el -> el.attr("content"))
                .orElseGet(String::new);
    }

    private int getNumberOfSeasons(String showId) {
        return Optional.ofNullable(connect(ALL_EPISODES_URL.replace("{title}", showId)).getElementById("bySeason"))
                .map(el -> el.getElementsByTag("option"))
                .map(ArrayList::size)
                .orElse(0);
    }
}
