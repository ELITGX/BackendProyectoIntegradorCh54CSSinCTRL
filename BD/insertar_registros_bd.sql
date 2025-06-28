----- users------
INSERT INTO users VALUES 
(1 , "Alberto", "Solorzano", "AlbSoloz@gmail.com", "+521111111111", "AZ123#1no"),
(2 , "Fernando", "Hernandez", "Fehz@gmail.com", "+522222222222", "HFFH#1vbo"),
(3 , "Hernando", "Fernandez", "HeFz@gmail.com", "+523333333333", "FHHF#1kqM"),
(4 , "Eliar", "Lopéz", "ElLo@gmail.com", "+524444444444", "LoEl#@14no"),
(5 , "José", "Chan", "JoCh@gmail.com", "+525555555555", "JojoCh#54");

----- addresses------
INSERT INTO addresses (address_id, user_id, city, state, postal_code, country)
VALUES 
  (1, 1, 'Ciudad de México', 'CDMX', '08200', 'México'),
  (2, 2, 'Guadalajara', 'Jalisco', '44100', 'México'),
  (3, 3, 'Monterrey', 'Nuevo León', '64000', 'México'),
  (4, 4, 'Puebla', 'Puebla', '72000', 'México'),
  (5, 5, 'Tijuana', 'Baja California', '22000', 'México');

----- categories------
INSERT INTO categories (
  category_id,
  name,
  description
) 
VALUES
(1, 'Medicamentos Generales', 'Medicamentos de uso común para síntomas generales'),
(2, 'Vitaminas', 'Suplementos alimenticios y vitaminas'),
(3, 'Antibióticos', 'Medicamentos para tratar infecciones bacterianas'),
(4, 'Dermatología', 'Productos para el cuidado de la piel y afecciones dermatológicas'),
(5, 'Pediatría', 'Medicamentos y suplementos especializados para niños');

----- roles------
INSERT INTO roles (role_id,name,description)
	VALUES
	(1,"administrador", "usuario encargado de la gestion de la pagina"),
	(2,"usuario","persona que busca comprar medicinas");

----- users_has_roles------
INSERT INTO users_has_roles (user_id,role_id)
	VALUES
	(1,1),
	(2,2),
	(3,2),
	(4,2),
	(5,2);
      
  ----- products_properties------
  INSERT INTO products_properties 
(product_property_id, product_id, presentation, concentration, 
  description, administration, precautions, origin, expiration_date, storage) 
VALUES 
  (1, 1, 'Ampolleta 10 ml', '150 mg/ml', 
  'Antioxidante que podría desempeñar un papel en la prevención del cáncer', 'Intravenoso', 
  'Puede causar efectos secundarios como sequedad de boca, náuseas, vómitos y diarrea', 'México', 
  '2024-06-30 23:59:59', 'Conservar en un lugar fresco y seco una vez abierto'),
  (2,2,'Ampolleta 10 ml', '0.5 mg/ml', 
  'Para fortalecer los los huesos, la reproducción, la coagulación sanguínea y para mantener un sistema inmunitario sano', 'Intravenoso', 
  'Completar el tratamiento indicado', 'México', 
  '2026-03-15 23:59:59', 'Proteger de la luz'),
  (3,3,'Frasco 25 ml', '40 mg/ml', 
  'Ayuda a reducir el deterioro cognitivo', 'Intramuscular', 
  'No administrar a menores de 2 años', 'México', 
  '2025-09-30 23:59:59', 'Proteger de la luz'),
  (4,4,'Ampolleta 10 ml', '100 mg/ml', 
  'Tratamiento de intoxicaciones, mejora la oxigenación del cuerpo', 'Intravenoso', 
  'Monitorizar posibles reacciones adversas', 'México', 
  '2027-01-15 23:59:59', 'Proteger de la luz'),
  (5,5,'Frasco 30 ml', '750 mg/ml', 
  'Ayuda a reducir el dolor e inflamación', 'Oral y tópico', 
  'No exceder la dosis recomendada', 'México', 
  '2025-12-31 23:59:59', 'Lugar fresco y seco');



----- order_details------
INSERT INTO order_details (
    delivery, 
    order_state, 
    is_completed
) 
VALUES 
    ('DHL', 'Procesando', 0),
    ('Estafeta', 'Enviado', 0),
    ('UPS', 'Entregado', 1),
    ('FedEx', 'Cancelado', 0),
    ('DHL', 'Procesando', 0);

----- orders------  
INSERT INTO orders(order_id, user_id, order_details_id, purchase_date, description, total_amount)
VALUES
(1,5,1,'2025-05-28','2 x NAC, 1 x Manganeso',13780.00),
(2,4,2,'2025-05-29','1 x Vivatiamin, 5 x Metilviv',2450.00),
(3,3,3,'2025-05-30','2 x DMSO',960.00),
(4,2,4,'2025-06-08','3 x Vivatiamin',1650.00),
(5,1,5,'2025-06-23','1 x Manganeso',380.00);

 ----- products------
INSERT INTO products (
  product_id,
  product_property_id,
  category_id,
  name,
  description,
  customizable,
  price,
  stock,
  `type` )
  VALUES
  (1, 1, 1,"NAC", "N-Acetil Cisteína", "10", "6700", "100", "Vía: intravenoso"),
  (2, 2, 2,"Manganeso", "Sulfato de manganeso", "10", "380", "100", "Vía: intravenoso"),
  (3, 3, 3,"Vivatiamin", "Pirofosfato de Tiamina", "25", "550", "100", "Vía: intramuscular, intravenoso"),
  (4, 4, 4,"Metilviv", "Azul de metileno", "10", "380", "100", "Vía: intravenoso"),
  (5, 5, 5,"DMSO", "Dimetil Sulfóxico al 99%", "50", "480", "100", "Vía: intravenoso");
  
----- order_has_products------
INSERT INTO order_has_products(order_id, product_id, order_quantity)
VALUES
(1,1,2),
(1,2,1),
(2,3,1),
(2,4,5),
(3,5,2),
(4,3,3),
(5,2,1);