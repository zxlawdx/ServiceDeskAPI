# Use JDK 21 como base
FROM eclipse-temurin:21-jdk-alpine

# Defina diretório de trabalho dentro do container
WORKDIR /app

# Copie os arquivos do projeto
COPY . .

# Torne o gradlew executável
RUN chmod +x gradlew

# Build do projeto
RUN ./gradlew build -x test

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Start do aplicativo
CMD ["java", "-jar", "build/libs/servicedesk-0.0.1-SNAPSHOT.jar"]
