FROM openjdk:21-jdk-slim
LABEL authors="primora"

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]




