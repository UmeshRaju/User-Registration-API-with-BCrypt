# 📝 User Registration System (Spring Boot + H2 + Security)

A simple yet powerful **User Registration API** built with **Spring Boot**, featuring:
- Secure password hashing with **BCrypt**
- In‑memory **H2 database** for quick testing
- RESTful endpoints for user creation and retrieval
- Configurable **Spring Security** setup

---

## 🚀 Features
- **User Registration**: Create new users with username + password
- **Password Security**: Passwords are hashed using BCrypt before storage
- **Database**: H2 in‑memory DB with console access at `/h2-console`
- **REST API**: JSON‑based endpoints for easy integration
- **Spring Security**: Configurable login and endpoint protection

---


---

## ⚙️ Tech Stack
- **Spring Boot 3.x**
- **Spring Security 6**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

---

## 🔧 Configuration
### `application.properties`
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 📡 API Endpoints

Create User

```
POST /users
Content-Type: application/json
```

Request Body
```aiignore
{
  "username": "umesh",
  "userpassword": "secret123"
}

```
Response
```aiignore
{
  "id": 1,
  "username": "umesh",
  "userpassword": "$2a$10$DowJonesIndexSaltedHashValueHere..."
}

```

Get All Users

```
GET /users
```

Response
```
[
  {
    "id": 1,
    "username": "umesh",
    "userpassword": "$2a$10$DowJonesIndexSaltedHashValueHere..."
  }
]

```

## 🛠️ Running the Project

Clone the repo:

```
git clone https://github.com/your-username/user-registration.git
cd user-registration
```

Build & run:
```
mvn spring-boot:run

```

## 🔒 Security Notes
- By default, Spring Security protects all endpoints.
- A PasswordEncoder bean is configured using BCrypt.
- For development, /users/** and /h2-console/** are permitted without authentication.
- In production, configure proper authentication and disable open access.

## 👨‍💻 Author
- Umesh — Backend Developer passionate about building secure and scalable systems.

## 🌟 Future Enhancements

- Add JWT authentication

- Role‑based access control (Admin/User)

- Integration with MySQL/PostgreSQL

- Swagger/OpenAPI documentation