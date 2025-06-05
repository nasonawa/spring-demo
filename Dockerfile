FROM registry.redhat.io/ubi8/openjdk-8
COPY ./ /home/jboss/

USER jboss
RUN mvn package
RUN ls target
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/jboss/target/demo-0.0.1-SNAPSHOT.jar"]