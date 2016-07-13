# Mail Sender
A small Spring Boot application for sending emails from a gmail account via a json post.

### Requirements
* Java 8
* Gradle 2.1+
* A valid Gmail account _spring.mail.username_ with an application password _spring.mail.password_
..* Application passwords can be created by visiting
..*> https://security.google.com/settings/security/apppasswords

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