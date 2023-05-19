package com.github.patu11.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:series.properties")
public class SeriesProperties {

    @Value("${series.urls}")
    private List<String> seriesUrls;

    @Bean("seriesUrls")
    public List<String> getSeriesUrls() {
        return seriesUrls;
    }
}
