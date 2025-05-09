FROM maven:3.9.4 as builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app

EXPOSE 8080
COPY --from=builder /app/target/hackaton-starter-template-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]