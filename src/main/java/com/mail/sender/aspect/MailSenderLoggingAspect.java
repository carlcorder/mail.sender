package com.mail.sender.aspect;

import com.mail.sender.domain.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MailSenderLoggingAspect {

    private static final Log logger = LogFactory.getLog(MailSenderLoggingAspect.class);

    @Pointcut("execution(* com.mail.sender.service.MailSenderService.send(..))")
    public void mailSend() {}

    @AfterReturning("mailSend() && args(email)")
    public void sendSuccessAdvice(Email email) {
        logger.info("message successfully sent: " + email.toString());
    }

    @AfterThrowing(pointcut = "mailSend() && args(email)", throwing = "exception")
    public void sendExceptionAdvice(Email email, Throwable exception) {
        logger.info("failed to send message: " + email.toString());
        logger.info(exception.toString());
    }

}
