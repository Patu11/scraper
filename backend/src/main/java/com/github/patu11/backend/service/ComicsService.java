package com.github.patu11.backend.service;

import com.github.patu11.backend.model.ComicResponse;
import com.github.patu11.backend.model.ComicType;
import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.scraper.ComicsScrapeService;
import com.github.patu11.backend.scraper.TheWalkingDeadScraper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ComicsService {
	private final Map<ComicType, ComicsScrapeService> comicsScrapeServiceMap = Map.of(ComicType.TWD, new TheWalkingDeadScraper());

	public ComicResponse handleRequest(ComicType comicType) {
		Comic comic = comicsScrapeServiceMap.get(comicType).getComic();
		return new ComicResponse(comic);
	}
}
