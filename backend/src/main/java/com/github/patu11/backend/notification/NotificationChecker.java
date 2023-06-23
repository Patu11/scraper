package com.github.patu11.backend.notification;

import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.common.UrlTitle;
import com.github.patu11.backend.service.AnimeService;
import com.github.patu11.backend.service.CommonService;
import com.github.patu11.backend.service.SeriesService;
import com.github.patu11.backend.utils.AnimeUtils;
import com.github.patu11.backend.utils.SeriesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class NotificationChecker {
    private final EmailService emailService;
    private final SeriesService seriesService;
    private final AnimeService animeService;
    private final Map<Type, CommonService> SERVICES;

    @Autowired
    public NotificationChecker(EmailService emailService, SeriesService seriesService, AnimeService animeService) {
        this.emailService = emailService;
        this.seriesService = seriesService;
        this.animeService = animeService;
        SERVICES = Map.of(
                Type.ANIME, animeService,
                Type.SERIES, seriesService
        );
    }

    //    @Scheduled(cron = "0 0 1 * * ?")
    @Scheduled(fixedDelay = 5000)
    public void task() {
        seriesService.getAllSeriesTitles().forEach(this::notifyAboutPremiere);
        animeService.getAllAnimeIds().forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(UrlTitle urlTitle) {
        Type type = urlTitle.type();

        try {
            Episode nextEpisode = SERVICES.get(type).getNextEpisode(urlTitle.url());

            if (shouldSendEmail(nextEpisode, type)) {
                emailService.sendEmail(nextEpisode, urlTitle.title());
            }
        } catch (Exception exception) {
            System.out.printf("%s %s%n", LocalDateTime.now(), exception.getMessage());
        }
    }

    private boolean shouldSendEmail(Episode episode, Type type) {
        String premiere = episode.premiere();
        LocalDate now = LocalDate.now();

        return switch (type) {
            case ANIME -> now.isEqual(AnimeUtils.parseDate(premiere));
            case SERIES -> SeriesUtils.isValidSeriesDate(premiere) && now.isEqual(LocalDate.parse(premiere));
            default -> false;
        };
    }
}
