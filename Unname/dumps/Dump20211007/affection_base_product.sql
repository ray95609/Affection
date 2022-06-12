-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: affection_base
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `discount` int NOT NULL DEFAULT '0',
  `stock` int unsigned NOT NULL,
  `need` int unsigned NOT NULL,
  `photoUrl` varchar(500) DEFAULT NULL,
  `description` varchar(500) NOT NULL DEFAULT '',
  `shelf_date` date NOT NULL DEFAULT (curdate()),
  `type` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Milk',100,0,100,500,'http://localhost:8080/Affection/img/product/food/milk.jpg','Fresh&Direct delivery','2021-09-27','Food'),(2,'Newborn clothes',500,0,50,100,'http://localhost:8080/Affection/img/product/clothes/clothes.jpg','For cuty newborns','2021-09-27','Clothes'),(3,'Television',20000,0,1,4,'http://localhost:8080/Affection/img/product/electrical/tv.jpg','Provide a educational environment for children ','2021-09-27','Electrical'),(4,'Toy car',500,0,5,10,'http://localhost:8080/Affection/img/product/toy/toy_car_1.jpg','Grow with happiness','2021-09-27','Toy'),(5,'Meat',500,0,350,500,'http://localhost:8080/Affection/img/product/food/meat.jpg','For children healthier Make them happier. ','2021-09-27','Food'),(6,'Noodle',100,0,100,500,'http://localhost:8080/Affection/img/product/food/noodle.jpg','Healthy ingredients','2021-10-03','Food'),(7,'Egg',100,0,50,200,'http://localhost:8080/Affection/img/product/food/egg.jpg','Fresh&Direct delivery','2021-10-03','Food'),(8,'Seasoning',100,0,30,100,'http://localhost:8080/Affection/img/product/food/seasoning.jpg','Rich flavor','2021-10-03','Food'),(9,'Diaper',1000,0,400,500,'http://localhost:8080/Affection/img/product/clothes/diaper.jpg','Stay away from diaper rash','2021-10-03','Clothes'),(10,'Pants',500,0,50,100,'http://localhost:8080/Affection/img/product/clothes/pants_1.jpg','Daily necessities','2021-10-03','Clothes'),(11,'Coat',1000,0,20,100,'http://localhost:8080/Affection/img/product/clothes/coat_1.jpg','Warm tiny body','2021-10-03','Clothes'),(12,'T-shirt',500,0,50,100,'http://localhost:8080/Affection/img/product/clothes/t-shirt.jpg','Daily necessities','2021-10-03','Clothes'),(13,'Air conditioner',50000,0,0,3,'http://localhost:8080/Affection/img/product/electrical/air_condition.jpeg','Provide a comfortable  environment for children ','2021-10-03','Electrical'),(14,'Wash machine',10000,0,0,1,'http://localhost:8080/Affection/img/product/electrical/Washing-Machine.jpg','Provide a clean  environment for children ','2021-10-03','Electrical'),(15,'Refrigerator',30000,0,0,1,'http://localhost:8080/Affection/img/product/electrical/refrigerator.jpg','Provide a healthy  environment for children ','2021-10-03','Electrical'),(16,'Computer',30000,0,1,5,'http://localhost:8080/Affection/img/product/electrical/computer.jpg','Provide a educational environment for children ','2021-10-03','Electrical'),(17,'Toy horse',1000,0,1,5,'http://localhost:8080/Affection/img/product/toy/toy_horse.jpg','Grow with happiness','2021-10-03','Toy'),(18,'Swing',1000,0,2,3,'http://localhost:8080/Affection/img/product/toy/toy1.jpg','Grow with happiness','2021-10-03','Toy'),(19,'Blocks',500,0,5,10,'http://localhost:8080/Affection/img/product/toy/blocks.jpg','Grow with happiness','2021-10-03','Toy'),(20,'Ball',500,0,3,10,'http://localhost:8080/Affection/img/product/toy/ball.jpg','Grow with happiness','2021-10-03','Toy'),(23,'Small donation',500,0,20,100,'http://localhost:8080/Affection/img/product/money/donate2.jpg','Help us build a beautiful environment','2021-10-03','Cash'),(24,'Large donation',5000,0,10,100,'http://localhost:8080/Affection/img/product/money/donate2.jpg','Help us build a beautiful environment','2021-10-03','Cash');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-07 14:50:36
