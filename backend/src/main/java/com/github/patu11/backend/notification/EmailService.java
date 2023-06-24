package com.github.patu11.backend.notification;

import com.github.patu11.backend.model.show.Episode;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final SimpleMailMessage message;

    public void sendEmail(Episode episode, String title) {
        message.setSubject(createSubject(title));
        message.setText(createBody(episode));
        mailSender.send(message);
        System.out.println("Email sent");
    }

    private String createSubject(String title) {
        return String.format("%s new episode today", title);
    }

    private String createBody(Episode episode) {
        return "New episode: " + episode.title() + "\n" +
                "Premiere date: " + episode.premiere();
    }
}
