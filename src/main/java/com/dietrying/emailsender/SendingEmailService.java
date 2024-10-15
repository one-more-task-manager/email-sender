package com.dietrying.emailsender;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SendingEmailService {
    private final JavaMailSender mailSender;

    public void sendEmail(Message message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(message.getEmail());
        mailMessage.setFrom("danyatheworst@gmail.com");
        mailMessage.setSubject(message.getTitle());
        mailMessage.setText(message.getBody());

        this.mailSender.send(mailMessage);
    }
}