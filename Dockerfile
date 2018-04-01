FROM openjdk:8-jdk-alpine
COPY ./target/cbr-parser-1.0-SNAPSHOT.jar /usr
WORKDIR usr/
CMD ["java", "-jar", "cbr-parser-1.0-SNAPSHOT.jar"]

