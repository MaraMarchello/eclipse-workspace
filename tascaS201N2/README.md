# Video Platform Database System

## 📄 Description - Exercise

This project implements a relational database schema for a video sharing platform similar to YouTube. The database includes tables for managing users, videos, tags, playlists, channels, and various interaction features like comments, reactions, and subscriptions. It allows for a complete video platform ecosystem with social features.

The database schema supports:
- User management and authentication
- Video uploading and metadata management
- Content tagging and categorization
- Channel subscriptions
- Video and comment reactions (likes/dislikes)
- Playlist creation and management
- Video-tag relationships

## 💻 Technologies used

- SQL (MySQL/MariaDB)
- Java (JPA/Hibernate for database interaction)
- Maven (for dependency management)
- Eclipse IDE

## 📋 REQUIREMENTS

To run this project, you need:
- Java Development Kit (JDK) 8 or higher
- MySQL/MariaDB database server
- Eclipse IDE or similar Java IDE
- Maven 3.6 or higher

## 🛠️ Installation

1. Clone the repository:
   ```
   git clone [repository-url]
   ```

2. Import the project into Eclipse:
   - Open Eclipse
   - Select File > Import > Existing Maven Project
   - Navigate to the project directory and select it
   - Click Finish

3. Configure the database:
   - Create a new database in MySQL/MariaDB
   - Update the database connection properties in your application configuration

4. Initialize the database:
   - Run the database schema scripts to create the tables
   - Run the sample data scripts to populate the database with test data

## ▶️ Implementation

1. Start your MySQL/MariaDB server
2. Run the application from Eclipse or using Maven:
   ```
   mvn clean install
   mvn exec:java
   ```
3. The application will connect to the database and be ready for use

## 🌐 DEPLOYMENT

To deploy this project in a production environment:

1. Set up a production database server
2. Configure the application with production database credentials
3. Build the application:
   ```
   mvn clean package
   ```
4. Deploy the resulting JAR/WAR file to your application server
5. Run the schema scripts on your production database

## 🤝 Contribution

If you wish to contribute to this project:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

# Sistema de Base de Datos para Plataforma de Videos

## 📄 Descripción - Ejercicio

Este proyecto implementa un esquema de base de datos relacional para una plataforma de compartición de videos similar a YouTube. La base de datos incluye tablas para gestionar usuarios, videos, etiquetas, listas de reproducción, canales y varias características de interacción como comentarios, reacciones y suscripciones. Permite un ecosistema completo de plataforma de video con características sociales.

El esquema de la base de datos admite:
- Gestión y autenticación de usuarios
- Carga de videos y gestión de metadatos
- Etiquetado y categorización de contenido
- Suscripciones a canales
- Reacciones a videos y comentarios (me gusta/no me gusta)
- Creación y gestión de listas de reproducción
- Relaciones entre videos y etiquetas

## 💻 Tecnologías utilizadas

- SQL (MySQL/MariaDB)
- Java (JPA/Hibernate para interacción con la base de datos)
- Maven (para gestión de dependencias)
- Eclipse IDE

## 📋 REQUISITOS

Para ejecutar este proyecto, necesitas:
- Kit de Desarrollo de Java (JDK) 8 o superior
- Servidor de base de datos MySQL/MariaDB
- Eclipse IDE o IDE similar para Java
- Maven 3.6 o superior

## 🛠️ Instalación

1. Clonar el repositorio:
   ```
   git clone [url-del-repositorio]
   ```

2. Importar el proyecto a Eclipse:
   - Abrir Eclipse
   - Seleccionar Archivo > Importar > Proyecto Maven Existente
   - Navegar al directorio del proyecto y seleccionarlo
   - Hacer clic en Finalizar

3. Configurar la base de datos:
   - Crear una nueva base de datos en MySQL/MariaDB
   - Actualizar las propiedades de conexión a la base de datos en la configuración de la aplicación

4. Inicializar la base de datos:
   - Ejecutar los scripts de esquema de base de datos para crear las tablas
   - Ejecutar los scripts de datos de ejemplo para poblar la base de datos con datos de prueba

## ▶️ Implementación

1. Iniciar el servidor MySQL/MariaDB
2. Ejecutar la aplicación desde Eclipse o usando Maven:
   ```
   mvn clean install
   mvn exec:java
   ```
3. La aplicación se conectará a la base de datos y estará lista para su uso

## 🌐 DESPLIEGUE

Para desplegar este proyecto en un entorno de producción:

1. Configurar un servidor de base de datos de producción
2. Configurar la aplicación con credenciales de base de datos de producción
3. Construir la aplicación:
   ```
   mvn clean package
   ```
4. Desplegar el archivo JAR/WAR resultante en tu servidor de aplicaciones
5. Ejecutar los scripts de esquema en tu base de datos de producción

## 🤝 Contribución

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio
2. Crea una rama de características (`git checkout -b feature/caracteristica-asombrosa`)
3. Haz commit de tus cambios (`git commit -m 'Añadir alguna característica asombrosa'`)
4. Haz push a la rama (`git push origin feature/caracteristica-asombrosa`)
5. Abre una Solicitud de Extracción (Pull Request)
