FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 3000
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]