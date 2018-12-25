FROM openjdk:8-alpine

COPY target/uberjar/public-radio-services.jar /public-radio-services/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/public-radio-services/app.jar"]
