package com.mail.sender.domain;

import com.mail.sender.enums.EmailStatus;
import com.mail.sender.validation.address.ValidEmailAddress;
import com.mail.sender.validation.subject.ValidEmailSubject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ValidEmailAddress
    private String toAddress;

    private String fromAddress;

    @ValidEmailSubject
    private String subject;

    private String body;

    private String sentTimeStamp;

    @Transient
    private EmailStatus status;

}
