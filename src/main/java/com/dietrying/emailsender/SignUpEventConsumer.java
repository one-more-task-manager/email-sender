package com.dietrying.emailsender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SignUpEventConsumer {
    private final SendingEmailService emailService;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "sign-up", groupId = "email-service-group")
    public void consumeSignUpEvent(String message) throws JsonProcessingException {
        SignUpEvent event = this.mapper.readValue(message, SignUpEvent.class);
        this.emailService.sendEmail(new EmailMessageDto(event.getEmail(), event.getTitle(), event.getBody()));
    }
}