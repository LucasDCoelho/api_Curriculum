FROM openjdk:21-jdk-slim AS build

# Instalar o Maven
RUN apt-get update && apt-get install maven -y

# Copiar o projeto para o container
COPY . .

# Compilar e gerar o JAR
RUN mvn clean install -DskipTests

# Criar a imagem final
FROM openjdk:21-jdk-slim

# Expor a porta 8080
EXPOSE 8080

# Copiar o JAR para a imagem final
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar

# Executar a API Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
