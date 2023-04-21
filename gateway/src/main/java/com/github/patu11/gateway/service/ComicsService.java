package com.github.patu11.gateway.service;

import com.github.patu11.gateway.model.ComicResponse;
import com.github.patu11.gateway.model.ComicType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ComicsService {
	private final RestTemplate restTemplate;

	public ComicResponse handleRequest(ComicType comicType) {
		return restTemplate.getForObject("/comic/" + comicType, ComicResponse.class);
	}
}
