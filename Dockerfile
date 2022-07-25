FROM openjdk:8-jdk-alpine

LABEL author="Fotis Vachtsiavanos"

# Create directory in container image for app jsp
RUN mkdir -p /src/main/webapp/WEB-INF/jsp

# Copy jsp files in /src/main/webapp/WEB-INF/jsp
COPY src/main/webapp/WEB-INF/jsp /src/main/webapp/WEB-INF/jsp

# Copy pom.xml in docker
COPY pom.xml pom.xml

# Copy jar into docker image
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE app.jar

# RUN app
ENTRYPOINT ["java","-jar","/app.jar"]