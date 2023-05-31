FROM maven:3.8-openjdk-17 AS maven

WORKDIR /build
COPY . /build

RUN mvn package -Dmaven.test.skip
FROM openjdk:17-alpine

WORKDIR /app

COPY --from=maven /build/backend/target/*.jar backend.jar
COPY --from=maven /build/gateway/target/*.jar gateway.jar
COPY --from=maven /build/start.sh start.sh

CMD chmod 755 start.sh && ./start.sh
