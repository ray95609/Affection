CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `uni_price` double NOT NULL,
  `discount` int NOT NULL DEFAULT '0',
  `stock` int unsigned NOT NULL,
  `need` int unsigned NOT NULL,
  `photo_url` varchar(500) DEFAULT NULL,
  `description` varchar(500) NOT NULL DEFAULT '',
  `shelf_date` date NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_type` (
  `type_id` int NOT NULL,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`type_id`,`type_name`),
  CONSTRAINT `product_type_TO_productId` FOREIGN KEY (`type_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

