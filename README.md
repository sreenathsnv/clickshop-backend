# ClickShop E-commerce Backend

## Overview
This project implements the backend for an e-commerce platform using a microservices architecture built with Spring Boot. The system consists of multiple specialized microservices that handle different aspects of the e-commerce functionality, including authentication, cart management, order processing, product management, and service discovery via Eureka. The services communicate with a MySQL database and are containerized using Docker for simplified deployment.

## Project Structure

- **ServiceRegistry**: Eureka server for service discovery and registration
- **AuthManagerMicroservice**: Manages user authentication and authorization
- **CartManagement**: Handles shopping cart functionality
- **OrderManagement**: Processes and manages customer orders
- **ProductMicroservice**: Manages product inventory and details
- **docker-compose.yml**: Configures the Docker services, including MySQL and all microservices
- **run.bat**: Windows batch script to build and run the services

## Prerequisites

- Java 17 or later
- Maven (or mvnd for faster builds, as used in run.bat)
- Docker and Docker Compose (for containerized deployment)
- MySQL (if running locally without Docker)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Build the Projects
Use the provided run.bat script to build all microservices:
```bash
run.bat build
```
This command cleans and packages all projects using mvnd, skipping tests for faster builds.

### 3. Run with Docker
To run all services in Docker:
```bash
run.bat docker
```
This command:
- Builds all projects
- Starts the MySQL database and all microservices using docker-compose

### 4. Stop Docker Services
To stop the running Docker services:
```bash
run.bat stop-docker
```

## Services and Ports

| Service | URL | Description |
|---------|-----|-------------|
| ServiceRegistry | http://localhost:8761 | Eureka dashboard for service discovery |
| AuthManagerMicroservice | http://localhost:8183 | Authentication and authorization |
| CartManagement | http://localhost:8184 | Shopping cart functionality |
| OrderManagement | http://localhost:8188 | Order processing and management |
| ProductMicroservice | http://localhost:8185 | Product inventory and details |
| MySQL | localhost:3307 | Database (mapped to container port 3306) |

## Database Configuration

- **Database Name**: appdb
- **Username**: appuser
- **Password**: appuserpassword
- **Root Password**: rootpassword

MySQL data is persisted using a Docker volume (mysql-data).

## Frontend Repository
The frontend for this project can be found at: https://github.com/sreenathsnv/click-shop

## Notes

- Ensure Docker and Docker Compose are installed if you plan to use the docker or stop-docker commands.
- The SPRING_PROFILES_ACTIVE=docker environment variable is set in the docker-compose.yml to configure the services for containerized deployment.
- Health checks are configured for MySQL and the ServiceRegistry to ensure proper startup order.

## Administrator Access

### Admin Credentials
For demonstration purposes, an administrator account can be used with the following credentials:

- **Username**: admin
- **Password**: admin@123secure

### Manual Admin Creation
If the admin user is not created automatically, you can manually create it using the following steps:

#### Using Postman:
- **Endpoint**: http://localhost:8183/api/auth/register
- **Method**: POST
- **Body (JSON)**:
```json
{
  "username": "admin",
  "email": "admin@email.com",
  "password": "admin@123secure",
  "role": "ADMIN"
}
```

#### Using cURL:
```bash
curl -X POST http://localhost:8183/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"admin","email":"admin@email.com","password":"admin@123secure","role":"ADMIN"}'
```

After successful registration, you can use the credentials listed above to log in.