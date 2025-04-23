# TascaS302Ex1 - Patrón de Diseño Builder

## 📄 Descripción - Ejercicio

Este proyecto implementa el patrón de diseño Builder para la creación de pizzas. El patrón Builder permite construir objetos complejos paso a paso, separando el proceso de construcción de la representación final. En este caso, permite crear diferentes tipos de pizzas (de carne y vegetarianas) con variaciones en tamaño, masa y coberturas.

## 💻 Tecnologías utilizadas

- Java 11
- Gradle (como sistema de construcción)
- Patrón de diseño Builder

## 📋 REQUISITOS

- JDK 11 o superior
- Gradle 7.0 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, etc.)

## 🛠️ Instalación

1. Clonar este repositorio:
   ```
   git clone <url-del-repositorio>
   ```

2. Navegar al directorio del proyecto:
   ```
   cd tascaS302Ex1
   ```

3. Compilar el proyecto con Gradle:
   ```
   ./gradlew build
   ```

## ▶️ Implementación

Para ejecutar el proyecto:

```
./gradlew run
```

El programa principal demostrará la creación de diferentes tipos de pizzas utilizando el patrón Builder:
- Pizzas de carne en diferentes tamaños
- Pizzas vegetarianas en diferentes tamaños
- Pizza personalizada con ingredientes específicos

## 🌐 DESPLIEGUE

Este proyecto es principalmente educativo y está diseñado para ser ejecutado en un entorno local. No requiere despliegue en un servidor de producción.

## 🤝 Contribución

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📂 Estructura del proyecto

El proyecto sigue la estructura estándar de Gradle y utiliza el patrón de diseño Builder:

- `model/Pizza.java`: Define la clase Pizza que será construida
- `builder/PizzaBuilder.java`: Define la interfaz para los constructores de pizza
- `builder/MeatPizzaBuilder.java`: Implementación del constructor para pizzas de carne
- `builder/VegetarianPizzaBuilder.java`: Implementación del constructor para pizzas vegetarianas
- `director/MasterPizza.java`: Director que controla el proceso de construcción
- `Main.java`: Clase principal que demuestra el uso del patrón