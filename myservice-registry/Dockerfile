FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} myservice-registry.jar
ENTRYPOINT ["java","-jar","/myservice-registry.jar"]