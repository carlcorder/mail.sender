package com.mail.sender.domain;

import com.mail.sender.validation.address.ValidEmailAddress;
import com.mail.sender.validation.subject.ValidEmailSubject;

@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.NoArgsConstructor
public class Email {

    @ValidEmailAddress
    private String to;

    private String from;

    @ValidEmailSubject
    private String subject;

    private String body;

}
