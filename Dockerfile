# Use a minimal base image with Java 17 JDK
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container 
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Run Maven to download dependencies (for faster builds)
RUN ./mvnw dependency:go-offline

# Copy the project source code
COPY src src

# Build the application using Maven
RUN ./mvnw package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Set the startup command to run your jar file 
CMD ["java", "-jar", "target/urlshortener-0.0.1-SNAPSHOT.jar"]
