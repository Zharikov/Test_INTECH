# Simple forum
## Description
Test task from INTECH company
## Technologies
- Java:
  - Spring Framework:
    - Spring MVC:
    - Spring Data:
    - Spring Security:
    - Spring Boot:
  - JPA & Hibernate:
  - Java 8 SE:
- HTML:
- CSS:
  - Materialize
## Software tools
- IntelliJ IDEA 
- Gradle
- XAMPP [Postgres]
## Settings project
Create database final_forum in Postgres
in file application.properties

>spring.datasource.url=jdbc:postgresql://localhost:5432/final_forum

>spring.datasource.username=postgres

>spring.datasource.password=1

```elixir
## Project structure
```elixir
│   build.gradle
│
└───src:
    ├───main:
    │   ├───java:
    │   │   └───com:
    │   │       └───intech:
    │   │           └───forum:
    │   │               │   ForumApplication.java
    │   │               │
    │   │               ├───configuration:
    │   │               │       AdditionalLoginConfiguration.java
    │   │               │       SecurityConfiguration.java
    │   │               │
    │   │               ├───controllers:
    │   │               │       AnswersController.java
    │   │               │       IndexController.java
    │   │               │       LoginController.java
    │   │               │       ProfileController.java
    │   │               │       RegisterController.java
    │   │               │       TopicController.java
    │   │               │       TopicsController.java
    │   │               │
    │   │               ├───entities:
    │   │               │       Answer.java
    │   │               │       Topic.java
    │   │               │       User.java
    │   │               │
    │   │               └───repositories:
    │   │                       AnswerRepository.java
    │   │                       TopicRepository.java
    │   │                       UserRepository.java
    │   │
    │   └───resources:
    │       │   application.properties
    │       │
    │       └───templates:
    │           │   answers.html
    │           │   error.html
    │           │   index.html
    │           │   login.html
    │           │   profile.html
    │           │   register.html
    │           │   topic.html
    │           │   topics.html
    │           │
    │           └───layout:
    │                   offline.html
    │                   online.html
    │
    └───test:
        └───java:
            └───com:
                └───intech:
                    └───forum:
                            ForumApplicationTests.java