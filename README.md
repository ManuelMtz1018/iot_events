# IoT Events Project

Este proyecto es una API REST desarrollada con Spring Boot para gestionar eventos de dispositivos IoT.

## Características

- Gestión de eventos (CRUD completo).
- Soporte para múltiples perfiles (dev, prod).
- Persistencia con JPA (H2 para desarrollo, MySQL para producción).
- Uso de Lombok para reducir código repetitivo.

## Tecnologías

- Java 17
- Spring Boot 4.1.0
- Spring Data JPA
- Lombok
- Base de datos H2 (In-memory) / MySQL

## Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api-iot/events/add` | Crea un nuevo evento IoT |
| GET | `/api-iot/events/all` | Lista todos los eventos |
| GET | `/api-iot/events/{id}` | Obtiene un evento por su ID |
| GET | `/api-iot/events/latest` | Obtiene el último evento registrado |
| PUT | `/api-iot/events/{id}` | Actualiza un evento existente |
| DELETE | `/api-iot/events/{id}` | Elimina un evento |

### Ejemplo de JSON para Evento

```json
{
  "device": "raspberry-zero",
  "pin": "red",
  "action": "ON",
  "timestamp": "2026-06-10T16:30:00"
}
```

## Configuración de Perfiles

El proyecto utiliza perfiles de Spring para manejar diferentes entornos:

- **dev**: Utiliza una base de datos H2 en memoria y el puerto 8081.
- **prod**: Configurado para usar MySQL.

Para cambiar el perfil activo, modifica `src/main/resources/application.properties`:

```properties
spring.profiles.active=dev
```

## Ejecución

Para compilar el proyecto:

```bash
./gradlew build
```

Para ejecutar la aplicación:

```bash
./gradlew bootRun
```
