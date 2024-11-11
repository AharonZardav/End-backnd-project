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

## Introduction 
The Poll System Backend provides the backend functionality for a polling system. It includes three microservices: User Service Question service and Poll Service. The system supports full CRUD operations, response analysis, and adheres to best practices, including MVC architecture and API endpoint communication between services.

## Features
- User management (create, read, update, delete)
- Question management (create, read, update, delete)
- Poll management (create, read)
- Response analysis
- Microservices architecture
- H2 database for development

## Technologies
- Java
- Spring Boot
- H2 Database
- Maven

## Usage
After starting the application, you can access the following endpoints with the path (http://localhost:8080):

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

      / null - if user alredy exist

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
        
        / null - if user doesnt exist

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
        
        / null - if user doesnt exist

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
         
        / null - if user doesnt exist

- `DELETE /users/id/{id}`: Delete a user by ID
  #### Explanation:
  Provide the user ID. The user will be deleted, and you will receive a message back that the user has been deleted
  #### Response:
        "The user with id {ID} deleted successfully" / null - if user doesnt exist

- `DELETE /users/email/{email}`: Delete a user by email
  #### Explanation:
  Provide the user email. The user will be deleted, and you will receive a message back that the user has been deleted
  #### Response:
        "The user with email {email} deleted successfully" / null - if user doesnt exist

### Question Service requests
- `POST /questions`: Create a new question
  #### Explanation:
      Provide a question details according the fields on "request body" explanation. 
  #### Request body:
        {
          "title": "String",
          "first_answer": "String",
          "second_answer": "String",
          "third_answer": "String",
          "fourth_answer": "String"
        }
  #### Response:
        {
          "id": int,
          "title": "String",
          "first_answer": "String",
          "second_answer": "String",
          "third_answer": "String",
          "fourth_answer": "String"
        }
  
        / null - if question alredy exist

- `PUT /questions`: Update a question by title
  #### Explanation:
        Provide an "title" field, plus any other field you'd like to update with the value you choose. You can send one field or several together 
  #### Request body:
          {
            "title": "String",
            "first_answer": "String",
            "second_answer": "String",
            "third_answer": "String",
            "fourth_answer": "String"
          }
  #### Response:
          {
            "id": int,
            "title": "String",
            "first_answer": "String",
            "second_answer": "String",
            "third_answer": "String",
            "fourth_answer": "String"
          }
    
          / null - if question dosent exist

- `GET /questions/id/{id}`: Retrieve a question by ID
  #### Explanation:
      Provide the question id and get the question back
  #### Response:
          {
            "id": int,
            "title": "String",
            "first_answer": "String",
            "second_answer": "String",
            "third_answer": "String",
            "fourth_answer": "String"
          }
    
          / null - if question dosent exist

- `GET /questions/title/{title}`: Retrieve a question by title
  #### Explanation:
        Provide the question title and get the question back
  #### Response:
            {
              "id": int,
              "title": "String",
              "first_answer": "String",
              "second_answer": "String",
              "third_answer": "String",
              "fourth_answer": "String"
            }
      
            / null - if question dosent exist

- `GET /questions/all`: Retrieve all questions
  #### Explanation:
        Get all the questions back as an array
  #### Response:
          [
            {
              "id": int,
              "title": "String",
              "first_answer": "String",
              "second_answer": "String",
              "third_answer": "String",
              "fourth_answer": "String"
            },
            {
              "id": int,
              "title": "String",
              "first_answer": "String",
              "second_answer": "String",
              "third_answer": "String",
              "fourth_answer": "String"
            }
          ]
      
            / [null] - if there are no existing questions

- `DELETE /questions/id/{id}`: Delete a question by ID
  #### Explanation:
  Provide the question ID. The question will be deleted, and you will receive a message back that the question has been deleted
  #### Response:
          "The question with id {ID} deleted successfully" / null - if question doesnt exist

- `DELETE /questions/title/{title}`: Delete a question by title
  #### Explanation:
  Provide the question title. The question will be deleted, and you will receive a message back that the question has been deleted
  #### Response:
            "The question with title {title} deleted successfully" / null - if question doesnt exist

### Poll Service requests
- `POST /polls`: Send a new answer
  #### Explanation:
  Provide a poll details according the fields on "request body" explanation.
  #### Request body:
          {
            "user_id": int,
            "question_id": int,
            "answer": "Char (only- a/b/c/d)"
          }
  #### Response:
          {
            "user_id": int,
            "question_id": int,
            "answer": "Char (only- a/b/c/d)"
          }
      
          / null - if the question or the user dosent exist

- `GET /polls/answersCount/questionId/{questionId}`: Retrieve how much users chose on each answer on question by question ID
  #### Explanation:
  Provide a question ID, and get back the question with the number of answers for each option
  #### Response:
         {
            "questionId": 2,
            "answers": [
                {
                  "answer": "a",
                  "count": 1
                },
                {
                  "answer": "b",
                  "count": 0
                },
                {
                  "answer": "c",
                  "count": 0
                },
                {
                  "answer": "d",
                  "count": 3
                }
            ]
         }
      
        / null - if the question dosent exist

- `GET /polls/answersSum/questionId/{questionId}`: Retrieve how much users answer on question by question ID
  #### Explanation:
  Provide a question ID, and get back the number of answers on it
  #### Response:
        (int)

- `GET /polls/userAnswers/userId/{userId}`: Retrieve all questions that the user has answered by user ID
  #### Explanation:
  Provide a user ID, and get back all the questions they answered
  #### Response:
         [
           {
             "QUESTION_ID": 1,
             "ANSWER": "a"
           },
           {
             "QUESTION_ID": 2,
             "ANSWER": "c"
           },
           {
             "QUESTION_ID": 3,
             "ANSWER": "a"
           },
           {
             "QUESTION_ID": 4,
             "ANSWER": "d"
           }
         ]
      
         / null - if the question dosent exist

- `GET /polls/answersSum/userId/{userId}`: Retrieve how much questions user answer by user ID
  #### Explanation:
  Provide a user ID, and get back the number of questions he answered
  #### Response:
        (int)
- `GET /polls/all`: Retrieve all the questions, and for each question, how many users choose on each answer
  #### Explanation:
  a
  #### Response:
         [
            {
               "questionId": 1,
               "answers": [
                   {
                     "answer": "a",
                     "count": 0
                   },
                   {
                     "answer": "b",
                     "count": 2
                   },
                   {
                     "answer": "c",
                     "count": 1
                   },
                   {
                     "answer": "d",
                     "count": 0
                   }
               ]
            },
            {
               "questionId": 2,
               "answers": [
                   {
                     "answer": "a",
                     "count": 1
                   },
                   {
                     "answer": "b",
                     "count": 0
                   },
                   {
                     "answer": "c",
                     "count": 0
                   },
                   {
                     "answer": "d",
                     "count": 3
                   }
               ]
            }
         ]
      
         / null - if there are no existing questions
