package com.dietrying.emailsender;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SendingEmailService {

    private final JavaMailSender mailSender;

    public void sendWelcomeEmail(SignUpEvent signupEvent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("danyatheworst@gmail.com");
        message.setFrom("danyatheworst@gmail.com");
        message.setSubject("Welcome to Our Platform");
        message.setText("Hello " + signupEvent.getUsername() + ",\n\nThank you for signing up!");

        this.mailSender.send(message);
    }
}