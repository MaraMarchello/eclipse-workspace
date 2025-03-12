# Sistema de Gestión de Universidad

## 📄 Descripción - Ejercicio

Este proyecto implementa un sistema de gestión de base de datos para una universidad. El sistema permite administrar información sobre departamentos, profesores, alumnos, asignaturas, grados y cursos escolares. La base de datos está diseñada para almacenar y gestionar eficientemente las relaciones entre estas entidades, permitiendo realizar consultas complejas sobre la información académica.

## 💻 Tecnologías utilizadas

- Java
- MySQL
- JDBC (Java Database Connectivity)
- Maven
- Eclipse IDE

## 📋 REQUISITOS

- JDK 8 o superior
- MySQL 5.7 o superior
- Maven 3.6 o superior
- Conector MySQL para Java

## 🛠️ Instalación

1. Clonar el repositorio:
   ```bash
   git clone [URL_del_repositorio]
   ```

2. Importar el proyecto en Eclipse:
   - Abrir Eclipse
   - File > Import > Existing Maven Project
   - Seleccionar la carpeta del proyecto

3. Configurar la base de datos:
   - Crear una base de datos MySQL
   - Ejecutar el script de creación de tablas (disponible en `queries_MYSQL.txt`)
   - Configurar los parámetros de conexión en el archivo de configuración

## ▶️ Implementación

1. Compilar el proyecto:
   ```bash
   mvn clean install
   ```

2. Ejecutar la aplicación desde Eclipse:
   - Hacer clic derecho en el archivo principal
   - Run As > Java Application

3. Alternativamente, ejecutar desde línea de comandos:
   ```bash
   java -jar target/[nombre_del_archivo].jar
   ```

## 🌐 DESPLIEGUE

Para desplegar este proyecto en un entorno de producción:

1. Configurar un servidor MySQL en el entorno de producción
2. Ajustar los parámetros de conexión para el entorno de producción
3. Generar el archivo JAR ejecutable:
   ```bash
   mvn package
   ```
4. Transferir el archivo JAR al servidor
5. Ejecutar la aplicación en el servidor:
   ```bash
   java -jar [nombre_del_archivo].jar
   ```

## 🤝 Contribución

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio
2. Crea una nueva rama para tu funcionalidad:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz commit:
   ```bash
   git commit -m "Añadir nueva funcionalidad"
   ```
4. Envía tus cambios a tu fork:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Crea un Pull Request desde tu fork al repositorio original
