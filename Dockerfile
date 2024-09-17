FROM openjdk:17
ADD build/libs/ChatApp-0.0.1-SNAPSHOT.jar ChatApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ChatApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080