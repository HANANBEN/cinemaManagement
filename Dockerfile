# Use an official JDK runtime as a parent image
FROM openjdk:17-slim



# Copy the packaged jar file into the container
ADD target/devops-integration devops-integration.jar

# Expose the port the application runs on
EXPOSE 8000


# Run the application
ENTRYPOINT ["java", "-jar", "/devops-integration.jar"]
