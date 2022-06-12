CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL DEFAULT (curdate()),
  `order_time` time NOT NULL DEFAULT (curtime()),
  `paymentType` varchar(45) NOT NULL,
  `paymentNote` varchar(200) NOT NULL DEFAULT '',
  `recipient_name` varchar(100) NOT NULL,
  `recipient_phone` varchar(100) NOT NULL,
  `recipient_address` varchar(100) NOT NULL,
  `ReceiptType` varchar(100) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `customer_id` char(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_order_TO_customer_idx` (`customer_id`),
  CONSTRAINT `fkey_order_TO_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
