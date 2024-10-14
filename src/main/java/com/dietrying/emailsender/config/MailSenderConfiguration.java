package com.dietrying.emailsender.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@AllArgsConstructor
@Configuration
public class MailSenderConfiguration {

    private final Environment env;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(this.env.getRequiredProperty("spring.mail.port")));
        mailSender.setUsername(this.env.getProperty("spring.mail.username"));
        mailSender.setPassword(this.env.getProperty("spring.mail.password"));

        return mailSender;
    }
}
