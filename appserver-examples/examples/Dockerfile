FROM quay.io/wildfly/wildfly:30.0.0.Final-jdk17

USER root
RUN yum install -y nano

USER jboss

ADD target/examples.war /opt/jboss/wildfly/standalone/deployments/