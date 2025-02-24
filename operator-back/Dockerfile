FROM openjdk:17

COPY ./build/libs/operator-back-0.0.1-SNAPSHOT.jar ./server.jar

ENTRYPOINT ["java", "-jar", "server.jar"]