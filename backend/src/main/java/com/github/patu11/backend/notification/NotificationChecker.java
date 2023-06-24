package com.github.patu11.backend.notification;

import com.github.patu11.backend.exception.EmptyDateException;
import com.github.patu11.backend.model.common.Type;
import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import com.github.patu11.backend.model.show.Episode;
import com.github.patu11.backend.service.ScrapingPropertiesService;
import com.github.patu11.backend.service.ShowService;
import com.github.patu11.backend.utils.ShowUtils;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationChecker {
    private final EmailService emailService;
    private final ScrapingPropertiesService scrapingPropertiesService;
    private final ShowService showService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void task() {
        scrapingPropertiesService.getAllPropertiesByType(Type.SHOW.getName()).forEach(this::notifyAboutPremiere);
    }

    private void notifyAboutPremiere(ScrapingPropertyDto scrapingPropertyDto) {
        try {
            Episode nextEpisode = showService.getNextEpisode(scrapingPropertyDto.name());

            if (shouldSendEmail(nextEpisode)) {
                String title = showService.getTitle(scrapingPropertyDto.name());
                emailService.sendEmail(nextEpisode, title);
                System.out.println("Email sent.");
            }
        } catch (Exception exception) {
            System.out.printf("%s %s%n", LocalDateTime.now(), exception.getMessage());
        }
    }

    private boolean shouldSendEmail(Episode episode) {
        String premiere = episode.premiere();
        LocalDate now = LocalDate.now();

        try {
            return now.isEqual(ShowUtils.parseDate(premiere));
        } catch (EmptyDateException e) {
            return false;
        }
    }
}
