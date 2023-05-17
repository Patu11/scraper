package com.github.patu11.backend.controller;

import com.github.patu11.backend.model.ComicResponse;

import com.github.patu11.backend.model.ComicType;
import com.github.patu11.backend.service.ComicsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ComicsController {

	private final ComicsService comicsService;

	@GetMapping("/comic/{comicUrl}")
	public ComicResponse comics(@PathVariable("comicUrl") String comicUrl) {
		System.out.println("Received request: " + comicUrl);
		return comicsService.handleRequest(comicUrl);
	}

	@GetMapping("/comic/titles")
	public List<String> allTitles() {
		return comicsService.getAllComicsTitles();
	}
}
