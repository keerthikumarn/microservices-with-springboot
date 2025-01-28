# Use an official OpenJDK 21 runtime image
FROM openjdk:21-jdk-slim AS runtime

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar myservice-registry.jar

# Expose the application port (adjust if needed)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "myservice-registry.jar"]
