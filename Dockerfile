FROM maven:latest
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/exercise-app
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]