FROM amazoncorretto:11-alpine-jdk
COPY target/crud-0.0.1.jar crud-app.jar
ENTRYPOINT ["java","-jar","/crud-app.jar"]

