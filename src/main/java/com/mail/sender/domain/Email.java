package com.mail.sender.domain;

import lombok.NonNull;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class Email {

    @NonNull
    private String to;

    @NonNull
    private String from;

    @NonNull
    private String subject;

    private String body;

}
