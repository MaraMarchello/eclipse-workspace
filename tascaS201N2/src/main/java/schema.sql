-- Tables for location hierarchy
CREATE TABLE Provinces (
    province_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Cities (
    city_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    province_id INT,
    FOREIGN KEY (province_id) REFERENCES Provinces(province_id)
);

-- Customer table
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    city_id INT,
    phone VARCHAR(20),
    FOREIGN KEY (city_id) REFERENCES Cities(city_id)
);

-- Product tables
CREATE TABLE ProductCategories (
    category_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES ProductCategories(category_id)
);

-- Store and employee tables
CREATE TABLE Stores (
    store_id INT PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES Cities(city_id)
);

CREATE TABLE Employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    nif VARCHAR(20) NOT NULL UNIQUE,
    phone VARCHAR(20),
    role ENUM('cook', 'distributor') NOT NULL,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Stores(store_id)
);

-- Order tables
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_datetime DATETIME NOT NULL,
    delivery_type ENUM('home', 'pickup') NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    store_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (store_id) REFERENCES Stores(store_id)
);

CREATE TABLE OrderItems (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Deliveries (
    delivery_id INT PRIMARY KEY,
    order_id INT UNIQUE,
    distributor_id INT,
    delivery_datetime DATETIME NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (distributor_id) REFERENCES Employees(employee_id)
);