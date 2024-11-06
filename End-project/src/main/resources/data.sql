CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    age INT NOT NULL,
    address VARCHAR NOT NULL,
    joining_date DATE DEFAULT CURRENT_DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE questions (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR NOT NULL UNIQUE,
    first_answer VARCHAR NOT NULL,
    second_answer VARCHAR NOT NULL,
    third_answer VARCHAR NOT NULL,
    fourth_answer VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users_answers (
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    answer VARCHAR NOT NULL,
    PRIMARY KEY (user_id, question_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
);