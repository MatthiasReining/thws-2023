# Setup

## Create project via maven

    mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="jakartaee10-minimal" -DarchetypeGroupId="org.eclipse.starter" -DarchetypeVersion="1.1.0" -DgroupId="de.thws" -DartifactId="examples"

Alternative: use the IDE tools to create a new project via a _maven_ archetype.

## Package project

    mvn clean package

In case of a running server (_WildFly_) the target _war_ file will be autodeployed.

# Servlets

## Example

Example URL: http://localhost:8080/examples/example1?page=1&offset=10

## Status

Example URL: http://localhost:8080/examples/status

Hints:
https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

### Internal Server Error (Status Code 500)

Example URL: http://localhost:8080/examples/status?throw-error

## Redirect

Example URL: http://localhost:8080/examples/redirect --> google
Example URL: http://localhost:8080/examples/redirect?location=https://thws.de --> thws.de
Example URL: http://localhost:8080/examples/redirect?location=/examples/api/hello

## Server-Side Include

Example URL: http://localhost:8080/examples/ssi

## POST

Example URL: http://localhost:8080/examples/post?key1=value1&key2=value2

Example URL: http://localhost:8080/examples/index.html

## Thread Safe Servlets

A NON thread safe servlet

Example URL: http://localhost:8080/examples/tss

# WebFilter

-> PerformanceFilter
-> EdgeBlockerFilter

# Docker Examples

In this examples the docker image id is always detected by a `docker ps`.
For _playing_ more use `docker-compose`.

## Copy our war file to the ready to use Docker image from Wildfly

    docker cp examples.war f8a3b647f21f:/opt/jboss/wildfly/standalone/deployments

## Mount a volume into the ready to use Docker image from Wildfly

Example: starting from my local used Wildfly

    C:\Users\MatthiasReining\dev\thws\2023\srv\wildfly-30.0.0.Final\standalone>docker run -p 8080:8080 -p 9990:9990 -it -v %CD%/deployments:/opt/jboss/wildfly/standalone/deployments quay.io/wildfly/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0

## Build a new image

From directory `appserver-examples/examples`  

    docker build -t thws/examples .

run

    docker run -d -p 8080:8080 thws/examples
