package com.github.patu11.backend.scraper;

import com.github.patu11.backend.model.comics.Chapter;
import com.github.patu11.backend.model.comics.Comic;
import com.github.patu11.backend.model.comics.Page;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public class TheWalkingDeadScraper implements ComicsScrapeService {
	public static final String TWD_URL = "https://comiconlinefree.net/comic/the-walking-dead";

	@Override
	public Comic getComic() {
		Document doc = connect(TWD_URL);
		String title = getTitle(doc);
		List<Chapter> chapters = getChapters(doc);
		return new Comic(title, chapters);
	}

	private List<Chapter> getChapters(Document document) {
		return getChaptersUrls(document).stream()
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

	private String getTitle(Document document) {
		return document.getElementsByClass("manga-title").text();
	}
}
