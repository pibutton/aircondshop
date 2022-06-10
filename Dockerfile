FROM openjdk:17-jdk-alpine3.14

COPY "./web/target/aircondshop.jar" "/application/aircondshop.jar"

CMD ["java", "-jar", "/application/aircondshop.jar"]
