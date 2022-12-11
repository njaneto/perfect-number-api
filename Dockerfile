FROM --platform=linux/amd64 maven:3.8-jdk-11 as builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM --platform=linux/amd64 openjdk:11

COPY --from=builder /app/target/perfect-number-api-*.jar /perfect-number-api.jar

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/perfect-number-api.jar"]
