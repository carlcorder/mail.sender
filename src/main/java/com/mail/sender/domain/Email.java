package com.mail.sender.domain;

import com.mail.sender.domain.validation.ValidEmail;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@ValidEmail
public class Email {

    private String to;

    private String from;

    private String subject;

    private String body;

}
