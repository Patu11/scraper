package com.github.patu11.backend.scraper.show;


import com.github.patu11.backend.model.show.Season;
import com.github.patu11.backend.model.show.Show;
import com.github.patu11.backend.scraper.ConnectionService;

import java.util.List;

public interface ShowScrapeService extends ConnectionService {
    String getTitle(String showId);

    Show getShow(String showId);

    List<Season> getSeasons(String showId);
}
