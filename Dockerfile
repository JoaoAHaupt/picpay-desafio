FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/myapp.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
