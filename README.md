# Semana 2: Persistencia Real y Docker

En esta segunda semana avanzamos en infraestructura. Abandonamos la base de datos en memoria y conectamos la aplicación a un motor robusto de base de datos relacional.

## ¿Qué cambió?
* **PostgreSQL:** Añadimos el driver al `pom.xml` y configuramos `application.properties` para conectarnos a Postgres.
* **Docker Compose:** Hemos incluido un archivo `docker-compose.yml` en la raíz del proyecto para levantar la base de datos de manera aislada y consistente.

## Cómo ejecutar
1. Inicia la base de datos con Docker:
   ```bash
   docker-compose up -d
   ```
2. Una vez levantado el contenedor de Postgres, inicia la aplicación Spring Boot de manera normal.
