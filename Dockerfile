FROM openjdk:21
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/libraryV2-0.0.1-SNAPSHOT.jar libraryv2.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar libraryv2.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar libraryv2.jar
