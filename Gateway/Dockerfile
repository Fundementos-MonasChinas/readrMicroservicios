# Usar la imagen oficial de OpenJDK 20
FROM openjdk:20-jdk-slim

# Crear el directorio donde residirá la aplicación
WORKDIR /home/app

# Añadir el archivo .jar al contenedor
COPY target/gateway.jar /home/app/gateway.jar

# Ejecutar la aplicación
CMD ["java", "-jar", "/home/app/gateway.jar"]

