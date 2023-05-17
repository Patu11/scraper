package com.github.patu11.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:comic.properties")
public class ComicProperties {

	@Value("${comic.names}")
	private List<String> comicNames;

	@Bean("comicNames")
	public List<String> getComicNames() {
		return comicNames;
	}
}
