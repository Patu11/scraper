package com.github.patu11.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Configuration
public class RestTemplateConfig {

    @Value("${comics.backend.url}")
    private String comicsBackendUrl;

    @Bean
    public RestTemplate createRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(adjustUrl()).build();
    }

    private String adjustUrl() {
        return isDockerized() ?
                this.comicsBackendUrl.replace("localhost", "backend") :
                this.comicsBackendUrl;
    }

    private boolean isDockerized() {
        File f = new File("/.dockerenv");
        return f.exists();
    }
}
