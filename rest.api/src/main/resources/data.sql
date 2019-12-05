DROP TABLE IF EXISTS product_data;

CREATE TABLE product_data (
  id VARCHAR2(50) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250)
);

INSERT INTO product_data (id, name, description) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');