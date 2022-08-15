FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/service-statsanalysis

COPY ${JAR_FILE} /opt/service-statsanalysis/app.jar

ENTRYPOINT ["java", "-jar", "/opt/service-statsanalysis/app.jar"]