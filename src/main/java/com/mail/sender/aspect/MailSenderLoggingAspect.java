package com.mail.sender.aspect;

import com.mail.sender.domain.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MailSenderLoggingAspect {

    private static final Log logger = LogFactory.getLog(MailSenderLoggingAspect.class);

    @AfterReturning("execution(* com.mail.sender.service.MailSenderService.send(..))")
    public void sendAdvice(JoinPoint joinPoint) {
        Email email = (Email) joinPoint.getArgs()[0];
        logger.info("message successfully sent: " + email.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.mail.sender.service.MailSenderService.send(..))", throwing = "exception")
    public void sendExceptionAdvice(JoinPoint joinPoint, Throwable exception) {
        Email email = (Email) joinPoint.getArgs()[0];
        logger.info("failed to send message: " + email.toString());
        logger.info(exception.toString());
    }

}
