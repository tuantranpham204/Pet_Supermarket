-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pet_supermarket
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `img_id` bigint NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `discount_id` bigint DEFAULT NULL,
  `pet_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  UNIQUE KEY `UKftsvp7ct02cf7sfud9gjc1yk0` (`discount_id`),
  UNIQUE KEY `UKbox1tdt7a779j63mrs7160oar` (`pet_id`),
  UNIQUE KEY `UKjvinkc7xcd0x0pk49c1me6hb6` (`product_id`),
  UNIQUE KEY `UKgn0kkmw9cx9tbd2bwc6xxbqr7` (`user_id`),
  CONSTRAINT `FK13ljqfrfwbyvnsdhihwta8cpr` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK98byvs8ghuojf31pv1ajiihmo` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`pet_id`),
  CONSTRAINT `FKghwsjbjo7mg3iufxruvq6iu3q` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `FKku8o00dhcb2b156anh1x26csc` FOREIGN KEY (`discount_id`) REFERENCES `discounts` (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'https://i.pinimg.com/564x/e7/63/ee/e763ee1268743e92ec3a23c7f0d1eb0e.jpg',NULL,NULL,NULL,NULL),(2,'https://img-cdn.xemgame.com/2023/07/11/mai-sakurajima-rascal-does-not-dream-of-bunny-girl-senpai.gif',NULL,NULL,NULL,NULL),(3,'https://scitecvietnam.vn/wp-content/uploads/2022/11/scitec-nutrition-whey-professional-chocolate-hazelnut-2350-gram.jpg',NULL,NULL,NULL,NULL),(4,'https://scitecvietnam.vn/wp-content/uploads/2022/11/scitec-nutrition-whey-professional-chocolate-hazelnut-2350-gram.jpg',NULL,NULL,NULL,NULL),(5,'https://img-cdn.xemgame.com/2023/07/11/mai-sakurajima-rascal-does-not-dream-of-bunny-girl-senpai.gif',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-25 21:58:19
