# Mail Sender
A small Spring Boot application for sending emails from a gmail account via a json post.

### Requirements
* Java 8
* Gradle 2.1+

### Running
* From the root directory run
    `./gradlew bootRun`

* Using Postman, post json to

    `http://localhost:8080/send`

    ```
    {
        "to": "destination",
        "subject": "Mail Sender test",
        "body": "Hello, world!"
    }
    ```