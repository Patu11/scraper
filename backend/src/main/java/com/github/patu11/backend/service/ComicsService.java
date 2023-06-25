package com.github.patu11.backend.service;


import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.model.comics.ComicResponse;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import com.github.patu11.backend.scraper.comic.ComicsScrapeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComicsService {
    private final ComicsScrapeService comicsScrapeService;
    private final ScrapingPropertiesService scrapingPropertiesService;

    public ComicResponse handleRequest(String comicUrl) {
        Comic comic = comicsScrapeService.getComic(comicUrl);
        return new ComicResponse(comic);
    }

    public List<UrlTitle> getAllComicsTitles() {
        return this.scrapingPropertiesService.getAllPropertiesByType(Type.COMIC.name()).stream()
                .map(ScrapingPropertyDto::name)
                .map(entry -> new UrlTitle(entry, comicsScrapeService.getTitle(entry), Type.COMIC))
                .toList();
    }
}
