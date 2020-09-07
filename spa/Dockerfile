# ------------------------------- 1. Buld Angular (HTML+JS)
FROM node:latest AS builder
WORKDIR /app/ui-builder

# pre-cache dependencies
COPY package.json package-lock.json ./
RUN npm ci --no-color

COPY . .
RUN npx ng build --configuration="production"

# ------------------------------- 2. Copy Angular from builder and Run web-server
FROM nginx:latest
WORKDIR /app/ui

RUN rm -rf /usr/share/nginx/html/*

COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/ui-builder/dist/ui /usr/share/nginx/html

ENV BFF_URL=$BFF_URL
EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]
