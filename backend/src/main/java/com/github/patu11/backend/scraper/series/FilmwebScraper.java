package com.github.patu11.backend.scraper.series;


import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.series.Season;
import com.github.patu11.backend.model.series.Series;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class FilmwebScraper implements SeriesScrapeService {
    private static final String BASE_URL = "https://www.filmweb.pl";
    private static final String BASE_URL_SERIES = BASE_URL + "/serial/";
    private static final String TITLE_UNKNOWN = "Title Unknown";

    @Override
    public String getTitle(String seriesUrl) {
        return connect(BASE_URL_SERIES + seriesUrl).getElementsByClass("filmCoverSection__title").text();
    }

    @Override
    public Series getSeries(String seriesUrl) {
        return new Series(getTitle(seriesUrl), getCover(seriesUrl), getSeasons(seriesUrl));
    }
    
    @Override
    public List<Season> getSeasons(String seriesUrl) {
        Elements seasonsElement = connect(BASE_URL_SERIES + seriesUrl).getElementsByClass("squareNavigation__item");

        if (seasonsElement.isEmpty()) {
            return Collections.singletonList(new Season(1, getEpisodes("/serial/" + seriesUrl + "/episode/list")));
        }

        return seasonsElement.eachAttr("href")
                .stream()
                .map(this::mapSeason)
                .toList();
    }

    private Season mapSeason(String seasonUrl) {
        int seasonNumber = extractSeasonNumber(seasonUrl);
        List<Episode> episodes = getEpisodes(seasonUrl);
        return new Season(seasonNumber, episodes);
    }

    private String getCover(String seriesUrl) {
        return Objects.requireNonNull(connect(BASE_URL_SERIES + seriesUrl).getElementById("filmPoster")).attr("src");
    }

    private List<Episode> getEpisodes(String seasonUrl) {
        return connect(BASE_URL + seasonUrl).getElementsByClass("previewEpisode").stream()
                .map(this::mapEpisode)
                .toList();
    }

    private Episode mapEpisode(Element element) {
        String title = extractTitle(element);
        String premiereDate = element.attr("data-air-date");
        return new Episode(title, premiereDate);
    }

    private String extractTitle(Element element) {
        String title = element.getElementsByClass("posterEpisode").attr("title");
        return title.isEmpty() ? TITLE_UNKNOWN : title;
    }

    private int extractSeasonNumber(String seasonUrl) {
        String[] split = seasonUrl.split("/");
        return Integer.parseInt(split[split.length - 1]);
    }
}
