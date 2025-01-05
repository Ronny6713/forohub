# Forohub
#ENGLISH
# Course and Topic Management REST API

This is a REST API developed in Java with Spring Boot, Maven, and MySQL, using Lombok to simplify code writing. The API is designed to manage courses and topics in an educational system, allowing for the creation, reading, updating, and deletion (CRUD) of these resources, with various validations to ensure data integrity.

## Features

- **Topic Management**: Allows the creation of topics, although it currently does not support responses.
- **Course Management**: Facilitates the creation, reading, updating, and deletion of courses.
- **Validations**:
  - Does not allow the creation of duplicate users, courses, and topics.
  - Mandatory fields for resource creation.
  - Password validations: minimum of 7 characters, at least one lowercase letter, one uppercase letter, and one number.

## Technologies Used

- **Java**: Version 17
- **Spring Boot**: Framework for developing Java applications.
- **Maven**: Project and dependency management tool.
- **MySQL**: Database management system.
- **Lombok**: Library to reduce boilerplate code in Java.

## Prerequisites

Before getting started, ensure you have the following programs installed on your machine:

- Java JDK 17
- MySQL
- IntelliJ IDEA

## Steps to Start the Project

1. Clone the Repository:
  
    You can download the project or clone it using the following command:
    
     
    git clone https://github.com/your_username/repository_name.git
    cd repository_name

2. **Configure the Database**:

   Create a database in MySQL for the API. Update the `application.properties` file in `src/main/resources` with your MySQL credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project**:

   Navigate to the root of the project and run the following command to compile the project and download the dependencies:

   ```bash
   mvn clean install
   ```

4. **Run the Application**:

   You can run the application from your IDE (IntelliJ) or from the command line:

   ```bash
   mvn spring-boot:run
   ```

5. **Test the API**:

   Once the application is up and running, you can test the API using tools like Postman.


##SPANISH

# API REST de Gestión de Cursos y Tópicos

Esta es una API REST desarrollada en Java con Spring Boot, Maven y MySQL, utilizando Lombok para simplificar la escritura de código. La API está diseñada para gestionar cursos y tópicos en un sistema educativo, permitiendo la creación, lectura, actualización y eliminación (CRUD) de estos recursos, con varias validaciones para asegurar la integridad de los datos.

## Características

- **Gestión de Tópicos**: Permite la creación de tópicos, aunque actualmente no cuenta con soporte para respuestas.
- **Gestión de Cursos**: Facilita la creación, lectura, actualización y eliminación de cursos.
- **Validaciones**:
  - No permite la creación de usuarios, cursos y tópicos duplicados.
  - Campos obligatorios para la creación de recursos.
  - Validaciones de contraseñas: mínimo 7 caracteres, al menos una letra minúscula, una mayúscula y un número.

## Tecnologías Utilizadas

- **Java**: Versión 17
- **Spring Boot**: Framework para desarrollar aplicaciones Java.
- **Maven**: Herramienta de gestión de proyectos y dependencias.
- **MySQL**: Sistema de gestión de bases de datos.
- **Lombok**: Biblioteca para reducir el boilerplate en el código Java.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu máquina:

- [Java JDK 17]
- [MySQL]
- [IntelliJ IDEA]

## Pasos para Iniciar el Proyecto

1. **Clonar el Repositorio:

   Puedes descargar el proyecto o clonarlo usando el siguiente comando:
   
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
   cd nombre_del_repositorio
   ```

3. **Configurar la Base de Datos**:
   - Crea una base de datos en MySQL para la API.
   - Actualiza el archivo `application.properties` en `src/main/resources` con tus credenciales de MySQL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_base_datos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     ```

4. **Construir el Proyecto**:
   - Navega hasta la raíz del proyecto y ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias:
   ```bash
   mvn clean install
   ```

5. **Ejecutar la Aplicación**:
   - Puedes ejecutar la aplicación desde tu IDE (IntelliJ) o desde la línea de comandos:
   ```bash
   mvn spring-boot:run
   ```

6. **Probar la API**:
   - Una vez que la aplicación esté en funcionamiento, puedes probar la API utilizando herramientas como [Postman](https://www.postman.com/) o [cURL](https://curl.se/).
   - Las rutas principales de la API estarán disponibles en `http://localhost:8080`.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Agregué una nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

---

Si tienes preguntas o necesitas más información, no dudes en abrir un issue en el repositorio. ¡Gracias por tu interés!
