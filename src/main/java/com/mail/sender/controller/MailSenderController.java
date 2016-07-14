package com.mail.sender.controller;

import com.mail.sender.domain.Email;
import com.mail.sender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class MailSenderController {

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMessage(@RequestBody @Valid Email email, BindingResult bindingResult) {
        if(!bindingResult.hasErrors() && mailSenderService.send(email) != null) {
            return "success";
        }
        return bindingResult.getAllErrors()
                .stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }

}
