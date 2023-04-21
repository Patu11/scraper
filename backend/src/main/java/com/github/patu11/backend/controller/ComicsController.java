package com.github.patu11.backend.controller;

import com.github.patu11.backend.model.ComicResponse;

import com.github.patu11.backend.model.ComicType;
import com.github.patu11.backend.service.ComicsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ComicsController {

    private final ComicsService comicsService;

    @GetMapping("/comic/{comicType}")
    public ComicResponse comics(@PathVariable("comicType") ComicType comicType) {
        System.out.println("Received request: "+comicType);
        return comicsService.handleRequest(comicType);
    }
}
