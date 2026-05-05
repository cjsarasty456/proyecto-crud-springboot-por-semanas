# Semana 1: Arquitectura N-Capas

En esta primera semana establecemos las bases del proyecto utilizando una **Arquitectura en N-Capas** tradicional.

## Estructura
El flujo de datos va desde la capa exterior hacia la interior de la siguiente manera:
`Controller` -> `Service` -> `Repository` -> `Entity`

* **DTOs**: Utilizamos objetos de transferencia de datos (DTOs) en los controladores para no exponer las entidades de base de datos directamente al cliente.
* **Base de Datos**: Para facilitar el aprendizaje inicial sin depender de instalaciones externas, esta versión utiliza **H2 Database** corriendo en memoria.

## Cómo ejecutar
1. Ejecuta la clase principal `ApiApplication.java` o usa Maven:
   ```bash
   mvn spring-boot:run
   ```
2. La base de datos H2 es accesible (si está activada en properties) desde `http://localhost:8080/h2-console`.
