# Quiz Backend Project

## Project Description
This is a quiz backend project developed using Spring Boot Framework. It allows for the creation, retrieval, and management of quiz questions and quizes. The project uses MySQL for data storage and is tested using Postman. The project is developed using IntelliJ IDEA.

## Features
- **Add Question**: Add a new question to the database.
- **Get All Questions**: Retrieve all questions from the database.
- **Get Questions by Category**: Retrieve questions based on their category.
- **Create Quiz**: Create a quiz with a specific number of random questions from a category.
- **Get Quiz Questions**: Retrieve all questions of a specific quiz.
- **Calculate Quiz Result**: Calculate the result of a quiz based on user responses.
- **Delete Question**: Delete a question from the database.
- **Edit Question**: Edit an existing question.

## Technologies Used
- **Java**
- **Spring Boot Framework**
- **MySQL**
- **Postman** (for API testing)
- **IntelliJ IDEA** (for development)

## Installation Instructions
1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd quiz-backend-project
    ```
2. **Set Up Database**:
    - Ensure MySQL is installed and running.
    - Create a new database for the project.
    - Update the database configuration in the `application.properties` file.

3. **Build the Project**:
    ```bash
    ./mvnw clean install
    ```

4. **Run the Project**:
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage Instructions
1. **Add a Question**:
    - **Endpoint**: `POST /questions`
    - **Body**:
      ```json
      {
          "questionTitle": "What is Java?",
          "option1": "Programming Language",
          "option2": "OS",
          "option3": "Browser",
          "option4": "IDE",
          "rightAnswer": "Programming Language",
          "category": "Programming"
      }
      ```

2. **Get All Questions**:
    - **Endpoint**: `GET /questions`
    
3. **Get Questions by Category**:
    - **Endpoint**: `GET /questions/category/{category}`

4. **Create a Quiz**:
    - **Endpoint**: `POST /quizzes`
    - **Body**:
      ```json
      {
          "category": "Programming",
          "num": 5,
          "title": "Java Basics"
      }
      ```

5. **Get Quiz Questions**:
    - **Endpoint**: `GET /quizzes/{id}`

6. **Calculate Quiz Result**:
    - **Endpoint**: `POST /quizzes/{id}/result`
    - **Body**:
      ```json
      [
          {
              "questionId": 1,
              "response": "Programming Language"
          },
          ...
      ]
      ```

7. **Delete a Question**:
    - **Endpoint**: `DELETE /questions/{id}`

8. **Edit a Question**:
    - **Endpoint**: `PUT /questions`
    - **Body**:
      ```json
      {
          "id": 1,
          "questionTitle": "What is Java?",
          "option1": "Programming Language",
          "option2": "OS",
          "option3": "Browser",
          "option4": "IDE",
          "rightAnswer": "Programming Language",
          "category": "Programming"
      }
      ```

## Contributors
- [Ereny Mamdouh]

## License
This project is licensed under the MIT License.

## Contact Information
For any questions or support, please contact [erenymamdouh222@gmail.com].

## Acknowledgements
- Thanks to the Spring community for their comprehensive documentation and support.
- Thanks to MySQL for providing a robust database solution.
- Thanks to the developers of IntelliJ IDEA for a great development environment.
