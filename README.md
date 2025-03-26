# library-management-system

## 📖 Overview
This is a Spring Boot microservices-based RESTful API for managing organizations (public, private, non-profit), users (admin, librarian, member), authors, books, genres, and more. The application provides endpoints to register organizations and users, as well as create, retrieve, update, and delete records while ensuring proper validation and exception handling.

## 🚀 Features
- Register **Organizations**, **Users (Admin, Librarian, Member)**
- Manage **Users**, **Books**, **Authors**, and **Genres**
- Search and filter books using **criteria-based queries**
- **Pagination** support for large datasets
- **Exception handling** with `@RestControllerAdvice`
- **Validation** of incoming data to maintain consistency

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring JDBC (JDBCTemplate)**
- **PostgreSQL** (or any compatible database)
- **Flyway** (for database migrations)
- **Lombok** (for reducing boilerplate code)
- **Maven** (for dependency management)
- **Docker** (Containers for databases and API servers)

## 📂 Project Structure
```
📦 library-management-system
```

## 🔧 Setup and Installation
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/PercivalGebashe/library-management-system.git
cd library-management-system
```
### 2️⃣ Configure the Database
Edit `application.yml` in the configuration files on the config server with your database credentials:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: your_username
    password: your_password
  flyway:
    enabled: true
```
If the database does not exist, create it manually by running:
```sql
CREATE DATABASE <your_database>;
```
Then update the connection URL:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/<your_database>
```
### 3️⃣ Build and Run
```bash
mvn clean install
mvn spring-boot:run
```
