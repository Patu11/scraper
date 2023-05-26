package com.github.patu11.gateway.service;

import common.UrlTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import series.Episode;
import series.SeriesResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SeriesService {
    private final RestTemplate restTemplate;

    public SeriesResponse getSeries(String seriesUrl) {
        return restTemplate.getForObject("/series/" + seriesUrl, SeriesResponse.class);
    }

    public List<UrlTitle> getAllTitles() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity("/series/titles", UrlTitle[].class).getBody())).toList();
    }

    public Episode getNextEpisode(String seriesUrl) {
        return restTemplate.getForObject(String.format("/series/%s/episodes/next", seriesUrl), Episode.class);
    }
}
