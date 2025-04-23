# Sistema de Agenda de Contactos

## 📄 Descripción - Ejercicio

Este proyecto implementa un sistema de gestión de contactos internacionales utilizando el patrón de diseño Abstract Factory. Permite almacenar y gestionar información de contactos de diferentes países, cada uno con su propio formato de dirección y número de teléfono. Actualmente soporta contactos de Estados Unidos y Francia, siendo fácilmente extensible a otros países.

El patrón Abstract Factory proporciona una interfaz para crear familias de objetos relacionados sin especificar sus clases concretas, permitiendo que el sistema sea independiente de cómo se crean, componen y representan estos objetos.

## 💻 Tecnologías utilizadas

- Java 8+
- Patrón de diseño Abstract Factory
- Programación Orientada a Objetos
- Colecciones de Java (ArrayList, HashMap)
- Streams de Java

## 📋 REQUISITOS

- JDK 8 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, etc.)
- Conocimientos básicos de Java y patrones de diseño

## 🛠️ Instalación

1. Clonar el repositorio en su máquina local:
   ```bash
   git clone [URL del repositorio]
   ```
2. Abrir el proyecto en su IDE preferido (Eclipse recomendado)
3. Configurar el proyecto para utilizar JDK 8 o superior
4. Compilar el proyecto

## ▶️ Implementación

1. Ejecutar la clase `Main.java` ubicada en el paquete `tascaS301N2`
2. El programa mostrará ejemplos de creación y búsqueda de contactos
3. Para añadir nuevos contactos, modificar el método `main` o extender la funcionalidad de la clase `AddressBook`

Para implementar soporte para un nuevo país:
1. Crear clases concretas para dirección y número de teléfono para el nuevo país
2. Implementar una nueva fábrica que implemente la interfaz `AddressFactory`
3. Registrar la nueva fábrica en la clase `AddressBook`

## 🌐 DESPLIEGUE

Este proyecto está diseñado como una aplicación de escritorio y no requiere un despliegue en servidor. Para distribuir la aplicación:

1. Compilar el proyecto en un archivo JAR ejecutable
2. Distribuir el JAR junto con las instrucciones de instalación de Java
3. Para ejecutar: `java -jar nombre_del_archivo.jar`

## 🤝 Contribución

Si desea contribuir a este proyecto:

1. Hacer un fork del repositorio
2. Crear una rama para su característica (`git checkout -b feature/nueva-caracteristica`)
3. Hacer commit de sus cambios (`git commit -m 'Añadir nueva característica'`)
4. Hacer push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abrir un Pull Request

Por favor, asegúrese de actualizar las pruebas según corresponda y siga las convenciones de código existentes. 