FROM openjdk:17-jdk AS builder
WORKDIR /app
COPY build.gradle gradlew ./
COPY gradle gradle
COPY src src
RUN ./gradlew build --no-daemon

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
CMD ["java","-jar","app.jar"]
EXPOSE 8080