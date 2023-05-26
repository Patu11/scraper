package com.github.patu11.gateway.service;


import comics.ComicResponse;
import common.UrlTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ComicsService {
    private final RestTemplate restTemplate;

    public ComicResponse handleRequest(String comicUrl) {
        return restTemplate.getForObject("/comic/" + comicUrl, ComicResponse.class);
    }

    public List<UrlTitle> getAllTitles() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity("/comic/titles", UrlTitle[].class).getBody())).toList();
    }
}
