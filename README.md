# Fitlife MS-reservas

Microservicio de gestión de reservas para FitLife. Este servicio maneja la creación, modificación y cancelación de reservas de clases.

## Características

- **Gestión de Reservas**: CRUD completo para reservas de clases
- **Estados de Reserva**: Pendiente, Confirmada, Cancelada, Completada
- **Integración con Usuarios**: Relación con el microservicio de usuarios
- **REST API**: Endpoints completos para gestión de reservas
- **Unit Testing**: Pruebas unitarias con JUnit y Mockito

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL 8.0
- Maven
- Docker

## Endpoints

### Gestión de Reservas
- `POST /reservas` - Crear nueva reserva
- `GET /reservas` - Obtener todas las reservas
- `GET /reservas/{id}` - Obtener reserva por ID
- `PUT /reservas/{id}` - Actualizar reserva
- `DELETE /reservas/{id}` - Eliminar reserva
- `GET /reservas/usuario/{usuarioId}` - Obtener reservas por usuario
- `POST /reservas/{id}/confirmar` - Confirmar reserva
- `POST /reservas/{id}/cancelar` - Cancelar reserva

## Configuración

### Variables de Entorno

```env
SPRING_DATASOURCE_URL=jdbc:mysql://mysql-reservas:3306/fitlife_reservas_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

## Desarrollo

### Compilar el proyecto
```bash
mvn clean package
```

### Ejecutar pruebas
```bash
mvn test
```

### Ejecutar localmente
```bash
mvn spring-boot:run
```

## Docker

### Construir imagen
```bash
docker build -t fitlife-reservas:latest .
```

### Ejecutar contenedor
```bash
docker run -p 8083:8083 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/fitlife_reservas_db \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=root \
  fitlife-reservas:latest
```

## GitHub Actions

Este repositorio utiliza GitHub Actions para CI/CD:

- **Build**: Compila el proyecto con Maven
- **Test**: Ejecuta pruebas unitarias
- **Docker Build**: Construye la imagen Docker
- **Docker Push**: Sube la imagen a Docker Hub

## Contribución

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## Licencia

Este proyecto es parte de FitLife Gym Management System.
