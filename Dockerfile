FROM openjdk:11
ARG JAR_FILE=target/*.jar
EXPOSE 8084
COPY ${JAR_FILE} ms-role.jar
ENTRYPOINT ["java","-jar","/ms-role.jar"]
