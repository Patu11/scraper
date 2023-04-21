package com.github.patu11.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Value("${comics.backend.url}")
    private String comicsBackendUrl;

    @Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(comicsBackendUrl).build();
    }
}
