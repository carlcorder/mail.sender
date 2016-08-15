package com.mail.sender.service;

import com.mail.sender.dao.EmailRepository;
import com.mail.sender.domain.Email;
import com.mail.sender.enums.EmailStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Service
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MailSenderService {

    @Value("${spring.mail.username}")
    private String userName;

    @Autowired
    private EmailRepository emailRepository;

    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(Email email) throws MessagingException {
        email.setFromAddress(userName);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(email.getToAddress());
        messageHelper.setSubject(email.getSubject());
        messageHelper.setText(email.getBody());

        javaMailSender.send(message);
        email.setStatus(EmailStatus.SUCCESS);
    }

    public void saveEmail(Email email) {
        email.setSentTimeStamp(LocalDateTime.now().toString());
        emailRepository.save(email);
    }

}
