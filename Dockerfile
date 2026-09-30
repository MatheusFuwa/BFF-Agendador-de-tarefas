FROM maven:3.9.16-eclipse-temurin-17 AS BUILD
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTest

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar /app/bff-agendador-tarefas.jar
EXPOSE 8083
CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]