FROM openjdk:8
ADD target/docker-spring-0.0.1-SNAPSHOT.jar docker-spring-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "docker-spring-0.0.1-SNAPSHOT.jar"]