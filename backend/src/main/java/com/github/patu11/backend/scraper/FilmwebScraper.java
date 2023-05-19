package com.github.patu11.backend.scraper;


import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import series.Episode;
import series.Season;
import series.Series;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilmwebScraper implements SeriesScrapeService {
    private static final String BASE_URL = "https://www.filmweb.pl";
    private static final String BASE_URL_SERIES = BASE_URL + "/serial/";


    @Override
    public String getTitle(String seriesUrl) {
        return connect(BASE_URL_SERIES + seriesUrl).getElementsByClass("filmCoverSection__title").text();
    }

    @Override
    public Series getSeries(String seriesUrl) {
        return new Series(getTitle(seriesUrl), getSeasons(seriesUrl));
    }

    private List<Season> getSeasons(String seriesUrl) {
        return connect(BASE_URL_SERIES + seriesUrl).getElementsByClass("squareNavigation__item").eachAttr("href")
                .stream()
                .map(this::mapSeason)
                .toList();
    }

    private Season mapSeason(String seasonUrl) {
        int seasonNumber = extractSeasonNumber(seasonUrl);
        List<Episode> episodes = getEpisodes(seasonUrl);
        return new Season(seasonNumber, episodes);
    }

    private List<Episode> getEpisodes(String seasonUrl) {
        return connect(BASE_URL + seasonUrl).getElementsByClass("previewEpisode").stream()
                .map(this::mapEpisode)
                .toList();
    }

    private Episode mapEpisode(Element element) {
        String title = element.getElementsByClass("posterEpisode").attr("title");
        LocalDate premiereDate = LocalDate.parse(element.attr("data-air-date"));
        return new Episode(title, premiereDate);
    }

    private int extractSeasonNumber(String seasonUrl) {
        String[] split = seasonUrl.split("/");
        return Integer.parseInt(split[split.length - 1]);
    }
}
