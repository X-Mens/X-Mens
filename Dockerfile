FROM openjdk:11-slim

COPY target/xmens-0.0.1-SNAPSHOT.jar xmens.jar

ENTRYPOINT ["java", "-jar", "/xmens.jar"]