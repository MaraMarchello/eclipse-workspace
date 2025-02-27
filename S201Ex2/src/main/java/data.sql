-- Provinces
INSERT INTO Provinces (province_id, name) VALUES
(1, 'California'),
(2, 'New York'),
(3, 'Texas');

-- Cities
INSERT INTO Cities (city_id, name, province_id) VALUES
(1, 'Los Angeles', 1),
(2, 'San Francisco', 1),
(3, 'New York City', 2),
(4, 'Buffalo', 2),
(5, 'Houston', 3);

-- Customers
INSERT INTO Customers (customer_id, first_name, last_name, address, zip_code, city_id, phone) VALUES
(1, 'John', 'Doe', '123 Main St', '90001', 1, '555-1234'),
(2, 'Jane', 'Smith', '456 Elm St', '10001', 3, '555-5678'),
(3, 'Bob', 'Johnson', '789 Oak St', '77001', 5, '555-9012');

-- ProductCategories
INSERT INTO ProductCategories (category_id, name) VALUES
(1, 'Pizza'),
(2, 'Burger'),
(3, 'Beverage');

-- Products
INSERT INTO Products (product_id, name, description, image_url, price, category_id) VALUES
(1, 'Margherita', 'Classic tomato and mozzarella', 'pizza1.jpg', 9.99, 1),
(2, 'Pepperoni', 'Pepperoni and cheese', 'pizza2.jpg', 11.99, 1),
(3, 'Cheeseburger', 'Beef patty with cheese', 'burger1.jpg', 7.99, 2),
(4, 'Cola', 'Refreshing cola drink', 'cola.jpg', 1.99, 3);

-- Stores
INSERT INTO Stores (store_id, address, zip_code, city_id) VALUES
(1, '100 Market St', '90001', 1),
(2, '200 Broadway', '10001', 3),
(3, '300 Main St', '77001', 5);

-- Employees
INSERT INTO Employees (employee_id, first_name, last_name, nif, phone, role, store_id) VALUES
(1, 'Alice', 'Brown', '123456789', '555-1111', 'cook', 1),
(2, 'Charlie', 'Davis', '987654321', '555-2222', 'distributor', 1),
(3, 'Eve', 'White', '456789123', '555-3333', 'cook', 2);

-- Orders
INSERT INTO Orders (order_id, customer_id, order_datetime, delivery_type, total_price, store_id) VALUES
(1, 1, '2023-10-01 12:00:00', 'home', 21.97, 1),
(2, 2, '2023-10-02 13:00:00', 'pickup', 9.99, 2);

-- OrderItems
INSERT INTO OrderItems (order_item_id, order_id, product_id, quantity, price) VALUES
(1, 1, 1, 1, 9.99),
(2, 1, 3, 1, 7.99),
(3, 1, 4, 2, 3.98),
(4, 2, 1, 1, 9.99);

-- Deliveries
INSERT INTO Deliveries (delivery_id, order_id, distributor_id, delivery_datetime) VALUES
(1, 1, 2, '2023-10-01 12:30:00');