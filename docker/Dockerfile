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
    && ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
    && apt-get -y update \
    && apt-get install -y cron \
    && rm -rf /var/lib/apt/lists/* \
    && chmod +x ./cers.sh \
    && crontab /tmp/crontab \
    && rm /tmp/crontab \
    && mkdir -p /var/log/cers

CMD ["cron", "-f"]