FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/service-pricehistory

COPY ${JAR_FILE} /opt/service-pricehistory/app.jar

ENTRYPOINT ["java", "-jar", "/opt/service-pricehistory/app.jar"]