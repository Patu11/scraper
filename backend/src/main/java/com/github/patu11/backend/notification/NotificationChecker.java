package com.github.patu11.backend.notification;

import com.github.patu11.backend.service.SeriesService;
import com.github.patu11.backend.model.common.UrlTitle;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.github.patu11.backend.model.common.Episode;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NotificationChecker {
    private final EmailService emailService;
    private final SeriesService seriesService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void task() {
        seriesService.getAllSeriesTitles().forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(UrlTitle urlTitle) {
        Episode episode = seriesService.getNextEpisode(urlTitle.url());

        if (shouldSendEmail(episode)) {
            emailService.sendEmail(episode, urlTitle.title());
        }
    }

    private boolean shouldSendEmail(Episode episode) {
        LocalDate premiereDate = LocalDate.parse(episode.premiere());
        return LocalDate.now().isEqual(premiereDate);
    }
}
