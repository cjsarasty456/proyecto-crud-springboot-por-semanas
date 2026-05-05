# Semana 4: Microservicios y Notificaciones

En esta última etapa, rompemos la arquitectura monolítica aislando una responsabilidad en un nuevo servicio.

## Arquitectura Multiservicio
El repositorio ahora es un monorepo que contiene dos proyectos Spring Boot:
1. **`ecommerce-service` (Puerto 8080):** Es nuestro servicio original con Arquitectura Hexagonal.
2. **`notification-service` (Puerto 8081):** Un nuevo microservicio dedicado puramente a enviar notificaciones.

## Sistema de Notificaciones
Cuando un cliente se registra exitosamente en `ecommerce-service`, este hace una llamada HTTP sincrónica mediante `RestTemplate` al `notification-service`.

El `notification-service` expone una API para enviar:
* **Correo Electrónico:** Vía `spring-boot-starter-mail` (SMTP).
* **Telegram:** Vía API oficial de Telegram enviando mensajes de chat a un Bot.

## Configuración y Ejecución
1. Levanta la base de datos:
   ```bash
   docker-compose up -d
   ```
2. **(Opcional)** Rellena tus credenciales en `notification-service/src/main/resources/application.properties` si deseas que los mensajes se envíen de verdad.
3. Inicia `ecommerce-service` (Puerto 8080).
4. Inicia `notification-service` (Puerto 8081).
