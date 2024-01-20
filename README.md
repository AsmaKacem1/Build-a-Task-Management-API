# Task Management Application

A RESTful API for managing tasks. Users should be able to perform CRUD (Create, Read, Update, Delete) operations on tasks. Each task should have an id, title, description, status (e.g., incomplete, complete), and a due date.

## Prerequisites

Make sure you have the following installed on your machine:

- Java Development Kit (JDK) 8 or later
- Apache Maven
- MySQL Database

## Clone the Repository:

git clone [https://github.com/your-username/your-repository.git](https://github.com/AsmaKacem1/TaskManagementAPI.git)

## Setup Database

1. Create a MySQL database named `taskmanagement`.
2. Update the database configuration in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/taskmanagement?useSSL=false
   spring.datasource.username=<your_database_username>
   spring.datasource.password=<your_database_password>

## Build and Run

1) Open a terminal and navigate to the project directory.
2) Build the application using Maven:
**mvn clean install**

## Run the application:
**mvn spring-boot:run**

The application should be running at http://localhost:8080/tasks

## Design Decisions:
Embracing the **MVC (Model-View-Controller)** architecture for the Task Management Application was a strategic decision to streamline development. This design pattern separates concerns into three components: Model for data and logic, View for presentation, and Controller for user input. This modular approach enhances code organization, readability, and maintainability. The MVC structure allows parallel development and facilitates future modifications without disrupting the entire system, resulting in a more efficient and scalable Task Management Application.

## Application:

![Screenshot 2024-01-20 170150](https://github.com/AsmaKacem1/TaskManagementAPI/assets/73066984/420b34da-0f7b-4ef4-9904-97b4020fc3f5)

![Screenshot 2024-01-20 170229](https://github.com/AsmaKacem1/TaskManagementAPI/assets/73066984/cfcfc25b-e846-41fe-b997-7450cd07a6c1)

![Screenshot 2024-01-20 170255](https://github.com/AsmaKacem1/TaskManagementAPI/assets/73066984/673b0a08-c1f5-4ce0-b8e0-2914545d1e77)

