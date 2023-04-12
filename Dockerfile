FROM eclipse-temurin:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/free-assignment-0.0.1-SNAPSHOT.jar free-assignment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/free-assignment-0.0.1-SNAPSHOT.jar"]