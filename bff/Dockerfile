# ------------------------------- 1. Buld JAR file
FROM maven:latest as builder
WORKDIR /app/backend-builder

ARG MAVEN_OPTS

COPY ./fs-bff-parent .
RUN mvn package

# ------------------------------- 2. Copy JAR from builder and Run application
FROM openjdk:latest
WORKDIR /app/backend

ENV jarFile fs-bff-web-exec.jar

COPY --from=builder /app/backend-builder/fs-bff-web/target/${jarFile} /app/backend/${jarFile}

ENV RUNTIME_PROFILE=$RUNTIME_PROFILE
ENTRYPOINT java -jar -Dspring.profiles.active=${RUNTIME_PROFILE} /app/backend/${jarFile}
