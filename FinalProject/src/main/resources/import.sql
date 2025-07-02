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

INSERT INTO `order_details` (`delivery`,`order_state`, `is_completed` ) VALUES ('Estafeta','En preparación', 'false');
INSERT INTO `order_details` (`delivery`,`order_state`, `is_completed` ) VALUES ('DHL','Enviado', 'false');
INSERT INTO `order_details` (`delivery`,`order_state`, `is_completed` ) VALUES ('FEDex','En preparación', 'false');
INSERT INTO `order_details` (`delivery`,`order_state`, `is_completed` ) VALUES ('DHL','Entregado', 'true');
INSERT INTO `order_details` (`delivery`,`order_state`, `is_completed` ) VALUES ('Estafeta','Entregado', 'true');