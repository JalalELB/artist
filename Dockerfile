FROM openjdk:8-jdk-oracle
LABEL maintainer="contact@jalalelb.com"
VOLUME /main-app
ADD target/artist*.jar /artist.jar
CMD ["java", "-jar", "/artist.jar", "--spring.profiles.active=prod"]
EXPOSE 8080