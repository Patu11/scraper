package com.github.patu11.backend.notification;

import com.github.patu11.backend.model.show.Episode;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final MimeMessage mimeMessage;

    public void sendEmail(Episode episode, String title, String showId) {
        try {
            mimeMessage.setSubject(createSubject(title));
            mimeMessage.setContent(createBody(episode, showId), "text/html");
        } catch (MessagingException e) {
            System.out.println("Error when sending email: " + e.getMessage());
        }
        mailSender.send(mimeMessage);
        System.out.println("Email sent.");
    }

    private String createSubject(String title) {
        return String.format("%s new episode today", title);
    }

    private String createBody(Episode episode, String showId) {
        String mailTemplate = """
                <html lang="en">
                    <body>
                        <h2>New episode title: <strong>%s</strong></h2>
                        <h2>Premiere date: <strong>%s</strong></h2>
                        <h2>Link: <strong><a href="https://www.imdb.com/title/%s">imdb</a></strong></h2>
                    </body>
                </html>
                """;
        return String.format(mailTemplate, episode.title(), episode.premiere(), showId);
    }
}
