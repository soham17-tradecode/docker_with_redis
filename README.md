# 🚀 Docker - Spring Boot + Redis + MySQL + Docker

A beginner-friendly backend project built using **Spring Boot**, demonstrating:

* REST APIs
* MySQL database integration
* Redis caching
* Docker & Docker Compose
* Spring Data JPA

This project is useful for learning how modern backend systems use caching and containers for performance and scalability.

---

# 📌 Features

✅ CRUD-style REST APIs
✅ MySQL database connectivity
✅ Redis cache integration
✅ Dockerized Spring Boot application
✅ Docker Compose setup
✅ Simple project structure for beginners

---

# 🛠️ Tech Stack

| Technology      | Purpose               |
| --------------- | --------------------- |
| Java            | Programming Language  |
| Spring Boot     | Backend Framework     |
| Spring Data JPA | Database ORM          |
| MySQL           | Relational Database   |
| Redis           | In-memory Cache       |
| Docker          | Containerization      |
| Docker Compose  | Multi-container setup |

---

# 📂 Project Structure

```bash
src/main/java/com/example/dickkrt
│
├── config
│   └── redisConfig.java
│
├── controller
│   ├── helloController.java
│   ├── redisController.java
│   └── stuController.java
│
├── model
│   ├── Model.java
│   └── redisData.java
│
├── repo
│   └── stuRepo.java
│
├── service
│   └── redisService.java
│
└── DickkrtApplication.java
```

---

# ⚙️ Application Configuration

```properties
spring.datasource.url=jdbc:mysql://mysql:3306/stu
spring.datasource.username=soham
spring.datasource.password=123

spring.data.redis.host=redis
spring.data.redis.port=6379
```

---

# 🐳 Docker Setup

## Dockerfile

```dockerfile
FROM eclipse-temurin:17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

---

## Docker Compose

```yaml
version: '3'

services:

  springboot:
    build: .
    ports:
      - "8081:8081"

    depends_on:
      - mysql
      - redis

  mysql:
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: stu
      MYSQL_USER: soham
      MYSQL_PASSWORD: 123

  redis:
    image: redis
```

---

# ▶️ How To Run

## 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/dickkrt.git
```

---

## 2️⃣ Build Project

```bash
mvn clean install
```

---

## 3️⃣ Run Using Docker Compose

```bash
docker-compose up --build
```

---

# 📡 API Endpoints

---

## 🏠 Home API

### GET /

```http
http://localhost:8081/
```

Response:

```text
hello
```

---

## 💾 Save Student

### POST /save

```http
http://localhost:8081/save
```

### Request Body

```json
{
  "username":"Soham",
  "marks":"90"
}
```

---

## 📋 Get All Students

### GET /gets

```http
http://localhost:8081/gets
```

---

## ⚡ Redis Cache API

### GET /get/{id}

Example:

```http
http://localhost:8081/get/1
```

---

# 🧠 Redis Cache Flow

```text
Client Request
      ↓
Check Redis Cache
      ↓
Cache Hit? ---- YES ---> Return Data
      ↓ NO
Fetch From MySQL
      ↓
Store In Redis
      ↓
Return Response
```

---

# 🧩 Redis Caching Logic

```java
Object cached = template.opsForValue().get(key);

if (cached != null)
{
    return (Model) cached;
}

Model model = stuRepo.findById(id).orElse(null);

if (model != null)
{
    template.opsForValue().set(key, model);
}
```

---

# 🗄️ Database Table

## Table Name

```text
st
```

## Columns

| Column   | Type    |
| -------- | ------- |
| id       | Integer |
| username | String  |
| marks    | String  |

---

# 📚 What You Will Learn

* Spring Boot REST APIs
* Redis caching concepts
* Docker containerization
* Docker Compose networking
* MySQL integration
* Backend architecture basics

---

# 🚀 Future Improvements

* JWT Authentication
* Spring Security
* File Upload System
* Redis TTL Expiry
* Kubernetes Deployment
* Microservices Architecture
* API Gateway

---

# 👨‍💻 Author

Soham Basak

---

# ⭐ License

This project is created for learning and educational purposes.
