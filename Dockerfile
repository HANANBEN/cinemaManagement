# Use an official JDK runtime as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY ./target/cinemaManagement-0.0.1-SNAPSHOT.jar /app/cinemaManagement2.jar

# Expose the port the application runs on
EXPOSE 1111

# Run the application
ENTRYPOINT ["java", "-jar", "/app/cinemaManagement2.jar"]
