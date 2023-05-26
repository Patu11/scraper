package com.github.patu11.backend.service;


import com.github.patu11.backend.scraper.comic.ComicsScrapeService;
import comics.Comic;
import comics.ComicResponse;
import common.UrlTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComicsService {
    private final List<String> comicNames;
    private final ComicsScrapeService comicsScrapeService;

    public ComicResponse handleRequest(String comicUrl) {
        Comic comic = comicsScrapeService.getComic(comicUrl);
        return new ComicResponse(comic);
    }

    public List<UrlTitle> getAllComicsTitles() {
        return this.comicNames.stream()
                .map(entry -> new UrlTitle(entry, comicsScrapeService.getTitle(entry)))
                .toList();
    }
}
