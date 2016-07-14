package com.mail.sender.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class Email {

    @NotNull
    @Pattern(regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}", message = "not a valid email address")
    private String to;

    private String from;

    @NotNull
    @Size(min = 1, message = "subject is empty")
    private String subject;

    private String body;

}
