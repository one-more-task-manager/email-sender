package com.dietrying.emailsender;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SendingEmailService {
    private final JavaMailSender mailSender;

    public void sendEmail(EmailMessageDto emailMessageDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailMessageDto.getEmail());
        message.setFrom("danyatheworst@gmail.com");
        message.setSubject(emailMessageDto.getTitle());
        message.setText("Hello " + emailMessageDto.getEmail() + ",\n\nThank you for signing up!");

        this.mailSender.send(message);
    }
}