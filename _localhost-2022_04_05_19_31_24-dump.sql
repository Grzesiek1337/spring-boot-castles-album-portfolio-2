-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: castles-database
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `castles`
--

DROP TABLE IF EXISTS `castles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `castles` (
  `id` bigint NOT NULL,
  `castle_description` varchar(255) DEFAULT NULL,
  `castle_location` varchar(255) DEFAULT NULL,
  `castle_name` varchar(255) DEFAULT NULL,
  `castle_year_of_build` int NOT NULL,
  `castle_main_photo_photo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmoxruse3tgvmh7qqa1e6kqhfc` (`castle_main_photo_photo_id`),
  CONSTRAINT `FKmoxruse3tgvmh7qqa1e6kqhfc` FOREIGN KEY (`castle_main_photo_photo_id`) REFERENCES `photos` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `castles`
--

LOCK TABLES `castles` WRITE;
/*!40000 ALTER TABLE `castles` DISABLE KEYS */;
INSERT INTO `castles` (`id`, `castle_description`, `castle_location`, `castle_name`, `castle_year_of_build`, `castle_main_photo_photo_id`) VALUES (40,'Test','Poland','Malbork Castle',1280,41),(42,'Test','Poland','Chojnik Castle',1350,43),(46,'Test','Poland','Pieskowa Skała Castle',1315,47),(48,'Test','Poland - Ujazd','Krzyżtopór Castle',1644,49);
/*!40000 ALTER TABLE `castles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES (50);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photos` (
  `photo_id` bigint NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `castle_id` bigint DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `FKr3dcdoriftl2y16oqna7fyl6x` (`castle_id`),
  CONSTRAINT `FKr3dcdoriftl2y16oqna7fyl6x` FOREIGN KEY (`castle_id`) REFERENCES `castles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
INSERT INTO `photos` (`photo_id`, `file_name`, `path`, `castle_id`) VALUES (41,'malbork1.jpg','/home/gm/Pulpit/castles-mvc/./src/main/resources/static/photos/',40),(43,'chojnik1.jpg','/home/gm/Pulpit/castles-mvc/./src/main/resources/static/photos/',42),(47,'19-pieskowa-skala_original.jpg','/home/gm/Pulpit/castles-mvc/./src/main/resources/static/photos/',46),(49,'krzytoporcastle.jpg','/home/gm/Pulpit/castles-mvc/./src/main/resources/static/photos/',48);
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-05 19:31:24
