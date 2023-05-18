package com.github.patu11.backend.scraper;

import com.github.patu11.backend.model.comics.Chapter;
import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.model.comics.Page;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicOnlineScraper implements ComicsScrapeService {
    private static final String BASE_URL = "https://comiconlinefree.net/comic/";

    @Override
    public Comic getComic(String comicUrl) {
        String title = getTitle(comicUrl);
        List<Chapter> chapters = getChapters(comicUrl);
        return new Comic(title, chapters);
    }
    
    @Override
    public String getTitle(String comicUrl) {
        return connect(BASE_URL + comicUrl).getElementsByClass("manga-title").text();
    }

    private List<Chapter> getChapters(String comicUrl) {
        return getChaptersUrls(connect(BASE_URL + comicUrl)).stream()
                .map(this::connect)
                .map(this::mapChapter)
                .toList();
    }

    private Chapter mapChapter(Document document) {
        String title = document.getElementsByClass("title").tagName("h1").stream()
                .findFirst()
                .map(Element::text)
                .orElse("");

        List<Page> pages = document.getElementsByClass("lazyload chapter_img").stream()
                .map(element -> element.attr("data-original"))
                .map(this::mapPage)
                .toList();

        return new Chapter(title, pages);
    }

    private Page mapPage(String url) {
        return new Page(url);
    }

    private List<String> getChaptersUrls(Document document) {
        return document.getElementsByClass("ch-name").stream()
                .map(element -> element.attr("href"))
                .map(url -> url + "/full")
                .toList();
    }
}
