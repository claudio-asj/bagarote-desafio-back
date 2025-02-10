# Usando uma imagem do OpenJDK para rodar o Spring Boot
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo JAR do Spring Boot para o container
COPY target/*.jar app.jar

# Expondo a porta padrão do Spring Boot (geralmente 8080)
EXPOSE 8080

# Comando para rodar o aplicativo Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
