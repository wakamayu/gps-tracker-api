FROM maven:3.8.4-openjdk-11-slim as BUILD_MAVEN

ARG COMPILE_PROFILE

WORKDIR /var/www/app

COPY . .

RUN  mkdir -p ./lib && mkdir -p build
RUN mkdir -p  build &&  mvn clean install && cp ./**/target/*.jar build/ && ls build

FROM openjdk:18-ea-11-jdk-alpine3.15

WORKDIR app

USER root

RUN ln -fs /usr/share/zoneinfo/America/Guatemala /etc/localtime
VOLUME /etc/localtime:/etc/localtime:ro

COPY  --from=BUILD_MAVEN  /var/www/app/build/* app/.

RUN ls -la app/*

COPY  --from=BUILD_MAVEN  /var/www/app/domain.xml app/domain.xml

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=1", "-jar", "gps-tracker-api-resource-0.0.1-microbundle.jar"]

CMD ["--domainconfig","/app/domain.xml" ]
