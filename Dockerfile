# Start with a base image containing Maven and Java runtime for building the application
FROM maven:3.8.5-openjdk-17-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven pom.xml file and source code into the image
COPY shop/pom.xml .
COPY shop/src ./src

# Build the application using Maven and skip the tests for faster builds
RUN mvn clean package -DskipTests

# Use OpenJDK 17 for the runtime image
FROM openjdk:17-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application uses
EXPOSE 8082

# Command to run the application
CMD ["java", "-jar", "app.jar"]
