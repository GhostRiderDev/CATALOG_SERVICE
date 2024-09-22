# 🛍️ Catalog Service - E-commerce Microservice

Welcome to the Catalog Service, a microservice that provides the catalog of products for the e-commerce platform.

## 📚 Table of Contents

- [🛍️ Catalog Service - E-commerce Microservice](#-catalog-service---e-commerce-microservice)
  - [📚 Table of Contents](#-table-of-contents)
  - [🚀 Getting Started](#-getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [🏃‍♂️ Running the Service](#️-running-the-service)
  - [🧪 Running the Tests](#-running-the-tests)
  - [📝 Documentation](#-documentation)
  - [👨‍💻 Authors](#-authors)
  - [📄 License](#-license)

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Vault Server](https://www.vaultproject.io/downloads)
- [AWS S3 Bucket](https://aws.amazon.com/s3/)

### 🚀 Features

- [x] CRUD operations for products, categories, categories, and brands
- [x] Upload product images to AWS S3
- [x] Retrieve product images from AWS S3
- [x] Secure sensitive data using Vault
- [x] API documentation using Swagger

### Installation

1. Clone the repository:

```bash
git clone
```

2. Install the dependencies:

```bash
mvn clean install
```

## 🏃‍♂️ Running the Service

To run the service, execute the following command:

```bash
mvn spring-boot:run
```

## 🧪 Running the Tests

To run the tests, execute the following command:

```bash
mvn test
```

## 📝 Documentation

The API documentation is available at [/swagger.html].

## 👨‍💻 Authors

- [Olvadis Hernandez[GhostRiderDev]](https://github.com/GhostRiderDev)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

