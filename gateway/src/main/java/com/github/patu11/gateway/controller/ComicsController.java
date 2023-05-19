package com.github.patu11.gateway.controller;


import com.github.patu11.gateway.service.ComicsService;
import comics.ComicResponse;
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

    @GetMapping("/comic/{comicUrl}")
    @Cacheable(value = "comics")
    public ComicResponse comics(@PathVariable("comicUrl") String comicUrl) {
        return comicsService.handleRequest(comicUrl);
    }

    @GetMapping("/comic/titles")
    public List<String> allTitles() {
        return comicsService.getAllTitles();
    }
}
