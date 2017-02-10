FROM tomcat:8.0.20-jre8

EXPOSE 8080

USER root

RUN apt-get update
RUN apt-get -y install maven

ENV APP_HOME "$PWD/customercrud"

RUN mkdir -p $APP_HOME
COPY ./* $APP_HOME/
RUN mvn clean install
RUN cp $PWD/target/CustomerPortal.war /usr/local/tomcat/webapps/
