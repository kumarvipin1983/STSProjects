FROM openjdk:11
ADD target/spring-api-gateway.jar spring-api-gateway.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","spring-api-gateway.jar"]