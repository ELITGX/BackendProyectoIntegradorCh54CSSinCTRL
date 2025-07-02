-- Rol 1: Administrador con acceso total
INSERT INTO `roles` (`name`, `description`) VALUES ('Admin', 'Acceso total al sistema y a la configuración.');

-- Rol 2: Colaborador
INSERT INTO `roles` (`name`, `description`) VALUES ('Colaborador', 'Colaborador de la aplicación add, modifica y borra productos');

-- Rol 3: Colaborador
INSERT INTO `roles` (`name`, `description`) VALUES ('Bucanero', 'Se que voy a enloquecer si no te tengo aqui....');

-- Rol 4: Cliente estándar que realiza compras
INSERT INTO `roles` (`name`, `description`) VALUES ('Cliente', 'Compra de productos');

INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Alberto', 'Solorzano', 'AlbSoloz@gmail.com', '+521111111111', 'AZ123#1no');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Fernando', 'Hernandez', 'Fehz@gmail.com', '+522222222222', 'HFFH#1vbo');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Hernando', 'Fernandez', 'HeFz@gmail.com', '+523333333333', 'FHHF#1kqM');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Eliar', 'Lopéz', 'ElLo@gmail.com', '+524444444444', 'LoEl#@14no');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('José', 'Chan', 'JoCh@gmail.com', '+525555555555', 'JojoCh#54');

INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('1','1'); 
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('2','2'); 
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('1','3'); 
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('2','1'); 
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('2','4');
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('2','5');
INSERT INTO `user_has_role` (`role_id`,`user_id`) VALUES ('3','1'); 

INSERT INTO addresses (user_id, city, state, postal_code, country) VALUES (1, 'Ciudad de México', 'CDMX', '08200', 'México');
INSERT INTO addresses (user_id, city, state, postal_code, country) VALUES (2, 'Guadalajara', 'Jalisco', '44100', 'México');
INSERT INTO addresses (user_id, city, state, postal_code, country) VALUES (3, 'Monterrey', 'Nuevo León', '64000', 'México');
INSERT INTO addresses (user_id, city, state, postal_code, country) VALUES (4, 'Puebla', 'Puebla', '72000', 'México');
INSERT INTO addresses (user_id, city, state, postal_code, country) VALUES (5, 'Tijuana', 'Baja California', '22000', 'México');

INSERT INTO categories (name, description) VALUES ('Medicamentos Generales', 'Medicamentos de uso común para síntomas generales');
INSERT INTO categories (name, description) VALUES ('Vitaminas', 'Suplementos alimenticios y vitaminas');
INSERT INTO categories (name, description) VALUES ('Antibióticos', 'Medicamentos para tratar infecciones bacterianas');
INSERT INTO categories (name, description) VALUES ('Dermatología', 'Productos para el cuidado de la piel y afecciones dermatológicas');
INSERT INTO categories (name, description) VALUES ('Pediatría', 'Medicamentos y suplementos especializados para niños');

INSERT INTO products_properties (presentation, concentration, description, administration, precautions, origin, expiration_date, storage) VALUES ('Frasco 25 ml', '40 mg/ml', 'Ayuda a reducir el deterioro cognitivo', 'Intramuscular', 'No administrar a menores de 2 años', 'México', '2025-09-30 23:59:59', 'Proteger de la luz');
INSERT INTO products_properties (presentation, concentration, description, administration, precautions, origin, expiration_date, storage) VALUES ('Ampolleta 10 ml', '100 mg/ml', 'Tratamiento de intoxicaciones, mejora la oxigenación del cuerpo', 'Intravenoso', 'Monitorizar posibles reacciones adversas', 'México', '2027-01-15 23:59:59', 'Proteger de la luz');
INSERT INTO products_properties (presentation, concentration, description, administration, precautions, origin, expiration_date, storage) VALUES ('Ampolleta 10 ml', '150 mg/ml', 'Antioxidante que podría desempeñar un papel en la prevención del cáncer', 'Intravenoso', 'Puede causar efectos secundarios como sequedad de boca, náuseas, vómitos y diarrea', 'México', '2024-06-30 23:59:59', 'Conservar en un lugar fresco y seco una vez abierto');
INSERT INTO products_properties (presentation, concentration, description, administration, precautions, origin, expiration_date, storage) VALUES ('Ampolleta 10 ml', '0.5 mg/ml', 'Para fortalecer los los huesos, la reproducción, la coagulación sanguínea y para mantener un sistema inmunitario sano', 'Intravenoso', 'Completar el tratamiento indicado', 'México', '2026-03-15 23:59:59', 'Proteger de la luz');
INSERT INTO products_properties (presentation, concentration, description, administration, precautions, origin, expiration_date, storage) VALUES ('Frasco 30 ml', '750 mg/ml', 'Ayuda a reducir el dolor e inflamación', 'Oral y tópico', 'No exceder la dosis recomendada', 'México', '2025-12-31 23:59:59', 'Lugar fresco y seco');
INSERT INTO products (product_properties_id, category_id, name, description, price, stock, img_url) VALUES (1, 1, "NAC", "N-Acetil Cisteína", "6700", "100", "Vía: intravenoso");
INSERT INTO products (product_properties_id, category_id, name, description, price, stock, img_url) VALUES (2, 2, "Manganeso", "Sulfato de manganeso", "380", "100", "Vía: intravenoso");
INSERT INTO products (product_properties_id, category_id, name, description, price, stock, img_url) VALUES (3, 3, "Vivatiamin", "Pirofosfato de Tiamina", "550", "100", "Vía: intramuscular, intravenoso");
INSERT INTO products (product_properties_id, category_id, name, description, price, stock, img_url) VALUES (4, 4, "Metilviv", "Azul de metileno", "380", "100", "Vía: intravenoso");
INSERT INTO products (product_properties_id, category_id, name, description, price, stock, img_url) VALUES (5, 5, "DMSO", "Dimetil Sulfóxico al 99%", "480", "100", "Vía: intravenoso");


