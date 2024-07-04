# CRUD_using_Mysql

It is a Spring Boot application for managing student details.

## Features

- Create, read, update, and delete student details.
- Integration with MySQL database.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK)
- MySQL database
- Maven

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Hima0X2/CRUD_using_mysql.git
    ```
    
2. **Create table in MySQL database:**
   CREATE TABLE studentinfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255)
);

3. **Configure MySQL:**
    - Update the `application.properties` file in `src/main/resources` directory with your database connection details:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3307/yourdatabasename?serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.thymeleaf.prefix=classpath:/templates/
    spring.thymeleaf.suffix=.html
    spring.thymeleaf.cache=false
    spring.devtools.restart.enabled=false
    ```
    
4. **Run the application:**

   Navigate to the project directory and run the following command:

    ```bash
    mvn spring-boot:run
    ```

5. **Access the application:**

   Open your web browser and go to http://192.168.159.1:8080/students to access the application.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please create an issue or submit a pull request.
