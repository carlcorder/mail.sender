package com.mail.sender.domain;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class Email {

    @NonNull
    private String to;

    @NonNull
    //@Value("{spring.mail.username}") --> this is always null
    private String from;

    @NonNull
    private String subject;

    private String body;

}
