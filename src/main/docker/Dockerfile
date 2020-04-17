FROM openjdk:8-jdk-alpine
WORKDIR /
ADD ./target/my-site-1.0.2.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]