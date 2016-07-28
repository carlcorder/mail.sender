package com.mail.sender.service;

import com.mail.sender.dao.EmailRepository;
import com.mail.sender.domain.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class MailSenderService {

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private EmailRepository emailRepository;

    private static final Log logger = LogFactory.getLog(MailSenderService.class);
    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(Email email) {
        email.setFromAddress(userName);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        try {
            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(email.getToAddress());
            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getBody());
        } catch (MessagingException e) {
            logger.info("failed to send message: " + email.toString());
            e.printStackTrace();
        }
        javaMailSender.send(message);
        logger.info("sending message: " + email.toString());
        saveEmail(email);
    }

    private void saveEmail(Email email) {
        email.setSentTimeStamp(LocalDateTime.now().toString());
        emailRepository.save(email);
    }

}
