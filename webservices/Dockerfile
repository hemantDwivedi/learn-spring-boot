FROM amazoncorretto:17

LABEL mentainer="justhemant.d@gmail.com"

WORKDIR /app

COPY target/webservices-0.0.1-SNAPSHOT.jar /app/webservices.jar

ENTRYPOINT ["java", "-jar", "webservices.jar"]