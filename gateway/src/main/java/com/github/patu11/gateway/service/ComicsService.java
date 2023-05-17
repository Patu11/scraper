package com.github.patu11.gateway.service;

import com.github.patu11.gateway.model.ComicResponse;
import com.github.patu11.gateway.model.ComicType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ComicsService {
	private final RestTemplate restTemplate;

	public ComicResponse handleRequest(String comicUrl) {
		return restTemplate.getForObject("/comic/" + comicUrl, ComicResponse.class);
	}

	public List<String> getAllTitles() {
		return Arrays.stream(restTemplate.getForEntity("/comic/titles", String[].class).getBody()).toList();
	}
}
