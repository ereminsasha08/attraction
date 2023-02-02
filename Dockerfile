FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} attraction.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/attraction.jar"]
