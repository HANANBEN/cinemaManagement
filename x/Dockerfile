FROM maven:3.9.6-openjdk-11
# FROM maven:3.8.2-jdk-8

WORKDIR /x
COPY . .
RUN mvn clean package -DskipTests

CMD mvn spring-boot:run