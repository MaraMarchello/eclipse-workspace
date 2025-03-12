# Cul d'Ampolla - Sistema de Gestión de Óptica / Optical Shop Management System

# Español

## 📄 Descripción
Sistema de gestión para la óptica Cul d'Ampolla que maneja datos de clientes, inventario de gafas y registro de ventas. El sistema realiza seguimiento de recomendaciones de clientes y mantiene información detallada de productos incluyendo marcas, tipos de monturas y precios.

### Características Principales:
- Gestión de clientes con datos de contacto
- Control de inventario de gafas
- Seguimiento de ventas
- Sistema de recomendaciones de clientes
- API completa de endpoints

## 💻 Tecnologías Utilizadas
- Node.js
- Express.js
- MongoDB
- Mongoose
- Faker.js (para datos de ejemplo)
- Nodemon (desarrollo)
- Dotenv (configuración de entorno)
- CORS

## 📋 Requisitos
- Node.js (v12 o superior)
- MongoDB (v4.4 o superior)
- npm (Gestor de Paquetes de Node)

## 🛠️ Instalación
1. Clonar el repositorio:
```bash
git clone https://github.com/MaraMarchello/S2.03-Ex2-Estructura-de-dades-MongoDB-N1
cd cul-d-ampolla
```

2. Instalar dependencias:
```bash
npm install
```

3. Crear archivo .env en el directorio raíz:
```
MONGODB_URI=mongodb://localhost:27017/cul-d-ampolla
PORT=3000
```

## ▶️ Implementación
1. Iniciar el servicio de MongoDB en su sistema

2. Poblar la base de datos con datos de ejemplo:
```bash
npm run seed
```

3. Iniciar el servidor de desarrollo:
```bash
npm run dev
```

4. Acceder a la API en `http://localhost:3000`

## 🌐 Despliegue
1. Asegurar que MongoDB está correctamente configurado en producción
2. Configurar variables de entorno en el entorno de producción
3. Instalar dependencias: `npm install --production`
4. Iniciar el servidor: `npm start`

## 🤝 Contribución
1. Hacer un fork del repositorio
2. Crear una rama para la nueva funcionalidad
3. Realizar los commits con los cambios
4. Hacer push a la rama
5. Crear un Pull Request 