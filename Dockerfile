FROM maven:3.8.4-openjdk-11-slim as BUILD_MAVEN

ARG COMPILE_PROFILE

WORKDIR /var/www/app

COPY . .

RUN  mkdir -p ./lib && mkdir -p build
RUN mkdir -p  build &&  mvn clean install && cp ./**/target/*.war build/ && ls build

FROM payara/micro:5.2021.9-jdk11

USER root

RUN ln -fs /usr/share/zoneinfo/America/Guatemala /etc/localtime
VOLUME /etc/localtime:/etc/localtime:ro

USER payara

COPY --chown=payara:payara --from=BUILD_MAVEN  /var/www/app/build ${PAYARA_HOME}/deployments
COPY --chown=payara:payara --from=BUILD_MAVEN  /var/www/app/lib ${PAYARA_HOME}/lib
COPY --chown=payara:payara --from=BUILD_MAVEN  /var/www/app/domain.xml ${PAYARA_HOME}

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "payara-micro.jar"]

CMD ["--deploymentDir", "/opt/payara/deployments" , "--domainconfig","/opt/payara/domain.xml" , "--addlibs", "/opt/payara/lib"]
