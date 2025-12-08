# Stage 1: Build the app using Maven image
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -e -X -DskipTests clean package

# Stage 2: Run the jar
FROM eclipse-temurin:17-jdk
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]


