package com.github.patu11.backend.notification;

import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.service.AnimeService;
import com.github.patu11.backend.service.CommonService;
import com.github.patu11.backend.service.SeriesService;
import com.github.patu11.backend.utils.AnimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationChecker {
    private final EmailService emailService;
    private final SeriesService seriesService;
    private final AnimeService animeService;
    private final Map<Type, CommonService> SERVICES = Map.of(
            Type.ANIME, animeService,
            Type.SERIES, seriesService
    );

    @Scheduled(cron = "0 0 1 * * ?")
    public void task() {
        seriesService.getAllSeriesTitles().forEach(this::notifyAboutPremiere);
        animeService.getAllAnimeIds().forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(UrlTitle urlTitle) {
        Type type = urlTitle.type();
        Episode nextEpisode = SERVICES.get(type).getNextEpisode(urlTitle.url());

        if (shouldSendEmail(nextEpisode, type)) {
            emailService.sendEmail(nextEpisode, urlTitle.title());
        }
    }

    private boolean shouldSendEmail(Episode episode, Type type) {
        String premiere = episode.premiere();
        LocalDate date = type == Type.ANIME ? AnimeUtils.parseDate(premiere) : LocalDate.parse(premiere);
        return LocalDate.now().isEqual(date);
    }

}
