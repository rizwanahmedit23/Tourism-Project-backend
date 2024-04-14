FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Travel_Buddy-0.0.1-SNAPSHOT.jar Travel_Buddy.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","demo.jar" ]