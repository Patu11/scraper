package com.github.patu11.backend.scraper.anime;

import com.github.patu11.backend.model.anime.Anime;
import com.github.patu11.backend.model.common.Episode;
import io.netty.util.internal.StringUtil;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AniDBScraper implements AnimeScrapeService {
    private static final String BASE_URL = "https://anidb.net/anime/";

    public Anime getAnime(String animeId) {
        String title = getTitle(animeId);
        List<Episode> episodes = getEpisodes(animeId);

        return new Anime(title, episodes);
    }

    @Override
    public String getTitle(String animeId) {
        return connect(BASE_URL + animeId).getElementsByTag("h1").stream()
                .findFirst()
                .map(Element::text)
                .map(text -> text.substring(7))
                .orElse(StringUtil.EMPTY_STRING);
    }

    private List<Episode> getEpisodes(String animeId) {
        Element episodesTable = connect(BASE_URL + animeId).getElementById("eplist");
        if (episodesTable == null) {
            return Collections.emptyList();
        }

        return episodesTable.getElementsByTag("tr").stream()
                .filter(el -> !el.hasClass("header"))
                .filter(el -> !isOpeningOrEnding(el))
                .map(this::mapEpisode).collect(Collectors.toList());
    }

    private Episode mapEpisode(Element element) {
        String title = element.getElementsByClass("title name episode").text();
        String airDate = element.getElementsByClass("date airdate").text();
        return new Episode(title, airDate);
    }

    private boolean isOpeningOrEnding(Element element) {
        String id = element.getElementsByClass("id eid").text();
        return id.contains("OP") || id.contains("ED") || id.contains("C");
    }
}
