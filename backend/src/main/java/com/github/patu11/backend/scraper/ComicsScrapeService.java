package com.github.patu11.backend.scraper;

import comics.Comic;

public interface ComicsScrapeService extends ConnectionService {

    Comic getComic(String comicUrl);

    String getTitle(String comicUrl);

}
