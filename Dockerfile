#FROM java:8-jdk
FROM tomcat:8.0.20-jre8
#FROM maven:3.3.9-jdk-8

EXPOSE 8080

USER root

RUN apt-get update
#RUN apt-get -y install tomcat8 tomcat8-docs tomcat8-admin maven
RUN apt-get -y install maven

ENV APP_HOME "$PWD/customercrud"

RUN mkdir -p $APP_HOME
RUN cd $APP_HOME
COPY ./* ./
RUN mvn clean install
RUN cp $PWD/target/CustomerPortal.war /usr/local/tomcat/webapps/
