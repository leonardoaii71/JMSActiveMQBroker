FROM openjdk:8

ADD build/libs/demo-0.0.1-SNAPSHOT.jar JMSActiveMQ-0.0.1-SNAPSHOT.jar

ENTRYPOINT java -jar JMSActiveMQ-0.0.1-SNAPSHOT.jar