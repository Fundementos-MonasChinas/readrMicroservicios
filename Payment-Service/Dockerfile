# Usar la imagen oficial de OpenJDK 20
FROM openjdk:20-jdk-slim

# Crear el directorio donde residirá la aplicación
WORKDIR /home/app

# Añadir el archivo .jar al contenedor
COPY target/payment-service.jar /home/app/payment-service.jar

# Ejecutar la aplicación
CMD ["java", "-jar", "/home/app/payment-service.jar"]

