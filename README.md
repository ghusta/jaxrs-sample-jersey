# JAX-RS Sample : Jersey version

## Overview

Sample project for testing JAX-RS 2.0 with Jersey 2.x

## Project generation

Maven archetype used :

> mvn archetype:generate -DarchetypeGroupId=org.glassfish.jersey.archetypes -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeVersion=2.25.1 -DgroupId=fr.husta.test.jaxrs -DartifactId=jaxrs-sample-jersey -B

## Run

Run the webapp with :

> mvn jetty:run

NOTE: 
Jetty 9 needs Java 8 !

## Docker

### Build an image

> docker build -t jaxrs-sample-jersey .

### Run a container

> docker run -d --name jaxrs-test-1 -p 8090:8080 jaxrs-sample-jersey

### Test

Open a browser on http://localhost:8090/jaxrs-sample-jersey/

Or try :

> curl -X GET http://localhost:8090/jaxrs-sample-jersey/webapi/myresource
