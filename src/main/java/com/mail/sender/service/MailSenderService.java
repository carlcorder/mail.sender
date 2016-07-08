package com.mail.sender.service;

import com.mail.sender.domain.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService {

    private static final Log logger = LogFactory.getLog(MailSenderService.class);
    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public Email send(Email email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        try {
            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(email.getTo());
            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getBody());
        } catch (MessagingException e) {
            logger.info("failed to send message:\n" + email.toString());
            e.printStackTrace();
            return null;
        }

        javaMailSender.send(message);
        logger.info("sending message:\n" + email.toString());
        return email;
    }

}
