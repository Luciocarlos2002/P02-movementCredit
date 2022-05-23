FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-movementCredit.jar
ENTRYPOINT ["java","-jar","/ms-movementCredit.jar"]