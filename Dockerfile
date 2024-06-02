# Use an official JDK runtime as a parent image
FROM openjdk:17-slim



# Copy the packaged jar file into the container
ADD target/cinemaManagement-0.0.1-SNAPSHOT.jar cinemamanagement2.jar

# Expose the port the application runs on
EXPOSE 8000


# Run the application
ENTRYPOINT ["java", "-jar", "/cinemamanagement2.jar"]
