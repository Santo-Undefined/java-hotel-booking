FROM gradle:jdk25 AS builder

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew dependencies --no-daemon || true
COPY src ./src
RUN ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:25-jre
COPY --from=builder /home/gradle/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]