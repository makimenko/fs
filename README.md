# Docker Compose Template

| Layer |Description | Tool 
|--|--|--|
| db | Database | [MongoDB](https://www.mongodb.com)
| db-admin | Web-based MongoDB admin | [mongo-express](https://github.com/mongo-express/mongo-express)
| bff | Back-end for front-end | [Java SpringBoot](https://spring.io/projects/spring-boot)
| spa | Web-server with single page application | [Angular](https://angular.io) running on [nginx](https://www.nginx.com/) 


# Build

```
docker-compose build
```

# Run

1. Execute `docker-compose up`
2. Open in browser http://localhost:8080


