FROM openjdk:27-ea-trixie
ADD target/dickkrt-0.0.1-SNAPSHOT.jar dickkrt-0.0.1-SNAPSHOT.jar



ENTRYPOINT ["java", "-jar", "/dickkrt-0.0.1-SNAPSHOT.jar"]