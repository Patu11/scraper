package com.github.patu11.backend.service;

import com.github.patu11.backend.model.ComicResponse;
import com.github.patu11.backend.model.ComicType;
import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.scraper.ComicsScrapeService;
import com.github.patu11.backend.scraper.ComicOnlineScraper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ComicsService {
	private final Map<ComicType, ComicsScrapeService> comicsScrapeServiceMap = Map.of(ComicType.TWD, new ComicOnlineScraper());
	private final List<String> comicNames;
	private final ComicsScrapeService comicsScrapeService;

	public ComicResponse handleRequest(String comicUrl) {
//		Comic comic = comicsScrapeServiceMap.get(comicType).getComic();
		Comic comic = comicsScrapeService.getComic(comicUrl);
		return new ComicResponse(comic);
	}

	public List<String> getAllComicsTitles() {
		return this.comicNames.stream()
				.map(entry -> entry + ":" + comicsScrapeService.getTitle(entry))
				.toList();
	}
}
