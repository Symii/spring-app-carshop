# Wykorzystanie obrazu OpenJDK jako podstawy
FROM openjdk:21-jdk-slim

# Ustaw zmienną środowiskową PORT
ENV PORT=8080

# Kopiowanie aplikacji do obrazu Dockera
COPY target/carshop-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Wskazanie portu aplikacji
EXPOSE 8080

# Polecenie uruchamiające aplikację
CMD ["java", "-Dserver.address=0.0.0.0", "-Dserver.port=8080", "-jar", "/app/myapp.jar"]
