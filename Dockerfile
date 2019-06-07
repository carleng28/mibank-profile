FROM openjdk:8-jre-alpine
MAINTAINER carleng28@gmail.com
ENV APP_FILE profile-service-1.0.0.jar
ENV APP_HOME /usr/apps
VOLUME /tmp
EXPOSE 8090
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]

