FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src/main ./src/main
RUN mvn clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/email-sender-0.0.1.jar /app/email-sender.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/email-sender.jar"]