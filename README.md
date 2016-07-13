# Mail Sender
A small Spring Boot application for sending emails from a gmail account via a json post.

### Requirements
* Java 8
* Gradle 2.1+
* A valid Gmail account __spring.mail.username__ with an application password __spring.mail.password__
  * Application passwords can be created by visiting `https://security.google.com/settings/security/apppasswords`

### Running
* From the root directory run
    `./gradlew bootRun`

* Using Postman, post json to

    `http://localhost:8080/send`

    ```json
    {
        "to": "destination",
        "subject": "Mail Sender test",
        "body": "Hello, world!"
    }
    ```
* Integration tests with
    `./gradlew test`