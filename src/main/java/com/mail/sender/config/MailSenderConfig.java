package com.mail.sender.config;

import com.mail.sender.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailSenderConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    @Bean
    @ConditionalOnProperty(name="spring.mail.host")
    public MailSenderService mailSenderService() {
        MailSenderService mailSenderService = new MailSenderService();
        mailSenderService.setJavaMailSender(javaMailSender);
        return mailSenderService;
    }

}
