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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` char(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(1) NOT NULL,
  `phone` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `subscribe` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('A123123123','CTT123','尤構豪笑','CTT@gmail.com','2000-01-01','M','0911111111','台東市富岡區海灣3333號',0),('A123456789','bgg654','杜紫豪萼','bgg@mail.com','1991-07-04','F','0900000000','台南市永康區成功路20000號',1),('A132997293','asdf1234','李三寶','HTC@gmail.com','1999-12-12','M','0911223344','龍山區',0),('A182121678','123456','李大寶','null@gmail.com','2000-02-02','M','0911223344','龍山區',0),('D118098429','asdsa564654','王大強','gggC@gmail.com','1987-08-12','M','0911223344','劃掉區',1),('G293481361','yilan123','夷嵐仁','yilan123@gmail.com','1988-09-20','S','0933333333','好水區',0),('H276365663','a4665421354','金價摳玲','ggcl@gmail.com','1999-01-12','F','0911223344','高山區',1),('I116047414','123456','郝可愛','ref@gmail.com','1989-09-07','F','0922222222','好命區',1),('J290779106','sss456','辛竹壬','sss456@gmail.com','1979-09-11','F','0944444444','好多區',1),('L221718269','asdsa564654','剛舞摳玲','gwcl@gmail.com','2000-01-12','F','0911223344','高山區',1),('M124774964','pp9999','蒲禮仁','ppp999@gmail.com','1996-09-18','S','0999999999','好茶區',0),('M281334646','123456','由點遠','KKK@mail.com','1989-05-20','F','0989444555','很有區',0),('N176024294','GTAWESA','沼璞稻','Cbd@gmail.com','1950-01-12','M','0911223344','沼澤區',1),('P144396039','987987','布慧琶','asdassaasdd@654.com','1960-09-21','S','0922222222','趣味區',1),('R136332550','654321','郝天憩','asdasd@654.com','1973-09-06','M','0922222222','遊憩區',1),('X216943099','123123','溫暖天','asdassaasd54654d@654.com','1989-09-14','F','0922222222','流汗區',0),('Y264746641','654321','郝動人','ref11@gmail.com','1989-09-06','F','0922222222','復育區',1);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
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
