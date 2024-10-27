# Airport Data Explorer

## Overview
A Java-based REST API service for exploring global airport and runway data. Features country-based airport queries, runway analysis, and comprehensive aviation infrastructure reports.

## Features

### Query API
- Search airports and runways by country name or code
- Supports partial/fuzzy matching for country names
  - Example: Input "Zimb" returns results for "Zimbabwe"

### Analytics API
Generates the following reports:
1. Top 10 countries by airport count
2. Countries with lowest airport counts
3. Runway surface types by country
4. Top 10 most common runway identifications

## Tech Stack
- Backend: Java (SpringBoot)
- Database: PostgreSQL
- Infrastructure: Docker

## Getting Started

### Prerequisites
- Docker and Docker Compose
- Java development environment

### Database Setup
Start the PostgreSQL instance:
```bash
docker-compose up
```

### Connection Details
```
JDBC URL: jdbc:postgresql://localhost:5432/airport
Username: postgres
Password: postgres
```
