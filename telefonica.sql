-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: telefonica
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(250) DEFAULT NULL,
  `id_tipo_documento` int DEFAULT NULL,
  `nro_documento` int DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_tipo_documento` (`id_tipo_documento`),
  CONSTRAINT `fk_cliente_tipo_documento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Ejemplo 1',1,99999999,'2000-05-18 00:00:00'),(2,'Ejemplo 2',1,99999998,'2000-01-25 00:00:00'),(3,'Ejemplo 3',2,45454545,'1990-01-25 00:00:00');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_movil`
--

DROP TABLE IF EXISTS `cliente_movil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_movil` (
  `id_cliente` int NOT NULL,
  `id_linea_movil` int NOT NULL,
  `id_cliente_movil` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_cliente_movil`),
  KEY `idx_cliente_movil` (`id_cliente_movil`),
  KEY `fk_cliente_movil` (`id_linea_movil`),
  KEY `fk_cliente_movil_1` (`id_cliente`),
  CONSTRAINT `fk_cliente_movil` FOREIGN KEY (`id_linea_movil`) REFERENCES `linea_movil` (`id_linea_movil`),
  CONSTRAINT `fk_cliente_movil_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_movil`
--

LOCK TABLES `cliente_movil` WRITE;
/*!40000 ALTER TABLE `cliente_movil` DISABLE KEYS */;
INSERT INTO `cliente_movil` VALUES (1,1,1),(1,2,2),(2,3,3),(2,4,4),(3,5,5),(3,6,6);
/*!40000 ALTER TABLE `cliente_movil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Activo'),(2,'Cancelado');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
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
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea_movil`
--

DROP TABLE IF EXISTS `linea_movil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linea_movil` (
  `id_linea_movil` int NOT NULL AUTO_INCREMENT,
  `nro_telefono` int DEFAULT NULL,
  `id_estado` int DEFAULT NULL,
  `id_tipo` int DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  PRIMARY KEY (`id_linea_movil`),
  KEY `fk_linea_movil` (`id_tipo`),
  KEY `fk_linea_movil_0` (`id_estado`),
  KEY `fk_linea_movil_1` (`id_plan`),
  CONSTRAINT `fk_linea_movil` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id_tipo`),
  CONSTRAINT `fk_linea_movil_0` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `fk_linea_movil_1` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_movil`
--

LOCK TABLES `linea_movil` WRITE;
/*!40000 ALTER TABLE `linea_movil` DISABLE KEYS */;
INSERT INTO `linea_movil` VALUES (1,984999999,1,1,2),(2,984999998,1,2,1),(3,984999997,2,1,3),(4,984999996,1,1,4),(5,984999995,1,1,5),(6,984999995,1,1,2);
/*!40000 ALTER TABLE `linea_movil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta` (
  `id_oferta` int NOT NULL AUTO_INCREMENT,
  `descripcion` mediumtext,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id_oferta`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` VALUES (1,'oferta 1','2022-05-01','2022-05-31'),(2,'oferta 2','2022-05-01','2022-05-31'),(3,'oferta 3','2022-05-01','2022-05-31'),(4,'oferta 4','2022-04-01','2022-04-30'),(5,'oferta 5','2022-04-01','2022-04-30'),(6,'oferta 6','2022-04-01','2022-04-30'),(7,'oferta 7','2022-05-01','2022-06-30');
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta_movil`
--

DROP TABLE IF EXISTS `oferta_movil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta_movil` (
  `id_oferta_movil` int NOT NULL AUTO_INCREMENT,
  `id_linea_movil` int NOT NULL,
  `id_oferta` int NOT NULL,
  PRIMARY KEY (`id_oferta_movil`),
  KEY `fk_oferta_movil` (`id_oferta`),
  KEY `fk_oferta_movil_0` (`id_linea_movil`),
  CONSTRAINT `fk_oferta_movil` FOREIGN KEY (`id_oferta`) REFERENCES `oferta` (`id_oferta`),
  CONSTRAINT `fk_oferta_movil_0` FOREIGN KEY (`id_linea_movil`) REFERENCES `linea_movil` (`id_linea_movil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta_movil`
--

LOCK TABLES `oferta_movil` WRITE;
/*!40000 ALTER TABLE `oferta_movil` DISABLE KEYS */;
INSERT INTO `oferta_movil` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6);
/*!40000 ALTER TABLE `oferta_movil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'Plan Prepago'),(2,'Plan S/. 29.90'),(3,'Plan S/. 39.90'),(4,'Plan S/. 49.90'),(5,'Plan S/. 65.90');
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo` (
  `id_tipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Postpago'),(2,'Prepago');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `id_tipo_documento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'DNI'),(2,'Carne de extranjeria');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-10 19:17:11
