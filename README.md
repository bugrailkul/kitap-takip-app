\# 📚 Kütüphane Kitap Takip Sistemi - Spring Boot REST API



Bu proje, Spring Boot ile geliştirilmiş JWT tabanlı güvenlik içeren bir REST API örneğidir. Amaç, kullanıcıların sisteme kayıt olarak kendi kitaplarını ekleyip yönetebileceği basit bir kitap takip sistemidir.



---



\## 🧱 Teknolojiler ve Araçlar



\- Java 17+

\- Spring Boot 3.x

\- Spring Data JPA

\- Spring Security

\- JWT (JSON Web Token)

\- PostgreSQL (ya da H2 - test için)

\- Maven

\- Swagger UI (OpenAPI)



---



\## 🧾 Özellikler



\### 🔐 Authentication

\- Kullanıcı kayıt (`/api/auth/register`)

\- Kullanıcı girişi (`/api/auth/login`)

\- JWT Token üretimi ve doğrulama

\- Token ile korunan endpoint'ler



\### 📖 Kitap Yönetimi

\- Kitap ekleme (`POST /api/books`)

\- Kitap listeleme (`GET /api/books`)

\- Kitap güncelleme (`PUT /api/books/{id}`)

\- Kitap silme (`DELETE /api/books/{id}`)



> Not: Tüm kitap işlemleri sadece giriş yapmış kullanıcılar tarafından yapılabilir.



---



\## 🧪 Test Kullanıcı Bilgileri



```bash

Kullanıcı adı: testuser

Şifre: Test123!

```



Token almak için:

```bash

POST /api/auth/login

{

&nbsp; "username": "testuser",

&nbsp; "password": "Test123!"	

}

```



---







\## 📂 Proje Yapısı



```

├── controller

│   └── AuthController, BookController

├── entity

│   └── User, Book

├── repository

│   └── UserRepository, BookRepository

├── security

│   └── JWTFilter, JWTUtil, SecurityConfig

├── service

│   └── UserService, BookService

```



---



\## ✅ Swagger UI (API Testi)



Swagger dokümantasyonu sayesinde endpoint'leri test edebilirsiniz:

```

http://localhost:8080/swagger-ui/index.html

```



---



\## 🛡 Güvenlik



\- Şifreler BCrypt ile hashlenir.

\- JWT ile kimlik doğrulama sağlanır.

\- Token doğrulama için `OncePerRequestFilter` sınıfı kullanılır.



---





\## 🏁 Geliştirme Notları



\- Kitaplar sadece kitabı ekleyen kullanıcı tarafından görülebilir.

\- Kullanıcılar kendi kitaplarını düzenleyebilir/silebilir.

\- Geliştirme boyunca `Postman` veya `Swagger UI` üzerinden test yapılabilir.



---



