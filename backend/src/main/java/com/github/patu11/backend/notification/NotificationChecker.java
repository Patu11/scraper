package com.github.patu11.backend.notification;

import com.github.patu11.backend.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import series.Episode;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NotificationChecker {
    private final EmailService emailService;
    private final SeriesService seriesService;

    @Scheduled(cron = "0 0 1 1/1 * ? *")
    public void task() {
        seriesService.getAllSeriesTitles().forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(String seriesTitles) {
        String[] split = seriesTitles.split(":");
        String seriesUrl = split[0];
        String title = split[1];

        Episode episode = seriesService.getNextEpisode(seriesUrl);

        if (shouldSendEmail(episode)) {
            emailService.sendEmail(episode, title);
        }
    }

    private boolean shouldSendEmail(Episode episode) {
        LocalDate premiereDate = LocalDate.parse(episode.premiere());
        return LocalDate.now().plusDays(1).isEqual(premiereDate);
    }
}
