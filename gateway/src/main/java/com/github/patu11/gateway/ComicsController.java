package com.github.patu11.gateway;

import com.github.patu11.gateway.model.ComicResponse;
import com.github.patu11.gateway.model.ComicType;
import com.github.patu11.gateway.service.ComicsService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value = "comics")
	public ComicResponse comics(@PathVariable("comicType") ComicType comicType) {
		return comicsService.handleRequest(comicType);
	}
}
