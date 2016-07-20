package com.mail.sender.controller;

import com.mail.sender.domain.Email;
import com.mail.sender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class MailSenderController extends WebMvcConfigurerAdapter {

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private Environment env;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/send").setViewName("send");
        registry.addViewController("/").setViewName("send");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/login").setViewName("login");
    }

    @RequestMapping(value = {"", "/", "/send"}, method = RequestMethod.GET)
    public String emailForm(Model model) {
        model.addAttribute("email", new Email());
        model.addAttribute("userName", env.getProperty("spring.mail.username"));
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

    @RequestMapping(value = "/send/test", method = RequestMethod.POST)
    public String emailTest(@Valid Email email, BindingResult bindingResult) {

        return "";
    }

}
