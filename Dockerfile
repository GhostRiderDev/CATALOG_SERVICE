FROM openjdk:17-jdk-alpine

LABEL maintainer="olvadis2004@gmail.com"

VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=./target/CatalogService-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} /catalogService.jar

ENTRYPOINT ["java","-jar","/catalogService.jar"]