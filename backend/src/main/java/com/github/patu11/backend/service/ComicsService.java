package com.github.patu11.backend.service;

import com.github.patu11.backend.model.comics.ComicResponse;
import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.scraper.ComicsScrapeService;
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

    public List<String> getAllComicsTitles() {
        return this.comicNames.stream()
                .map(entry -> entry + ":" + comicsScrapeService.getTitle(entry))
                .toList();
    }
}
