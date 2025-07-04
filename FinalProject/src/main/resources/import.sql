-- Rol 1: Administrador con acceso total
INSERT INTO `roles` (`name`, `description`) VALUES ('Admin', 'Acceso total al sistema y a la configuración.');

-- Rol 2: Colaborador
INSERT INTO `roles` (`name`, `description`) VALUES ('Colaborador', 'Colaborador en los datos de productos');

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

INSERT INTO products (product_properties_id, category_id, name, description, price, presentation, concentration,  administration_route, stock, img_url) VALUES (1, 1, "Ácido Alfa Lipoíco", "Posee propiedades antioxidantes, neutraliza radicales libres, retrasa el envejecimiento, incrementa la respuesta inmune, mejora la capacidad detoxificadora del hígado y ayuda a prevenir las cataratas y las enfermedades vasculares ateroscleróticas. Estimula la síntesis de glutatión, reduce los niveles de triglicéridos y de lipoproteínas de muy baja densidad, favorece la conversión de carbohidratos en energía, incrementa el transporte de glucosa a través de las membranas celulares y su captación por adipocitos y células musculares, mejorando la respuesta a la insulina y disminuyendo la glucosa en sangre.", "6700",'Frasco 25 ml', '40 mg/ml', 'Intramuscular', "100", "https://raw.githubusercontent.com/ELITGX/Ch54-ProyectoIntegrador-CSSinCTRL/main/images/Productos/alfaLip.png");
INSERT INTO products (product_properties_id, category_id, name, description, price, presentation, concentration,  administration_route, stock, img_url) VALUES (2, 2, "Arginina y Ornitina", "La arginina es esencial para la síntesis de proteínas. Estimula la glándula hipofisaria, la secreción de la hormona del crecimiento humano y la función inmune. Ayuda a combatir la fatiga física y mental, y actúa sobre el músculo liso intestinal, mejorando la contracción peristáltica. También regenera el tejido hepático, es un antioxidante hormonal, favorece la remetilación del ADN, es precursora del óxido nítrico y mejora la cicatrización de heridas y quemaduras al estimular la producción de colágeno y elastina. La ornitina potencia la producción de hormona del crecimiento humano, contribuye al metabolismo de las grasas, con un efecto mayor cuando se combina con arginina o carnitina. Refuerza el sistema inmunológico, estimula la secreción de insulina y su acción anabólica, desintoxica el organismo del amoníaco y favorece la regeneración hepática.", "380",'Ampolleta 10 ml', '100 mg/ml', 'Intravenoso', "100", "https://raw.githubusercontent.com/ELITGX/Ch54-ProyectoIntegrador-CSSinCTRL/main/images/Productos/arginina.png");
INSERT INTO products (product_properties_id, category_id, name, description, price, presentation, concentration,  administration_route, stock, img_url) VALUES (3, 3, "Melatonina", "La melatonina es una terapia innovadora para combatir trastornos del sueño, especialmente en casos graves como el insomnio crónico. Este tratamiento destaca por su rápida acción, logrando efectos casi inmediatos al ser absorbido de manera directa y eficaz. Ha demostrado mejoras significativas en la calidad del sueño, reduciendo el tiempo para conciliarlo y los despertares nocturnos. También es útil en personas mayores, pacientes con trastornos psiquiátricos o en recuperación postquirúrgica, ayudando a restablecer los ciclos de sueño. Aunque es segura y efectiva, debe utilizarse bajo supervisión médica. La melatonina no reemplaza los tratamientos convencionales, pero potencia sus efectos, ofreciendo una solución rápida y eficaz para mejorar el descanso y la calidad de vida.", "550", 'Ampolleta 10 ml', '150 mg/ml', 'Intravenoso', "100", "https://raw.githubusercontent.com/ELITGX/Ch54-ProyectoIntegrador-CSSinCTRL/main/images/Productos/melatonina.png");
INSERT INTO products (product_properties_id, category_id, name, description, price, presentation, concentration,  administration_route, stock, img_url) VALUES (4, 4, "Procalive", "Sus compuestos le confieren una amplia gama de propiedades antienvejecimiento. Genera una sensación de bienestar, estimula la mente y favorece la formación de neurotransmisores, mejorando la función cerebral, la calidad del sueño en casos de insomnio y la memoria. Reduce problemas auditivos, dolores de cabeza frecuentes y síntomas relacionados con el Parkinson, la aterosclerosis y la mala circulación. Combate la desintegración celular, contribuye a la formación de células sanguíneas y proteínas metabolizadoras, conserva la piel, el cabello y las glándulas, y regula la arritmia cardíaca y la presión arterial elevada.", "380", 'Ampolleta 10 ml', '0.5 mg/ml', 'Intravenoso', "100", "https://raw.githubusercontent.com/ELITGX/Ch54-ProyectoIntegrador-CSSinCTRL/main/images/Productos/procalive.png");
INSERT INTO products (product_properties_id, category_id, name, description, price, presentation, concentration,  administration_route, stock, img_url) VALUES (5, 5, "Selenio Orgánico", "El selenio orgánico es ideal para tu cuerpo: desintoxica el hígado, promoviendo su buen funcionamiento. Fortalece el sistema inmunológico y refuerza las defensas al aumentar el número de células protectoras. Regenera las vitaminas C y E, manteniendo el cuerpo lleno de energía y vitalidad. Pero eso no es todo: combate la inflamación, aliviando dolores y molestias. Ayuda a prevenir el cáncer gracias a su acción sobre la metilación del ADN. Descubre cómo este potente antioxidante puede revolucionar tu práctica.", "480", 'Frasco 30 ml', '750 mg/ml', 'Oral y tópico', "100", "https://raw.githubusercontent.com/ELITGX/Ch54-ProyectoIntegrador-CSSinCTRL/main/images/Productos/selenio.png");

INSERT INTO order_details (delivery, order_state, is_completed) VALUES ('DHL', 'Procesando', 0);
INSERT INTO order_details (delivery, order_state, is_completed) VALUES ('Estafeta', 'Enviado', 0);
INSERT INTO order_details (delivery, order_state, is_completed) VALUES ('UPS', 'Entregado', 1);
INSERT INTO order_details (delivery, order_state, is_completed) VALUES ('FedEx', 'Cancelado', 0);
INSERT INTO order_details (delivery, order_state, is_completed) VALUES ('DHL', 'Procesando', 0);

INSERT INTO orders (user_id, order_details_id, purchase_date, description, total_amount) VALUES (5, 1, '2025-05-28', '2 x NAC, 1 x Manganeso', 13780.00);
INSERT INTO orders (user_id, order_details_id, purchase_date, description, total_amount) VALUES (4, 2, '2025-05-29', '1 x Vivatiamin, 5 x Metilviv', 2450.00);
INSERT INTO orders (user_id, order_details_id, purchase_date, description, total_amount) VALUES (3, 3, '2025-05-30', '2 x DMSO', 960.00);
INSERT INTO orders (user_id, order_details_id, purchase_date, description, total_amount) VALUES (2, 4, '2025-06-08', '3 x Vivatiamin', 1650.00);
INSERT INTO orders (user_id, order_details_id, purchase_date, description, total_amount) VALUES (1, 5, '2025-06-23', '1 x Manganeso', 380.00);

/*INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (1,1,2);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (1,2,1);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (2,3,1);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (2,4,5);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (3,5,2);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (4,3,3);
INSERT INTO order_has_products(order_id, product_id, order_quantity) VALUES (5,2,1);*/



