FROM eclispe-temurin:17

LABEL authors="hemant"

LABEL mentainer="justhemant.d@gmail.com"

WORKDIR /app

COPY target/ToDo-0.0.1-SNAPSHOT.jar /app/todo.jar

ENTRYPOINT ["java", "-jar", "todo.jar"]