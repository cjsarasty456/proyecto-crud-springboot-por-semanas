# Semana 3: Arquitectura Hexagonal

Llegamos a un hito importante: la refactorización arquitectónica. En esta semana cambiamos la arquitectura N-Capas por una Arquitectura Hexagonal (también conocida como Puertos y Adaptadores).

## Estructura de Paquetes
1. **`domain` (El Núcleo):** 
   Contiene las entidades puras de negocio (`Customer`, `Product`) sin anotaciones de persistencia, y los puertos (interfaces como `CustomerRepository`). **¡Esta capa no tiene dependencias de Spring!**
2. **`application`:** 
   Contiene los Casos de Uso (ej. `CustomerService`). Coordina el flujo usando el dominio.
3. **`infrastructure`:** 
   Contiene todos los detalles técnicos (Adaptadores). Aquí viven los Controladores web (REST), las entidades JPA (con `@Entity`) y las implementaciones de los repositorios de Spring Data.

## Objetivo
Entender el principio de **Inversión de Dependencias**. La base de datos y la web deben depender de nuestras reglas de negocio, y no al revés.

## Cómo ejecutar
Igual que la Semana 2: Asegúrate de tener Docker Compose arriba antes de ejecutar la app.
