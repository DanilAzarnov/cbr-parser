FROM maven:3-jdk-8-slim AS builder
COPY . /usr/src/cbr-parser
WORKDIR /usr/src/cbr-parser
RUN mvn clean package spring-boot:repackage -Dmaven.test.skip=true

FROM openjdk:8-jre-slim
COPY --from=builder /usr/src/cbr-parser/target/cbr-parser-spring-boot.jar /usr/bin/cbr-parser.jar
ENTRYPOINT java -jar /usr/bin/cbr-parser.jar