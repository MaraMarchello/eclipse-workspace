# Sistema de Gestión de Pedidos de Comida

## 📄 Descripción - Ejercicio

Este proyecto implementa un sistema de base de datos para la gestión de pedidos de comida. El sistema permite administrar clientes, productos, categorías, tiendas, empleados, pedidos y entregas. La estructura de la base de datos está diseñada para soportar un servicio de entrega de comida con múltiples ubicaciones y tipos de productos.

## 💻 Tecnologías utilizadas

- Java
- SQL
- MySQL/MariaDB
- Eclipse IDE
- Maven

## 📋 REQUISITOS

Para ejecutar este proyecto, necesitarás:

- Java JDK 8 o superior
- MySQL 5.7 o MariaDB 10.3 o superior
- Eclipse IDE (recomendado)
- Maven 3.6 o superior

## 🛠️ Instalación

1. Clona este repositorio en tu máquina local:
   ```
   git clone <url-del-repositorio>
   ```

2. Importa el proyecto en Eclipse:
   - Abre Eclipse
   - Selecciona File > Import
   - Elige Existing Maven Projects
   - Navega hasta la carpeta donde clonaste el repositorio
   - Selecciona el proyecto y haz clic en Finish

3. Configura la base de datos:
   - Crea una base de datos en MySQL/MariaDB
   - Ejecuta el script `schema.sql` para crear las tablas
   - Ejecuta el script `data.sql` para poblar las tablas con datos de ejemplo

## ▶️ Implementación

1. Configura las propiedades de conexión a la base de datos en el archivo de configuración correspondiente.

2. Ejecuta la aplicación desde Eclipse o mediante el comando Maven:
   ```
   mvn spring-boot:run
   ```

3. Accede a la aplicación a través de la interfaz proporcionada o mediante las APIs expuestas.

## 🌐 DESPLIEGUE

Para desplegar este proyecto en un entorno de producción:

1. Compila el proyecto para generar el archivo JAR:
   ```
   mvn clean package
   ```

2. Transfiere el archivo JAR generado al servidor de producción.

3. Configura las variables de entorno necesarias para la conexión a la base de datos de producción.

4. Ejecuta la aplicación:
   ```
   java -jar nombre-del-archivo.jar
   ```

5. Configura un servidor web como proxy inverso (como Nginx o Apache) si es necesario.

## 🤝 Contribución

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`)
4. Sube los cambios a tu fork (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

Por favor, asegúrate de seguir las convenciones de código establecidas y de incluir pruebas para las nuevas funcionalidades.
