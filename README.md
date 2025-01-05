# Forohub
API REST de Gestión de Cursos y Tópicos
Esta es una API REST desarrollada en Java con Spring Boot, Maven y MySQL, utilizando Lombok para simplificar la escritura de código. La API está diseñada para gestionar cursos y tópicos en un sistema educativo, permitiendo la creación, lectura, actualización y eliminación (CRUD) de estos recursos, con varias validaciones para asegurar la integridad de los datos.

Características
Gestión de Tópicos: Permite la creación de tópicos, aunque actualmente no cuenta con soporte para respuestas.
Gestión de Cursos: Facilita la creación, lectura, actualización y eliminación de cursos.
Validaciones:
No permite la creación de usuarios, cursos y tópicos duplicados.
Campos obligatorios para la creación de recursos.
Validaciones de contraseñas: mínimo 7 caracteres, al menos una letra minúscula, una mayúscula y un número.
Tecnologías Utilizadas
Java: Versión 17
Spring Boot: Framework para desarrollar aplicaciones Java.
Maven: Herramienta de gestión de proyectos y dependencias.
MySQL: Sistema de gestión de bases de datos.
Lombok: Biblioteca para reducir el boilerplate en el código Java.
Requisitos Previos
Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu máquina:

Java JDK 17
Maven
MySQL
IntelliJ IDEA
Pasos para Iniciar el Proyecto
Clonar el repositorio:


git clone https://github.com/tu_usuario/nombre_del_repositorio.git
cd nombre_del_repositorio
Configurar la Base de Datos:

Crea una base de datos en MySQL para la API.
Actualiza el archivo application.properties en src/main/resources con tus credenciales de MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_base_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Construir el Proyecto:

Navega hasta la raíz del proyecto y ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias:

mvn clean install
Ejecutar la Aplicación:

Puedes ejecutar la aplicación desde tu IDE (IntelliJ) o desde la línea de comandos:

mvn spring-boot:run
Probar la API:

Una vez que la aplicación esté en funcionamiento, puedes probar la API utilizando herramientas como
Postman