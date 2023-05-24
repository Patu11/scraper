package com.github.patu11.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.recipient}")
    private String recipient;

    @Value("${spring.mail.transport.protocol}")
    private String protocol;

    @Value("${spring.mail.smtps.ssl.enable}")
    private String sslEnable;


    @Value("${spring.mail.debug}")
    private String debug;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtps.ssl.enable", sslEnable);
        props.put("mail.debug", debug);
        return mailSender;
    }

    @Bean
    public SimpleMailMessage getMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(recipient);
        return message;
    }
}
