FROM openjdk:11
# Author Details: Vipin Kumar
LABEL MAINTAINER="kumar_vipin1983@yahoo.co.in"
#ENV APPNAME=EurekaAppDiscoveryService
ENV EUREKA_URI=http://eurekaappdiscoveryservice:8761/eureka
#ENV DIRPATH="/home/vip/Documents/Workspace/EurekaAppDiscoveryService"
#RUN echo "Stopping container and cleaning image"
#RUN docker container rmi -f eurekaappdiscoveryservice:latest
#RUN ECHO "Working Directory : " pwd
#ADD target/*.jar ${APPNAME}.jar

ADD target/EurekaAppDiscoveryService.jar /app/App.jar
EXPOSE 8761
WORKDIR /app
ENTRYPOINT ["java","-jar","App.jar"]



#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp /EurekaAppDiscoveryService/target/EurekaAppDiscoveryService.jar
#RUN javac Main.java
#CMD ["java", "Main"]