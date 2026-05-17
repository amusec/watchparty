# WatchParty

WatchParty is a Spring Boot based web application designed to provide a platform where users can join and interact in shared watch sessions. The project focuses on backend development, authentication, deployment automation, and scalable application architecture.

The application uses Spring Boot for backend services, MySQL for database management, and Jenkins for automated CI/CD deployment workflows.

---

# Project Overview

The main goal of the project is to build a modern backend-driven application while implementing real-world DevOps and deployment practices.

The application currently includes:

* User registration and authentication system
* MySQL database integration
* REST API architecture
* Maven-based project management
* Automated Jenkins deployment pipeline
* Linux server deployment

The project is designed to evolve further with features such as real-time communication, synchronized media streaming, and scalable cloud deployment.

---

# Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Jenkins
* Ubuntu Linux

---

# Database

The application uses MySQL as the primary database system.

Current user schema includes:

* Unique username support
* Unique email support
* Secure password storage
* Auto-generated user IDs

Hibernate and Spring Data JPA are used for ORM and database interaction.

---

# CI/CD with Jenkins

The project integrates Jenkins for automated build and deployment.

Whenever code is pushed to the repository:

* Jenkins pulls the latest source code
* Maven builds the application
* The Spring Boot JAR is generated automatically
* The application is deployed on the Linux server

This creates a continuous integration and deployment workflow for faster development and testing.

---

# Deployment

The application is deployed on an Ubuntu server environment.

Deployment includes:

* Spring Boot executable JAR deployment
* MySQL integration
* Port 80 hosting support
* Background application execution
* Linux-based process management

The project also explores production-style deployment workflows and server automation concepts.

---

# Future Plans

Planned improvements for the project include:

* Watch room creation and management
* Real-time synchronized streaming
* Live chat system
* JWT authentication
* Docker containerization
* Kubernetes deployment
* Reverse proxy setup with Nginx
* HTTPS and SSL support
* Cloud deployment on Azure or AWS

---

# Author

Vivek
