FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/api-gateway

COPY ${JAR_FILE} /opt/api-gateway/app.jar

ENTRYPOINT ["java", "-jar", "/opt/api-gateway/app.jar"]