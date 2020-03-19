FROM openjdk:8-jre

MAINTAINER Vito

RUN mkdir -p /app
COPY ./target/shop-1.1.jar /app/shop-1.1.jar
EXPOSE 80
ENTRYPOINT java -jar /app/shop-1.1.jar