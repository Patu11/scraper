package com.github.patu11.backend.scraper.comic;

import com.github.patu11.backend.scraper.ConnectionService;
import comics.Comic;

public interface ComicsScrapeService extends ConnectionService {

    Comic getComic(String comicUrl);

    String getTitle(String comicUrl);

}
