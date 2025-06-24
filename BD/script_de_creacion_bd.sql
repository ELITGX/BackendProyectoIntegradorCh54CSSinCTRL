CREATE TABLE `order_details` (
  `order_details_id` BIGINT,
  `delivery` VARCHAR(80),
  `order_state` VARCHAR(80),
  `is_completed` TINYINT(1),
  PRIMARY KEY (`order_details_id`)
);

CREATE TABLE `users` (
  `user_id` BIGINT,
  `name` VARCHAR(50),
  `last_name` VARCHAR(75),
  `email` VARCHAR(50),
  `phone` VARCHAR(15),
  `password` VARCHAR(120),
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `roles` (
  `role_id` BIGINT,
  `name` VARCHAR(20),
  `description` VARCHAR(50),
  PRIMARY KEY (`role_id`)
);

CREATE TABLE `addresses` (
  `address_id` BIGINT,
  `user_id` BIGINT,
  `city` VARCHAR(30),
  `state` VARCHAR(30),
  `postal_code` VARCHAR(10),
  `country` VARCHAR(30),
  PRIMARY KEY (`address_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`)
);


CREATE TABLE `products_properties` (
  `product_property_id` BIGINT,
  `product_id` BIGINT,
  `presentation` VARCHAR(50),
  `concentration` VARCHAR(100),
  `description` VARCHAR(250),
  `administration` VARCHAR(255),
  `precautions` VARCHAR(255),
  `origin` VARCHAR(100),
  `expiration_date` TIMESTAMP,
  `storage` VARCHAR(150),
  PRIMARY KEY (`product_property_id`)
);

CREATE TABLE `categories` (
  `category_id` BIGINT,
  `name` VARCHAR(75),
  `description` VARCHAR(100),
  PRIMARY KEY (`category_id`)
);

CREATE TABLE `products` (
  `product_id` BIGINT,
  `product_properties_id` BIGINT,
  `category_id` BIGINT,
  `name` VARCHAR(200),
  `description` VARCHAR(50),
  `customizable` INT,
  `price` DECIMAL(10,2),
  `img_url` VARCHAR(250),
  `stock` INT,
  `type` VARCHAR(20),
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`product_properties_id`) REFERENCES `products_properties`(`product_property_id`),
  FOREIGN KEY (`category_id`) REFERENCES `categories`(`category_id`)
);

CREATE TABLE `users_has_roles` (
  `user_id` BIGINT,
  `role_id` BIGINT,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`role_id`) REFERENCES `roles`(`role_id`)
);

CREATE TABLE `orders` (
  `order_id` BIGINT,
  `user_id` BIGINT,
  `order_details_id` BIGINT,
  `purchase_date` TIMESTAMP,
  `description` VARCHAR(250),
  `total_amount` DECIMAL(10,2),
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`order_details_id`) REFERENCES `order_details`(`order_details_id`)
);

CREATE TABLE `order_has_products` (
  `order_id` BIGINT,
  `product_id` BIGINT,
  `order_quantity` INT,
  FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`)
);