# orders-api

Mini proyecto backend para portfolio: API REST con Spring Boot, PostgreSQL (Docker), JPA y Swagger/OpenAPI.  
Incluye tests básicos automatizados.

Backend mini portfolio project: REST API with Spring Boot, PostgreSQL (Docker), JPA and Swagger/OpenAPI.  
Includes basic automated tests.

---

## 🇪🇸 Español

### 🚀 Qué es
API REST desarrollada con **Spring Boot 4**, persistencia con **JPA/Hibernate** y base de datos **PostgreSQL** levantada con Docker.

### 🧰 Tecnologías
- Java 17
- Spring Boot 4
- Spring Web (REST)
- Spring Data JPA
- PostgreSQL 16 (Docker)
- Swagger UI (springdoc)
- Maven
- JUnit 5 + Spring Boot Test

### ▶️ Cómo arrancar

#### 1) Levantar PostgreSQL con Docker
```bash
docker compose up -d
```

#### 2) Arrancar la aplicación
**Windows**
```powershell
.\mvnw.cmd spring-boot:run
```

**Mac/Linux**
```bash
./mvnw spring-boot:run
```

### 📚 Swagger UI
http://localhost:8081/swagger-ui.html

### 📦 Endpoints principales
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`

Ejemplo body:
```json
{
  "name": "Keyboard",
  "description": "Mechanical keyboard",
  "price": 99.90,
  "stock": 10
}
```

### 🧪 Ejecutar tests
**Windows**
```powershell
.\mvnw.cmd -U clean test
```

**Mac/Linux**
```bash
./mvnw -U clean test
```

---

## 🇬🇧 English

### 🚀 About
REST API built with **Spring Boot 4**, persistence using **JPA/Hibernate**, and **PostgreSQL** running via Docker.

### 🧰 Tech stack
- Java 17
- Spring Boot 4
- Spring Web (REST)
- Spring Data JPA
- PostgreSQL 16 (Docker)
- Swagger UI (springdoc)
- Maven
- JUnit 5 + Spring Boot Test

### ▶️ How to run

#### 1) Start PostgreSQL with Docker
```bash
docker compose up -d
```

#### 2) Run the application
**Windows**
```powershell
.\mvnw.cmd spring-boot:run
```

**Mac/Linux**
```bash
./mvnw spring-boot:run
```

### 📚 Swagger UI
http://localhost:8081/swagger-ui.html

### 📦 Main endpoints
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`

Example body:
```json
{
  "name": "Keyboard",
  "description": "Mechanical keyboard",
  "price": 99.90,
  "stock": 10
}
```

### 🧪 Run tests
**Windows**
```powershell
.\mvnw.cmd -U clean test
```

**Mac/Linux**
```bash
./mvnw -U clean test
```

---

## 📌 Notes / Notas
This is a mini portfolio project intended for backend Java interviews.
