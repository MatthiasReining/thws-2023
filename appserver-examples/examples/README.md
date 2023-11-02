# Setup

## Create project via maven

    mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="jakartaee10-minimal" -DarchetypeGroupId="org.eclipse.starter" -DarchetypeVersion="1.1.0" -DgroupId="de.thws" -DartifactId="examples"

Alternative: use the IDE tools to create a new project via a _maven_ archetype.

# Servlets

## Example

Example URL: `http://localhost:8080/examples/example1?page=1&offset=10`

## Status

Example URL: `http://localhost:8080/examples/status`

Hints:
https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

### Internal Server Error (Status Code 500)

Example URL: http://localhost:8080/examples/status?throw-error

## Redirect

Example URL: `http://localhost:8080/examples/redirect` --> google
Example URL: `http://localhost:8080/examples/redirect?location=https://thws.de` --> thws.de
Example URL: `http://localhost:8080/examples/redirect?location=/examples/api/hello`

## Server-Side Include

Example URL: `http://localhost:8080/examples/ssi`

## POST

Example URL: `http://localhost:8080/examples/post?key1=value1&key2=value2`

Example URL: `http://localhost:8080/examples/index.html`

## Thread Safe Servlets

A NON thread safe servlet

Example URL: `http://localhost:8080/examples/tss

# WebFilter

-> PerformanceFilter
-> EdgeBlockerFilter

