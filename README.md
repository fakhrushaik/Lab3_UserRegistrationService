# User Registration System – Lab Assignment

## Overview
This project is a simple **User Registration System** built with Spring Boot.  
It demonstrates:
- Registering new users via a `UserService`.
- Saving users to an in-memory repository (`InMemoryUserRepository`).
- Sending notifications using a `NotificationService` (`EmailNotificationService` implementation).
- Handling duplicate registrations with a custom exception.

---

## Features
- **Register new users** with `id`, `name`, `email`, and `password`.
- **Send confirmation notifications** (simulated via console output).
- **Prevent duplicate registrations** by checking existing email addresses.
- **Demonstration in `UserRegistrationApplication`**:
  - Registers two different users successfully.
  - Attempts to register a duplicate user and shows proper handling.

### ⚠️ Note: The app runs on port 9090 instead of 8080 due to a port conflict.

--- 

## Technologies Used
- Java 21
- Spring Boot 3
- Maven
- IntelliJ IDEA 2025

---
