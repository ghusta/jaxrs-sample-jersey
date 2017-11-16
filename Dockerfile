FROM maven:3-jdk-8 AS builder
WORKDIR /usr/src/app
COPY . .
RUN mvn install -DskipTests

FROM jetty:9.4
COPY --from=builder /usr/src/app/target/*.war "$JETTY_BASE/webapps/jax-sample-jersey.war"
