FROM openjdk:8-jre-alpine

ADD ./target/app.jar /app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
