# STAGE 1: BUILDER
FROM maven:3.9.6-eclipse-temurin-17-focal AS builder
WORKDIR /usr/src/app

# Copia solo il pom.xml e scarica le dipendenze
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copia il resto del codice
COPY src ./src

# Compila il progetto
RUN mvn package -Dquarkus.package.type=uber-jar -DskipTests

# STAGE 2: RUNNER
FROM eclipse-temurin:18-jre-focal
WORKDIR /deployments
EXPOSE 8080

COPY --from=builder /usr/src/app/target/*-runner.jar /deployments/application.jar

ENTRYPOINT [ "java", "-jar", "/deployments/application.jar" ]
