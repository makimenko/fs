![CI build status](https://github.com/makimenko/fs/workflows/CI/badge.svg)

# Full Stack Template

## Services
| Service |Description 
|--|--|
| db | Database layer (SQL and NoSQL)
| db-admin | Web-based MongoDB admin utility
| bff | Back-end for front-end 
| spa | Web-server with single page application 

## Technology Stack
- DB
    - [MongoDB](https://www.mongodb.com)
    - [mongo-express](https://github.com/mongo-express/mongo-express)
- BFF
    - [Java](https://java.com/)
    - [Spring](https://spring.io/), including [Spring Boot](https://spring.io/projects/spring-boot)
    - [Swagger](https://swagger.io/)
    - [Hibernate](https://hibernate.org/)
- SPA
  - [Angular](https://angular.io)
  - [Material Design](https://material.angular.io)
- Infrastructure
    - [GitHub Actions](https://github.com/features/actions)
    - [Docker](https://www.docker.com), including [Docker Compose](https://docs.docker.com/compose/)
    - [nginx](https://www.nginx.com)
    - [Azure](http://azure.microsoft.com/) for hosting dockerized app



# Build

```
docker-compose build
```
