-- Create Suppliers table
CREATE TABLE suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    number VARCHAR(10),
    floor VARCHAR(10),
    door VARCHAR(10),
    city VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    country VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    fax VARCHAR(20),
    vat_number VARCHAR(20) NOT NULL UNIQUE
);

-- Create Brands table
CREATE TABLE brands (
    brand_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    supplier_id INT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

-- Create Glasses table
CREATE TABLE glasses (
    glasses_id INT AUTO_INCREMENT PRIMARY KEY,
    brand_id INT NOT NULL,
    prescription VARCHAR(50) NOT NULL,
    mounting_type ENUM('FLOATING', 'PASTE', 'METAL') NOT NULL,
    frame_color VARCHAR(30) NOT NULL,
    left_lens_color VARCHAR(30) NOT NULL,
    right_lens_color VARCHAR(30) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);

-- Create Customers table
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    registration_date DATE NOT NULL,
    recommended_by_id INT,
    FOREIGN KEY (recommended_by_id) REFERENCES customers(customer_id)
);

-- Create Employees table
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    employee_number VARCHAR(20) NOT NULL UNIQUE
);

-- Create Sales table
CREATE TABLE sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    glasses_id INT NOT NULL,
    employee_id INT NOT NULL,
    sale_date DATETIME NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (glasses_id) REFERENCES glasses(glasses_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
); 