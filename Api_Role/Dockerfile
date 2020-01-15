FROM openjdk:8-jdk-alpine
ADD target/Api_Role-*.jar apirole.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar", "apirole.jar"]