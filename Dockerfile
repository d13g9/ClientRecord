FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} BrasilPrev.jar
ENTRYPOINT ["java","-jar","/BrasilPrev.jar"]