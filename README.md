# EmployeeManage
# Employee Management System

## Overview
The Employee Management System is a **Spring Boot** application that provides **CRUD (Create, Read, Update, Delete)** operations for managing employees, departments, and projects. It is designed using **Spring Boot, JPA, and H2 Database** for in-memory storage.

## Features
- Manage **Employees**, **Departments**, and **Projects**.
- **RESTful APIs** for CRUD operations.
- **Spring Data JPA** for database interaction.
- **H2 Database** for in-memory persistence.
- Integrated **Spring Boot Exception Handling**.

## Technology Stack
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Java 17**
- **Maven**

## Application Flow Diagram
Below is the high-level flow of the system:

```
+---------------+       +-------------------+       +-----------------+
|               |       |                   |       |                 |
|   Employee    | <-->  | Employee Service  | <-->  | H2 Database     |
|   API Calls   |       | (Spring Boot)     |       | (In-Memory)     |
|               |       |                   |       |                 |
+---------------+       +-------------------+       +-----------------+
        |                         |
        v                         v
+----------------+        +-----------------+
| Department API |        |  Project API    |
+----------------+        +-----------------+
```

## How to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/employee-management.git
   ```
2. Navigate to the project directory:
   ```sh
   cd employee-management
   ```
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```
5. Access H2 Console:
    - URL: `http://localhost:8081/h2-console`
    - JDBC URL: `jdbc:h2:mem:LearnerSystemDB`
    - Username: `sa`
    - Password: `password`

## API Endpoints

### Employee
| Method | Endpoint | Description |
|---------|---------|-------------|
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| POST | `/employees` | Create a new employee |
| PUT | `/employees/{id}` | Update an employee |
| DELETE | `/employees/{id}` | Delete an employee |

### Department
| Method | Endpoint | Description |
|---------|---------|-------------|
| GET | `/departments` | Get all departments |
| GET | `/departments/{id}` | Get department by ID |
| POST | `/departments` | Create a new department |
| PUT | `/departments/{id}` | Update a department |
| DELETE | `/departments/{id}` | Delete a department |

### Project
| Method | Endpoint | Description |
|---------|---------|-------------|
| GET | `/projects` | Get all projects |
| GET | `/projects/{id}` | Get project by ID |
| POST | `/projects` | Create a new project |
| PUT | `/projects/{id}` | Update a project |
| DELETE | `/projects/{id}` | Delete a project |

## Future Enhancements
- Integrate Kafka for event-driven communication.
- Implement authentication and authorization using **Spring Security**.
- Use **MySQL/PostgreSQL** for persistent storage.

---

