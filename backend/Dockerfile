# ------------------------------- 1. Buld JAR file
FROM maven:latest as builder
WORKDIR /app/bff-builder

ARG MAVEN_OPTS


# This step is separate. For optimization (dependencies are rarely changed. Docker step will be pre-cached)
COPY fs-bff-web ./pom.xml
RUN mvn dependency:resolve

COPY ./src ./src
RUN mvn package

# ------------------------------- 2. Copy JAR from builder and Run application
FROM openjdk:latest
WORKDIR /app/bff

ENV jarFile bff-0.0.1-SNAPSHOT.jar

COPY --from=builder /app/bff-builder/target/${jarFile} /app/bff/${jarFile}

ENTRYPOINT java -jar -Dspring.profiles.active=prod /app/bff/${jarFile}
