FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} attraction.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/attraction.jar"]
