# Use an official OpenJDK 21 runtime image
#FROM openjdk:21-jdk-slim AS runtime
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar course-service.jar

# Expose the application port (adjust if needed)
EXPOSE 9001

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "course-service.jar"]