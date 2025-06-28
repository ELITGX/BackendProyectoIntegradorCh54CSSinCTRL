-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdproyecto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdproyecto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdproyecto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bdproyecto` ;

-- -----------------------------------------------------
-- Table `bdproyecto`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`users` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(75) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `password` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`addresses` (
  `address_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `state` VARCHAR(30) NOT NULL,
  `postal_code` VARCHAR(10) NOT NULL,
  `country` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`address_id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `addresses_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bdproyecto`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`categories` (
  `category_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`order_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`order_details` (
  `order_details_id` BIGINT NOT NULL AUTO_INCREMENT,
  `delivery` VARCHAR(80) NOT NULL,
  `order_state` VARCHAR(80) NOT NULL,
  `is_completed` TINYINT(1) NOT NULL,
  PRIMARY KEY (`order_details_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`orders` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `order_details_id` BIGINT NOT NULL,
  `purchase_date` TIMESTAMP NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `total_amount` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  INDEX `order_details_id` (`order_details_id` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bdproyecto`.`users` (`user_id`),
  CONSTRAINT `orders_ibfk_2`
    FOREIGN KEY (`order_details_id`)
    REFERENCES `bdproyecto`.`order_details` (`order_details_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`products_properties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`products_properties` (
  `product_property_id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT NOT NULL,
  `presentation` VARCHAR(50) NOT NULL,
  `concentration` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `administration` VARCHAR(255) NOT NULL,
  `precautions` VARCHAR(255) NOT NULL,
  `origin` VARCHAR(100) NOT NULL,
  `expiration_date` TIMESTAMP NOT NULL,
  `storage` VARCHAR(150) NULL,
  PRIMARY KEY (`product_property_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`products` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_property_id` BIGINT NOT NULL,
  `category_id` BIGINT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `customizable` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `img_url` VARCHAR(250) NULL DEFAULT NULL,
  `stock` INT NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `product_properties_id` (`product_property_id` ASC) VISIBLE,
  INDEX `category_id` (`category_id` ASC) VISIBLE,
  CONSTRAINT `products_ibfk_1`
    FOREIGN KEY (`product_property_id`)
    REFERENCES `bdproyecto`.`products_properties` (`product_property_id`),
  CONSTRAINT `products_ibfk_2`
    FOREIGN KEY (`category_id`)
    REFERENCES `bdproyecto`.`categories` (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`order_has_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`order_has_products` (
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `order_quantity` INT NOT NULL,
  INDEX `order_id` (`order_id` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_has_products_ibfk_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `bdproyecto`.`orders` (`order_id`),
  CONSTRAINT `order_has_products_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `bdproyecto`.`products` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`roles` (
  `role_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdproyecto`.`users_has_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdproyecto`.`users_has_roles` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  INDEX `role_id` (`role_id` ASC) VISIBLE,
  CONSTRAINT `users_has_roles_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bdproyecto`.`users` (`user_id`),
  CONSTRAINT `users_has_roles_ibfk_2`
    FOREIGN KEY (`role_id`)
    REFERENCES `bdproyecto`.`roles` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
