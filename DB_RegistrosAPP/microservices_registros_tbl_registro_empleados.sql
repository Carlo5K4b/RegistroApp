-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: microservices_registros
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `tbl_registro_empleados`
--

DROP TABLE IF EXISTS `tbl_registro_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_registro_empleados` (
  `numero_identificacion` varchar(255) NOT NULL,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_horar` varchar(255) DEFAULT NULL,
  `fecha_ingreso` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `otros_nombres` varchar(255) DEFAULT NULL,
  `id_pais` bigint NOT NULL,
  `id_dominio` bigint NOT NULL,
  `id_area` bigint DEFAULT NULL,
  `id_tipo` bigint DEFAULT NULL,
  PRIMARY KEY (`numero_identificacion`),
  KEY `FKlmmi0hc6au7guukpes8yi3j0f` (`id_area`),
  KEY `FK3lqqo5e9s88lckp4we5orvaso` (`id_tipo`),
  CONSTRAINT `FK3lqqo5e9s88lckp4we5orvaso` FOREIGN KEY (`id_tipo`) REFERENCES `tbl_tipo_identificacion` (`id`),
  CONSTRAINT `FKlmmi0hc6au7guukpes8yi3j0f` FOREIGN KEY (`id_area`) REFERENCES `tbl_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registro_empleados`
--

LOCK TABLES `tbl_registro_empleados` WRITE;
/*!40000 ALTER TABLE `tbl_registro_empleados` DISABLE KEYS */;
INSERT INTO `tbl_registro_empleados` VALUES ('111KB','BELTRAN','R','CARLOSBELTRAN','ACTIVO','2025-07-02 7:00','2025-06-27','CARLOS','AAAAAAA',0,0,NULL,NULL);
/*!40000 ALTER TABLE `tbl_registro_empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-01 10:53:43
