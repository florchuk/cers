FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /tmp/cers

COPY ./pom.xml ./
COPY ./src ./src

RUN mvn dependency:go-offline \
    && mvn clean package

FROM eclipse-temurin:21-jre AS final

WORKDIR /opt/cers

COPY --from=builder /tmp/cers/target/*.jar ./

COPY ./config.properties ./
COPY ./docker/.env ./
COPY ./docker/cers.sh ./
COPY ./docker/crontab /tmp

RUN . ./.env \
    && ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone \
    && CERS_API_HOST=$(echo ${CERS_API_URL} | cut -d/ -f3) \
    && apt-get -y update \
    && apt-get install -y cron \
    && rm -rf /var/lib/apt/lists/* \
    && chmod +x ./cers.sh \
    && crontab /tmp/crontab \
    && rm /tmp/crontab \
    && mkdir -p /var/log/cers \
    && echo | openssl s_client -connect ${CERS_API_HOST}:443 -servername ${CERS_API_HOST} | openssl x509 > /tmp/server.crt \
    && keytool -importcert -noprompt -keystore ${JAVA_HOME}/lib/security/cacerts -storepass changeit -alias ${CERS_API_HOST} -file /tmp/server.crt \
    && rm /tmp/server.crt

CMD ["cron", "-f"]