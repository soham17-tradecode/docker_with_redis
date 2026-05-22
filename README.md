# Docker - (Baisc)Spring Boot + MySQL + Redis + Docker Project

````markdown
# 🚀 Dickkrt - Spring Boot Redis Demo Project

A beginner-friendly Spring Boot project demonstrating:

- REST APIs
- MySQL Integration
- Redis Caching
- Docker & Docker Compose
- Spring Data JPA

---

# 📌 Features

✅ Save student data into MySQL  
✅ Fetch student data using REST API  
✅ Redis cache integration  
✅ Dockerized application  
✅ Simple Spring Boot architecture  
✅ Beginner-friendly project structure

---

# 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Redis
- Docker
- Docker Compose

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
````

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

# ▶️ Running the Project

## 1️⃣ Clone Repository

```bash
git clone <your-github-repo-link>
```

---

## 2️⃣ Build Project

```bash
mvn clean install
```

---

## 3️⃣ Run with Docker Compose

```bash
docker-compose up --build
```

---

# 📡 API Endpoints

---

## Home API

### GET /

```bash
http://localhost:8081/
```

Response:

```text
hello
```

---

## Save Student

### POST /save

```bash
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

## Get All Students

### GET /gets

```bash
http://localhost:8081/gets
```

---

## Get Student Using Redis Cache

### GET /get/{id}

Example:

```bash
http://localhost:8081/get/1
```

### Redis Flow

1. API checks Redis cache
2. If data exists → return from Redis
3. Else fetch from MySQL
4. Save into Redis
5. Return response

---

# 🧠 Redis Caching Logic

```java
Object cached = template.opsForValue().get(key);

if (cached!=null)
{
    return (Model) cached;
}

Model model = stuRepo.findById(id).orElse(null);

if (model!=null)
{
    template.opsForValue().set(key,model);
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

# 📷 Example Workflow

```text
POST /save  → Data stored in MySQL

GET /get/1
    ↓
Check Redis
    ↓
If absent → Fetch MySQL
    ↓
Store in Redis
    ↓
Return Data
```

---

# 🎯 Learning Outcomes

This project helps beginners understand:

* Spring Boot REST APIs
* Dockerizing Java applications
* Redis caching concepts
* MySQL integration
* Docker Compose networking
* Backend project structure

---

# 👨‍💻 Author

Soham Basak

---

# ⭐ Future Improvements

* JWT Authentication
* File Upload System
* Spring Security
* Redis TTL Expiry
* Kubernetes Deployment
* API Gateway
* Microservices Architecture

---

# 📜 License

This project is for learning purposes.

```

Project uses:
- Spring Boot application setup :contentReference[oaicite:0]{index=0}
- Redis configuration :contentReference[oaicite:1]{index=1}
- Redis caching service :contentReference[oaicite:2]{index=2}
- Student APIs :contentReference[oaicite:3]{index=3}
- MySQL & Redis properties :contentReference[oaicite:4]{index=4}
```
