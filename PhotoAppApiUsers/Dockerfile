FROM openjdk:11
ENV EUREKA_URI=http://eurekadiscoveryservice:8761/eureka
ADD target/PhotoAppApiUsers-0.0.1-SNAPSHOT.jar users-ws.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","users-ws.jar"]