FROM openjdk:21
ADD /cricket-elastic.jar cricket-elastic.jar
ENTRYPOINT ["java", "-jar", "/cricket-elastic.jar"]