FROM registry.redhat.io/ubi8/openjdk-8
COPY pom.xml /opt/myapp/source/
COPY src /opt/myapp/source/src
RUN /etc/alternatives/mvn -DskipTests install -f /opt/myapp/source/pom.xml && rm -rf /root/.m2
RUN mv /opt/myapp/source/target/app.jar /opt/myapp/ && chmod 750 /opt/myapp/app.jar && chown 185:root /opt/myapp/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/myapp/app.jar"]