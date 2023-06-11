package com.github.patu11.backend.notification;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.github.patu11.backend.model.common.Episode;

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
        return String.format("%s new episode tomorrow", title);
    }

    private String createBody(Episode episode) {
        return "New episode: " + episode.title() + "\n" +
                "Premiere date: " + episode.premiere();
    }
}
