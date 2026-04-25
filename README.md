# 🚀 Lead Capture Email Automation API

A backend system built with Spring Boot to capture user leads from a landing page and automatically send confirmation emails.

---

## 📌 Overview

This project simulates a real-world **Lead Generation System** used in landing pages.

Users can submit their data (name, email, phone, address), which is:
- Stored in the database
- Validated to prevent duplicates
- Followed by an automatic confirmation email

It is designed to mimic how businesses collect and manage potential customers from ads or landing pages.

---

## ✨ Features

- 📥 Capture user leads (name, email, phone, address)
- 🚫 Prevent duplicate registrations (email & phone)
- 📧 Send confirmation email after registration
- 🔍 Search leads by:
  - Email
  - Name
  - Address
  - Name + Email
- 📄 Pagination & sorting support
- ⚠️ Global exception handling
- ✅ Request validation (including custom phone validator)
- 🔄 DTO & Entity separation using MapStruct
- 📚 API documentation with Swagger

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- Spring Mail (JavaMailSender)
- Spring Validation
- Springdoc OpenAPI (Swagger)

---
## 📂 API Endpoints

### ➕ Create Lead
```http
POST /api/v1/leads
```

### 🔍 Search Leads
```http
GET /api/v1/leads/search-email?email=value
GET /api/v1/leads/search-name?name=value
GET /api/v1/leads/search-name-email?name=value&email=value
GET /api/v1/leads/search-address?address=value
```

### 📄 Get All Leads (Pagination)
```http
GET /api/v1/leads?pageNumber=0&pageSize=5&sortBy=createdAt&sortType=ASC
```

---

## ⚙️ Configuration

### 📧 Email Setup (Gmail)

This project uses **App Password** (not your real Gmail password).

#### Steps:
1. Enable 2-Step Verification on your Google account  
2. Generate an App Password  
3. Add it to your environment variables  

```properties
spring.mail.username=${MY_GMAIL}
spring.mail.password=${MY_GMAIL_PASSWORD}
```

### 🗄️ Database Configuration (PostgreSQL)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5161/lead_capture_email
spring.datasource.username=postgres
spring.datasource.password=${LOCAL_PASSWORD}
```

---

## ▶️ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/your-username/lead-capture-email-automation-API.git
cd lead-capture-email-automation-API
```

### 2. Set environment variables
```env
MY_GMAIL=your_email@gmail.com
MY_GMAIL_PASSWORD=your_app_password
LOCAL_PASSWORD=your_db_password
```

### 3. Run the application

Using Maven:
```bash
mvn spring-boot:run
```

Or run the main class from your IDE.

### 4. Access Swagger UI
```
http://localhost:8080/swagger-ui.html
```

---

## 📊 Use Case

This system can be used in:

- Marketing landing pages  
- Product subscriptions  
- Lead generation campaigns  
- Email list building systems  

---

## 🔚 Conclusion

This project demonstrates how to build a real backend system that:

- Handles user input safely  
- Integrates with external services (Email)  
- Follows clean architecture practices  

---

## 📬 Feedback

Feel free to share feedback or suggestions! 🚀
