package com.github.patu11.backend.controller;


import com.github.patu11.backend.service.ComicsService;
import com.github.patu11.backend.model.comics.ComicResponse;
import com.github.patu11.backend.model.common.UrlTitle;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "comics")
    @GetMapping("/comic/{comicUrl}")
    public ComicResponse comics(@PathVariable("comicUrl") String comicUrl) {
        System.out.println("Received request for comic: " + comicUrl);
        return comicsService.handleRequest(comicUrl);
    }

    @GetMapping("/comic/titles")
    public List<UrlTitle> allTitles() {
        return comicsService.getAllComicsTitles();
    }
}
