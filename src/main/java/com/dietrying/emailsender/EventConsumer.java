package com.dietrying.emailsender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EventConsumer {
    private final SendingEmailService emailService;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "EMAIL_SENDING_TASKS", groupId = "email-service-group")
    public void consume(String message) throws JsonProcessingException {
        this.emailService.sendEmail(this.mapper.readValue(message, Message.class));
    }
}