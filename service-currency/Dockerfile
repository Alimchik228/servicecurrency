FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/service-currency

COPY ${JAR_FILE} /opt/service-currency/app.jar

ENTRYPOINT ["java", "-jar", "/opt/service-currency/app.jar"]