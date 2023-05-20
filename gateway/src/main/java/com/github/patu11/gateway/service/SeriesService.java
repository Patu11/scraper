package com.github.patu11.gateway.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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

    public List<String> getAllTitles() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity("/series/titles", String[].class).getBody())).toList();
    }
}
