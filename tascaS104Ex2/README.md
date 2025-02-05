# Calculadora de Letra DNI

## 📄 Descripción
Este proyecto implementa una calculadora y validador de DNI (Documento Nacional de Identidad) español. El sistema calcula la letra correspondiente para un número de DNI y valida números de DNI completos según la normativa española.

Un DNI consiste en un número de 8 dígitos seguido de una letra de control. Esta aplicación ayuda a:
- Calcular la letra de control correcta para un número de DNI dado
- Validar números de DNI completos (números + letra)

## 💻 Tecnologías Utilizadas
- Java 11+
- JUnit 5 (jupiter)
- Maven/Gradle (herramienta de construcción)
- Pruebas Parametrizadas
- API Stream

## 📋 Requisitos
- Java JDK 11 o superior
- Maven 3.6+ o Gradle 7+ (dependiendo de la herramienta de construcción elegida)
- IDE con soporte para Java (recomendado: IntelliJ IDEA, Eclipse, o VS Code)

## 🛠️ Instalación
1. Clonar el repositorio: 
git clone [https://github.com/MaraMarchello/S104-Ex2-Java-Language-Nivel-1.git]

2. Navegar al directorio del proyecto:
cd S104-Ex2-Java-Language-Nivel-1

3. Construir el proyecto:
mvn clean install

o si usas Gradle:
gradle build

4. Ejecutar las pruebas:
mvn test
gradle test


## ▶️ Implementación
Para usar la calculadora de DNI en tu proyecto:

java
CalculoDni calculator = new CalculoDni();
// Calcular letra para un número de DNI
char letra = calculator.calculateLetter(12345678); // Devuelve 'Z'
// Validar DNI completo
boolean esValido = calculator.validateDni("12345678Z"); // Devuelve true


## 🌐 Despliegue
Este es un proyecto de biblioteca que puede incluirse en otras aplicaciones. Para incluirlo en tu proyecto:

### Maven
xml
<dependency>
<groupId>[group-id]</groupId>
<artifactId>dni-calculator</artifactId>
<version>[version]</version>
</dependency>


### Gradle
groovy
implementation '[group-id]:dni-calculator:[version]'


## 🤝 Contribución
¡Las contribuciones son bienvenidas! Por favor, sigue estos pasos:


1. Haz un fork del repositorio
2. Crea una nueva rama (`git checkout -b feature/mejora`)
3. Realiza tus cambios
4. Ejecuta las pruebas (`mvn test` o `gradle test`)
5. Confirma tus cambios (`git commit -am 'Añadir nueva funcionalidad'`)
6. Empuja a la rama (`git push origin feature/mejora`)
7. Crea una Solicitud de Extracción (Pull Request)

### Pruebas
El proyecto incluye pruebas unitarias completas. Para ejecutar las pruebas:

---
Nota: Este proyecto es con fines educativos y demuestra la implementación de la lógica de validación de DNI usando Java y JUnit 5.