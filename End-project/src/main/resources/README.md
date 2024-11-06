# Poll System Backend
Welcome to the Poll System Backend project! This project is built using Java and Spring Boot, following a microservices architecture.

## table of content
- [Introduction](#introduction)
- [Features](#Features)
- [Technologies](#Technologies)
- [Usage](#Usage)
- [User Service](#User-Service)
- [Question Service](#Question-Service)
- [Poll Service](#Poll-Service)
- [Explanation of the requests](#Explanation-of-the-requests)
- 

## Introduction 
The Poll System Backend provides the backend functionality for a polling system. It includes two microservices: User Service and Poll Service. The system supports full CRUD operations, response analysis, and adheres to best practices, including MVC architecture and API endpoint communication between services.

## Features
- User management (create, read, update, delete)
- Poll management (create, read, update, delete)
- Response analysis
- Microservices architecture
- H2 database for development

## Technologies
- Java
- Spring Boot
- H2 Database
- Maven

## Usage
After starting the application, you can access the following endpoints:

### User Service
- `POST /users`: Create a new user
- `PUT /users`: Update a user by email
- `GET /users/id/{id}`: Retrieve a user by ID
- `GET /users/email/{email}`: Retrieve a user by email
- `DELETE /users/id/{id}`: Delete a user by ID
- `DELETE /users/email/{email}`: Delete a user by email

### Question Service
- `POST /questions`: Create a new question
- `PUT /questions`: Update a question by title
- `GET /questions/id/{id}`: Retrieve a question by ID
- `GET /questions/title/{title}`: Retrieve a question by title
- `GET /questions/all`: Retrieve all questions
- `DELETE /questions/id/{id}`: Delete a question by ID
- `DELETE /questions/title/{title}`: Delete a question by title

### Poll Service
- `POST /polls`: Send a new answer
- `GET /polls/answersCount/questionId/{questionId}`: Retrieve how much users chose on each answer on question by question ID
- `GET /polls/answersSum/questionId/{questionId}`: Retrieve how much users answer on question by question ID
- `GET /polls/userAnswers/userId/{userId}`: Retrieve all questions that the user has answered by user ID
- `GET /polls/answersSum/userId/{userId}`: Retrieve how much questions user answer by user ID
- `GET /polls/all`: Retrieve all the questions, and for each question, how many users choose on each answer

## Explanation of the requests

### References:
- [User Service requests](#User-Service-requests)
- [Question Service requests](#Question-Service-requests)
- [Poll Service requests](#Poll-Service-requests)

### User Service requests
- `POST /users`: Create a new user
  #### Explanation:
          Provide a user details according the fields on "request body" explanation. 
  #### Request body:
      {
        "first_name": "String",
        "last_name": "String",
        "email": "String (must be unique)",
        "age": int,
        "address": "String"
      }
  #### Response:
      {
        "id": int,
        "first_name": "String",
        "last_name": "String",
        "email": "String",
        "age": int,
        "address": "String",
        "joining_date": LocalDate.now()
      }

- `PUT /users`: Update a user by email
  #### Explanation:
        Provide an "email" field, plus any other field you'd like to update with the value you choose. You can send one field or several together 
  #### Request body:
        {
          "first_name": "String (Optional)",
          "last_name": "String (Optional)",
          "email": "String (Required)",
          "age": int (Optional),
          "address": "String (Optional)"
        }
  #### Response:
        {
          "id": int,
          "first_name": "String",
          "last_name": "String",
          "email": "String",
          "age": int,
          "address": "String",
          "joining_date": LocalDate.now()
        }

- `GET /users/id/{id}`: Retrieve a user by ID
  #### Explanation:
      Provide the user id and get the user back
  #### Response:
        {
          "id": int,
          "first_name": "String",
          "last_name": "String",
          "email": "String",
          "age": int,
          "address": "String",
          "joining_date": LocalDate.now()
        }

- `GET /users/email/{email}`: Retrieve a user by email
  #### Explanation:
      Provide the user email and get the user back
  #### Response:
        {
          "id": int,
          "first_name": "String",
          "last_name": "String",
          "email": "String",
          "age": int,
          "address": "String",
          "joining_date": LocalDate.now()
        }


