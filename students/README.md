# Application "Students"

Students management

# Setup Basic Quarkus Application

* via IDE

or

* https://quarkus.io/guides/getting-started

Have also a look to the nice Test classes


# REST Service 

https://quarkus.io/guides/rest-json#json

## Endpoints


http://localhost:8080/students/...

## Open API

just add the dependency:

http://localhost:8080/q/dev-ui/extensions

--> http://localhost:8080/q/swagger-ui/


# Cloud Deployment (Azure)

* Vorstellung verschiedener Cloud Servieces (hetzer, AWS, Azure)
* Azure Cloud Setup via Azure Portal
    https://quarkus.io/guides/deploying-to-azure-cloud#change-quarkus-http-port

    * Subscription
    * Resource Group https://learn.microsoft.com/en-us/azure/azure-resource-manager/management/manage-resource-groups-portal
    * App Instances https://learn.microsoft.com/en-us/azure/container-instances/container-instances-quickstart-portal


# JPA

see slides

* ORM -> Object Relational Mapping
* OneToMany, ManyToOne / JoinColumn
* NamedQueries

JPA Entities within the REST (JAX-RS) interface ??? --> Cycles -> JsonTransient -> but... -> DTOs


# DTOs

Why DTOs?
* better API interface,
* more specific interface

But... how to map: hand made :-( or --> mapstruct
Why is mapstruct better than Dozer? --> Dozer Reflection -> MapStruct at BuildTime


# Create Student via PostMan

`POST: http://localhost:8080/students`

```json
{
  "firstName": "Moritz",
  "lastName": "Mustermann",
  "privateEmail": "max.mustermann@gmail.com",
  "birthday": "2001-03-20",
  "degreeProgramKey": "BIN" 
}
```
# Events

see git commits


# Micro Profile

    mvn package
    docker build -f src/main/docker/Dockerfile.jvm -t quarkus/students-jvm .

    
