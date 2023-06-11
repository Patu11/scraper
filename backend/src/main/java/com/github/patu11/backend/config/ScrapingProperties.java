package com.github.patu11.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:scraping.properties")
public class ScrapingProperties {
    @Value("${comic.names}")
    private List<String> comicNames;

    @Value("${series.urls}")
    private List<String> seriesUrls;

    @Value("${anime.ids}")
    private List<String> animeIds;

    @Bean("comicNames")
    public List<String> getComicNames() {
        return comicNames;
    }

    @Bean("seriesUrls")
    public List<String> getSeriesUrls() {
        return seriesUrls;
    }

    @Bean("animeIds")
    public List<String> getAnimeIds() {
        return animeIds;
    }
}