package com.github.patu11.backend.scraper.comic;

import com.github.patu11.backend.scraper.ConnectionService;
import com.github.patu11.backend.model.comics.Comic;

public interface ComicsScrapeService extends ConnectionService {

    Comic getComic(String comicUrl);

    String getTitle(String comicUrl);

}
