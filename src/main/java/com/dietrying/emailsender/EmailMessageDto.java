package com.dietrying.emailsender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailMessageDto {
    private final String email;
    private final String title;
    private final String body;
}
