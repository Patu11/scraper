package com.github.patu11.backend.notification;

import com.github.patu11.backend.exception.EmptyDateException;
import com.github.patu11.backend.model.common.Episode;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import com.github.patu11.backend.service.AnimeService;
import com.github.patu11.backend.service.CommonService;
import com.github.patu11.backend.service.ScrapingPropertiesService;
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
    private final ScrapingPropertiesService scrapingPropertiesService;
    private final Map<Type, CommonService> SERVICES;

    @Autowired
    public NotificationChecker(EmailService emailService, SeriesService seriesService, AnimeService animeService, ScrapingPropertiesService scrapingPropertiesService) {
        this.emailService = emailService;
        this.scrapingPropertiesService = scrapingPropertiesService;
        SERVICES = Map.of(
                Type.ANIME, animeService,
                Type.SERIES, seriesService
        );
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void task() {
        scrapingPropertiesService.getAllPropertiesByType(Type.ANIME.getName()).forEach(this::notifyAboutPremiere);
        scrapingPropertiesService.getAllPropertiesByType(Type.SERIES.getName()).forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(ScrapingPropertyDto scrapingPropertyDto) {
        Type type = Type.fromString(scrapingPropertyDto.type());

        try {
            CommonService service = SERVICES.get(type);
            Episode nextEpisode = service.getNextEpisode(scrapingPropertyDto.name());

            if (shouldSendEmail(nextEpisode, type)) {
                String title = service.getTitle(scrapingPropertyDto.name());
                emailService.sendEmail(nextEpisode, title);
                System.out.println("Email sent.");
            }
        } catch (Exception exception) {
            System.out.printf("%s %s%n", LocalDateTime.now(), exception.getMessage());
        }
    }

    private boolean shouldSendEmail(Episode episode, Type type) {
        String premiere = episode.premiere();
        LocalDate now = LocalDate.now();

        return switch (type) {
            case ANIME -> {
                try {
                    yield now.isEqual(AnimeUtils.parseDate(premiere));
                } catch (EmptyDateException e) {
                    yield false;
                }
            }
            case SERIES -> SeriesUtils.isValidSeriesDate(premiere) && now.isEqual(LocalDate.parse(premiere));
            default -> false;
        };
    }
}
