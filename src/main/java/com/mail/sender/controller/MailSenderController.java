package com.mail.sender.controller;

import com.mail.sender.domain.Email;
import com.mail.sender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MailSenderController {

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String emailForm(Model model) {
        model.addAttribute("email", new Email());
        return "email";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String emailSubmit(@ModelAttribute @Valid Email email, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "email";
        }
        mailSenderService.send(email);
        model.addAttribute("email", email);
        return "results";
    }

}
