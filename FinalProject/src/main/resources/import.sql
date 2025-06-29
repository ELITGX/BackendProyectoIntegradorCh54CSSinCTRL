-- Rol 1: Administrador con acceso total
INSERT INTO `roles` (`name`, `description`) VALUES ('Admin', 'Acceso total al sistema y a la configuración.');

-- Rol 2: Cliente estándar que realiza compras
INSERT INTO `roles` (`name`, `description`) VALUES ('PepeChuy', 'Toromax guiiiii');

INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Alberto', 'Solorzano', 'AlbSoloz@gmail.com', '+521111111111', 'AZ123#1no');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Fernando', 'Hernandez', 'Fehz@gmail.com', '+522222222222', 'HFFH#1vbo');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Hernando', 'Fernandez', 'HeFz@gmail.com', '+523333333333', 'FHHF#1kqM');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('Eliar', 'Lopéz', 'ElLo@gmail.com', '+524444444444', 'LoEl#@14no');
INSERT INTO `users` (`name`,`last_name`,`email`,`phone`,`password`) VALUES ('José', 'Chan', 'JoCh@gmail.com', '+525555555555', 'JojoCh#54');