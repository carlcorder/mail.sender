# (G)Mail Sender
A small Spring Boot application for sending emails from a Gmail account via a simple Thymeleaf ui.

![alt text](https://github.com/carlcorder/mail.sender/blob/master/src/main/resources/static/images/mail-sender-ui.png)

### Requirements
* Java 8
* Gradle 2.1+
* A valid Gmail account __spring.mail.username__ with an application password __spring.mail.password__
  * Application passwords can be created by visiting `https://security.google.com/settings/security/apppasswords`

### Running
* From the root directory run`./gradlew bootRun`, then visit `localhost:8080/send` in
  your browser

* A valid email address and subject are required when sending

* Integration tests with `./gradlew test`