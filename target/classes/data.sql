-- Insert sample suppliers
INSERT INTO suppliers (name, street, number, floor, door, city, zip_code, country, phone, fax, vat_number) VALUES
('LuxotticaGroup', 'Via Valcozzena', '10', '1', 'A', 'Milan', '20123', 'Italy', '+39 0437 6441', '+39 0437 63232', 'IT12345678901'),
('SafiloGroup', 'Settima Strada', '15', '2', 'B', 'Padova', '35129', 'Italy', '+39 049 698 5111', '+39 049 698 5000', 'IT98765432101');

-- Insert sample brands
INSERT INTO brands (name, supplier_id) VALUES
('Ray-Ban', 1),
('Oakley', 1),
('Carrera', 2),
('Polaroid', 2);

-- Insert sample glasses
INSERT INTO glasses (brand_id, prescription, mounting_type, frame_color, left_lens_color, right_lens_color, price) VALUES
(1, '+2.00/-1.50', 'METAL', 'Gold', 'Clear', 'Clear', 199.99),
(2, '+1.00/-1.00', 'FLOATING', 'Black', 'Green', 'Green', 159.99),
(3, '+3.00/-2.50', 'PASTE', 'Brown', 'Brown', 'Brown', 179.99);

-- Insert sample employees
INSERT INTO employees (name, employee_number) VALUES
('John Doe', 'EMP001'),
('Jane Smith', 'EMP002');

-- Insert sample customers
INSERT INTO customers (name, address, phone, email, registration_date) VALUES
('Alice Johnson', '123 Main St, Barcelona', '+34 666555444', 'alice@email.com', '2024-01-15');

-- Insert a customer recommended by Alice
INSERT INTO customers (name, address, phone, email, registration_date, recommended_by_id) VALUES
('Bob Wilson', '456 Park Ave, Barcelona', '+34 666777888', 'bob@email.com', '2024-02-01', 1);

-- Insert sample sales
INSERT INTO sales (customer_id, glasses_id, employee_id, sale_date) VALUES
(1, 1, 1, '2024-01-15 10:30:00'),
(2, 2, 2, '2024-02-01 15:45:00'); 