# Aplicación de Productos

Esta es una aplicación de gestión de productos desarrollada en Java utilizando el framework Spring y una base de datos en memoria. La aplicación proporciona endpoints para crear, actualizar, consultar y eliminar productos, y está lista para ejecutar y recibir peticiones desde Postman u otras herramientas similares.

## Tecnologías usadas

- Java 17.
- Spring Framework 3.0.6.
- H2 Database.

## Configuración y ejecución

Sigue los pasos a continuación para configurar y ejecutar la aplicación:

1. Clona el repositorio de la aplicación desde GitHub: `git clone https://github.com/German-Furfori/challenge.git`.

2. Abre el proyecto en tu entorno de desarrollo preferido.

3. Asegúrate de tener instalada una versión compatible de Java (Java 17 o superior).

4. Compila y ejecuta la aplicación.

5. La aplicación ahora está lista para recibir peticiones a través de los siguientes endpoints:

## Endpoints

| Método | Ruta                        | Descripción                                                                                                                                                   |
|--------|-----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | `/api/products`             | Consulta todos los productos ordenados por precio.                                                                                                            |
| GET    | `/api/products/{id}`        | Consulta un producto por su ID. Se requiere especificar el `id` del producto en la ruta.                                                                      |
| GET    | `/api/products/name/{name}` | Consulta un producto por su nombre. Se requiere especificar el `nombre` del producto en la ruta.                                                              |
| POST   | `/api/create`               | Crea un nuevo producto. Se requiere enviar los campos `nombre`, `descripcion`, `precio` y `cantidad` en el cuerpo de la solicitud.                            |
| PUT    | `/api/product/{id}`         | Actualiza un producto existente. Se requiere especificar el `id` del producto a actualizar en la ruta y enviar todos los campos en el cuerpo de la solicitud. |
| DELETE | `/api/product/{id}`         | Elimina un producto existente. Se requiere especificar el `id` del producto a eliminar en la ruta.                                                            |
