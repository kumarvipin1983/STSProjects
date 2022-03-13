FROM openjdk:11
ADD target/EurekaAppDiscoveryService.jar EurekaAppDiscoveryService.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","EurekaAppDiscoveryService.jar"]
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp /EurekaAppDiscoveryService/target/EurekaAppDiscoveryService.jar
#RUN javac Main.java
#CMD ["java", "Main"]