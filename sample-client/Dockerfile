FROM openjdk:11.0-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.import=optional:configserver:http://config-service:8888"]
