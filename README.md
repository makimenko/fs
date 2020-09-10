![CI build status](https://github.com/makimenko/fs/workflows/build/badge.svg)

# Full Stack Template

## Services
| Service |Description 
|--|--|
| db | Database
| db-admin | DB admin utility
| bff | Back-end for front-end 
| spa | Web-server with single page application 

## Technology Stack
- DB
    - [MongoDB](https://www.mongodb.com)
    - [mongo-express](https://github.com/mongo-express/mongo-express)
- BFF
    - [Java](https://java.com/)
    - [Spring](https://spring.io/), including [Spring Boot](https://spring.io/projects/spring-boot), [Spring Data](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html)
    - [Swagger](https://swagger.io/)
- SPA
  - [Angular](https://angular.io)
  - [Material Design](https://material.angular.io)
- Infrastructure
    - CI/CD by [GitHub Actions](https://github.com/features/actions)
    - [Docker](https://www.docker.com), including [Docker Compose](https://docs.docker.com/compose/)
    - [nginx](https://www.nginx.com)

# Local Build

```
docker-compose build
```


# Run

If you don't want to build local images, then you can download it from [GitHub Container Registry](https://github.com/makimenko/fs/packages) and run it:
```
docker-compose pull
docker-compose up spa
```
then open http://localhost:8080


