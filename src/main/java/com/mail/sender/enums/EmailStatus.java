package com.mail.sender.enums;

public enum EmailStatus {
    SUCCESS("Message successfully sent!"),
    FAILURE("Message failed to send!");

    public String message;

    EmailStatus(String message) {
        this.message = message;
    }

}
