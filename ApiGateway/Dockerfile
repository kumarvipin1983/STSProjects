FROM openjdk:11
ADD target/spring-cloud-api-gateway.jar spring-cloud-api-gateway.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","spring-cloud-api-gateway.jar"]
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp /EurekaAppDiscoveryService/target/EurekaAppDiscoveryService.jar
#RUN javac Main.java
#CMD ["java", "Main"]