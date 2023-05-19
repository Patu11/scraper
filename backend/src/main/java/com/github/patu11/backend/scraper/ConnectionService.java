package com.github.patu11.backend.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public interface ConnectionService {
    default Document connect(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException exception) {
            throw new RuntimeException("Cannot connect to url: " + url);
        }
    }
}
