FROM mongo:latest
WORKDIR /app/db

EXPOSE 27017

COPY ./data/*.js /docker-entrypoint-initdb.d/
