# STAGE 1: COMPILAZIONE (Il BUILDER)
# Usiamo un'immagine con Java SDK e Maven/Gradle installati.
FROM maven:3.9.6-eclipse-temurin-17-focal AS builder

# Imposta la directory di lavoro all'interno del container
WORKDIR /usr/src/app

# Copy everything and build the project
COPY . .

# Esegui la compilazione Maven
# -Dquarkus.package.type=uber-jar crea il runner JAR.
# -DskipTests salta i test per velocizzare il build del container.
RUN mvn package -Dquarkus.package.type=uber-jar -DskipTests

# STAGE 2: ESECUZIONE (Il RUNNER)
# Usiamo un'immagine base MINIMALE con solo la JRE, per ridurre le dimensioni
FROM eclipse-temurin:18-jre-focal

# Imposta la directory di deploy standard
WORKDIR /deployments

# Espone la porta usata da Quarkus
EXPOSE 8080

# Copia il Runner JAR compilato dallo STAGE 1 (builder)
# NOTA: Stiamo copiando da un altro stage (builder), non dal file system locale!
COPY --from=builder /usr/src/app/target/*-runner.jar /deployments/application.jar

# Specifica il comando di avvio dell'applicazione
ENTRYPOINT [ "java", "-jar", "/deployments/application.jar" ]
