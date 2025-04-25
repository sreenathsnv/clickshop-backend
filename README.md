ClickShop - E-commerce Backend
Overview
This project is the backend for an e-commerce platform, built using a microservices architecture with Spring Boot. It consists of multiple microservices that handle different aspects of the e-commerce system, such as authentication, cart management, order management, product management, and service discovery using Eureka. The services communicate with a MySQL database and are containerized using Docker.
Project Structure

ServiceRegistry: Eureka server for service discovery.
AuthManagerMicroservice: Handles user authentication and authorization.
CartManagement: Manages shopping cart functionality.
OrderManagement: Processes and manages orders.
ProductMicroservice: Manages product inventory and details.
docker-compose.yml: Defines the Docker services, including MySQL and the microservices.
run.bat: A Windows batch script to build and run the services.

Prerequisites

Java 17 or later
Maven (or mvnd for faster builds, as used in run.bat)
Docker and Docker Compose (for containerized deployment)
MySQL (if running locally without Docker)

Setup Instructions
1. Clone the Repository
git clone <repository-url>
cd <repository-folder>

2. Build the Projects
Use the run.bat script to build all microservices:
run.bat build

This will clean and package all projects using mvnd, skipping tests for faster builds.
3. Run with Docker
To run all services in Docker:
run.bat docker

This will:

Build the projects.
Start the MySQL database and all microservices using docker-compose.

4. Stop Docker Services
To stop the running Docker services:
run.bat stop-docker

Services and Ports

ServiceRegistry: http://localhost:8761 (Eureka dashboard)
AuthManagerMicroservice: http://localhost:8183
CartManagement: http://localhost:8184
OrderManagement: http://localhost:8188
ProductMicroservice: http://localhost:8185
MySQL: localhost:3307 (mapped to container port 3306)

Database Configuration

Database Name: appdb
Username: appuser
Password: appuserpassword
Root Password: rootpassword

The MySQL data is persisted using a Docker volume (mysql-data).
Frontend Repository
The frontend for this project can be found at: [Frontend Repository URL Placeholder]
Notes

Ensure Docker and Docker Compose are installed if you plan to use the docker or stop-docker commands.
The SPRING_PROFILES_ACTIVE=docker environment variable is set in the docker-compose.yml to configure the services for Docker.
Health checks are configured for MySQL and the ServiceRegistry to ensure proper startup order.

Admin Credentials (For Demonstration)
An admin account is available for demonstration purposes. If the admin user is not created automatically, you can manually create it using the following steps:
Manual Admin Creation
Use Postman or cURL to send a POST request to the registration endpoint:

Endpoint: http://localhost:8183/api/auth/register
Method: POST
Body (JSON):{
  "username": "admin",
  "email": "admin@email.com",
  "password": "admin@123secure",
  "role": "ADMIN"
}



Using cURL:
curl -X POST http://localhost:8183/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"admin","email":"admin@email.com","password":"admin@123secure","role":"ADMIN"}'

After successful registration, you can use the following credentials to log in:

Username: admin
Password: admin@123secure

