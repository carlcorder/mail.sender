package com.mail.sender;

import com.mail.sender.domain.Email;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailSenderApp.class)
@WebIntegrationTest
public class MailSenderTests {

    private Email email;

    @Value("${spring.mail.username}")
    private String userNameFrom;

    @Value("${mail.sender.test.username}")
    private String testUserTo;

    @Before
    public void setUp() {
        email = Email.builder().to(testUserTo).from(userNameFrom)
                .subject("integration test").body("mock body text").build();
    }

    @Test
    public void sendEmail() {
        given().contentType("application/json").body(email).when().post("/send/test")
                .then().statusCode(HttpStatus.OK.value());
    }

}
