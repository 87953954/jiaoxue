# Teaching Management System

## Description

This is a teaching management system that allows teachers, students, and administrators to manage courses, attendances, evaluations, payments, and teaching materials.

## Technologies Used

*   Spring Boot
*   Spring Data JPA
*   MySQL
*   Spring Security

## How to Run

1.  **Install Java JDK 17:** Make sure you have Java JDK 17 installed on your system.
2.  **Install MySQL Server:** Install a MySQL server and ensure it is running.
3.  **Create a Database:** Create a database named `teaching` in your MySQL server.
4.  **Run the Project:**
    *   Navigate to the project's root directory in your terminal.
    *   Execute the following command: `mvn spring-boot:run`
5.  **Access the Application:** Once the application starts successfully, you can access it in your browser at `http://localhost:8080`.

## Endpoints

All available API endpoints are listed in the Swagger page, which can be accessed at `http://localhost:8080/swagger-ui/index.html`.

## Security

*   Basic authentication is enabled for the application.
*   The `/api/users/register` and `/api/users/login` endpoints are open to all users without authentication.
*   All other endpoints require authentication.