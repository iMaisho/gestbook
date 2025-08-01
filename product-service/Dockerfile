# ----- STAGE 1: Build -----
# On utilise une image officielle Maven avec une version de Java 17
# On nomme cette étape "build" pour pouvoir s'y référer plus tard.
FROM maven:3.8.5-openjdk-17 AS build

# On définit le répertoire de travail dans l'image
WORKDIR /app

# On copie d'abord le pom.xml pour tirer parti du cache Docker.
# Si le pom.xml ne change pas, Docker n'aura pas à ré-télécharger
# les dépendances à chaque build.
COPY pom.xml .
RUN mvn dependency:go-offline

# On copie le reste du code source
COPY src ./src

# On lance la compilation et la création du .jar
# -DskipTests pour ne pas relancer les tests dans Docker
RUN mvn package -DskipTests


# ----- STAGE 2: Runtime -----
# On part d'une image légère contenant uniquement le JRE 17
FROM eclipse-temurin:17-jre-focal

# On définit le répertoire de travail
WORKDIR /app

# On copie UNIQUEMENT le .jar généré depuis l'étape "build"
COPY --from=build /app/target/*.jar app.jar

# On expose le port sur lequel notre application tourne à l'intérieur
# du conteneur. C'est le port 8081 que nous avons défini.
EXPOSE 8081

# C'est la commande qui sera exécutée au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "app.jar"]