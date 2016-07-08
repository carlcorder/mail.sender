package com.mail.sender.controller;

import com.mail.sender.domain.Email;
import com.mail.sender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailSenderController {

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<Email> sendMessage(@RequestBody Email email) {
        if(mailSenderService.send(email) != null) {
            return new ResponseEntity<Email>(email, HttpStatus.OK);
        }
        return new ResponseEntity<Email>(email, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
