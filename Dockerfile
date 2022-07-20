FROM openjdk:8-jdk-alpine

LABEL author="Fotis Vachtsiavanos"

# Create firectory in container image for app code
RUN mkdir -p /usr/src/app

# Copy app code to /usr/src/app
COPY . /usr/src/app

# Set working directory context
WORKDIR /usr/src/app

Run ./mvnw package

# RUN app?
ENTRYPOINT ["./mvnw", "spring-boot:run"]
