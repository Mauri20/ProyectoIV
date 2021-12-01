CREATE DATABASE  IF NOT EXISTS `zeligstorebd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zeligstorebd`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: zeligstorebd
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombreCat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Mujer'),(2,'Niña'),(3,'Hombre'),(4,'Niño');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estilos`
--

DROP TABLE IF EXISTS `estilos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estilos` (
  `idEstilo` int NOT NULL AUTO_INCREMENT,
  `nombreEst` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEstilo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estilos`
--

LOCK TABLES `estilos` WRITE;
/*!40000 ALTER TABLE `estilos` DISABLE KEYS */;
INSERT INTO `estilos` VALUES (1,'Jordan'),(2,'Running'),(3,'Basketball'),(4,'Football'),(5,'Soccer'),(6,'Training & Gym\n'),(7,'Skateboarding'),(8,'Baseball'),(9,'Golf'),(10,'Tennis'),(11,'Walking'),(12,'Track & Field\n'),(13,'Sandals & Slides');
/*!40000 ALTER TABLE `estilos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `idMarca` int NOT NULL AUTO_INCREMENT,
  `nombreMar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Nike'),(2,'Adidas'),(3,'Puma'),(4,'Converse'),(5,'Reebook'),(6,'Vans');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelos`
--

DROP TABLE IF EXISTS `modelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelos` (
  `idModelo` int NOT NULL AUTO_INCREMENT,
  `nombreMod` varchar(50) DEFAULT NULL,
  `idMarca` int DEFAULT NULL,
  PRIMARY KEY (`idModelo`),
  KEY `fk_modelo_marca` (`idMarca`),
  CONSTRAINT `fk_modelo_marca` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`idMarca`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelos`
--

LOCK TABLES `modelos` WRITE;
/*!40000 ALTER TABLE `modelos` DISABLE KEYS */;
INSERT INTO `modelos` VALUES (32,'R-Junior',5),(33,'R-Deportive',5),(34,'RM-Soldiers',5),(35,'RW-Champions',5),(36,'R-Stars',5),(37,'R-Astronauts',5),(38,'RM-Galaxy',5),(39,'RW-Naturals',5),(40,'V-MagicPink',6),(41,'VM-FancyBlue',6),(42,'VW-Roustic',6),(43,'V-Intense',6),(44,'V-Flowers',6),(45,'V-WarmRed',6),(46,'VW-TruckPink',6),(47,'RM-CasualShoes',6);
/*!40000 ALTER TABLE `modelos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `tipousuario` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Andres Eduardo','79677324','cordova','1234',1),(6,'Mauricio Rosa','7878-6531','mauri','1234',0),(15,'Jasmin Robles','1234-1234','Jas','1234',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zapatos`
--

DROP TABLE IF EXISTS `zapatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zapatos` (
  `idZapato` int NOT NULL AUTO_INCREMENT,
  `talla` decimal(4,2) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `idCategoria` int DEFAULT NULL,
  `idModelo` int DEFAULT NULL,
  `idEstilo` int DEFAULT NULL,
  PRIMARY KEY (`idZapato`),
  KEY `id_zapatos_estilo` (`idEstilo`),
  KEY `id_zapatos_marcas` (`idModelo`),
  KEY `id_zapatos_categorias` (`idCategoria`),
  CONSTRAINT `fk_zapatos_modelo` FOREIGN KEY (`idModelo`) REFERENCES `modelos` (`idModelo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_zapatos_categorias` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_zapatos_estilo` FOREIGN KEY (`idEstilo`) REFERENCES `estilos` (`idEstilo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zapatos`
--

LOCK TABLES `zapatos` WRITE;
/*!40000 ALTER TABLE `zapatos` DISABLE KEYS */;
INSERT INTO `zapatos` VALUES (47,5.00,'Amarillo',45.78,'src//main//resources//static/images/R-Junior.jpg',4,32,10),(48,4.00,'Rosado',30.99,'src//main//resources//static/images/R-Deportive.jpg',2,33,10),(49,9.00,'Multi-Color',89.99,'src//main//resources//static/images/RM-Soldiers.jpg',3,34,6),(50,7.00,'Salmón',67.99,'src//main//resources//static/images/RW-Champions.jpg',1,35,2),(51,5.00,'Blanco',67.88,'src//main//resources//static/images/R-Stars.jpg',2,36,12),(52,6.00,'Gris',90.99,'src//main//resources//static/images/R-Astronauts.jpg',4,37,4),(53,8.00,'Negro',100.00,'src//main//resources//static/images/RM-Galaxy.jpg',3,38,12),(54,9.00,'Rosado',99.99,'src//main//resources//static/images/RW-Naturals.jpg',1,39,11),(55,7.00,'Rosado',99.78,'src//main//resources//static/images/V-MagicPink.jpg',2,40,12),(56,9.60,'Azul',120.00,'src//main//resources//static/images/VM-FancyBlue.jpg',3,41,12),(57,7.00,'MultiColor',119.99,'src//main//resources//static/images/VW-Roustic.jpg',1,42,10),(58,5.00,'Negro',78.88,'src//main//resources//static/images/V-Intense.jpg',4,43,4),(59,7.00,'Varios',56.14,'src//main//resources//static/images/V-Flowers.jpg',2,44,2),(60,6.00,'Rojo',45.89,'src//main//resources//static/images/V-WarmRed.jpg',4,45,11),(61,8.00,'Rosado',126.90,'src//main//resources//static/images/VW-TruckPink.jpg',1,46,2),(62,9.00,'Gris',100.00,'src//main//resources//static/images/RM-CasualShoes.jpg',3,47,9);
/*!40000 ALTER TABLE `zapatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'zeligstorebd'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Zapatos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_d_Zapatos`(pIdZapato int)
BEGIN

	delete from zapatos where id=pIdZapato;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_e_Zapato` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_e_Zapato`(pIdZapato int,

pTalla decimal(4,2),

pColor varchar(40),

pPrecio decimal(5,2),

pUrl varchar(200),

pIdCategoria int,

pIdModelo int,

pIdEstilo int)
BEGIN

	update zapatos set talla=pTalla,color=pColor,precio=pPrecio,url=pUrl,idCategoria=pIdCategoria,idModelo=pIdModelo, idEstilo=pIdEstilo where idZapato=pIdZapato;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Zapatos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_i_Zapatos`(



pModelo VARCHAR(45),



pTalla decimal(4,2),



pColor varchar(40),



pPrecio decimal(5,2),



pUrl varchar(200),



pIdCategoria int,



pIdMarca int,



pIdEstilo int)
BEGIN



START TRANSACTION;



INSERT INTO modelos(nombreMod,idMarca) VALUES (pModelo,pIdMarca);



INSERT INTO zapatos(talla,color,precio,url,idCategoria,idModelo,idEstilo) VALUES(

	pTalla,pColor,pPrecio,pUrl,pIdCategoria,LAST_INSERT_ID(),pIdEstilo

);



COMMIT;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_LoginApp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LoginApp`(PUsuario varchar(100), PPassword varchar(100))
BEGIN

SELECT * FROM zeligstorebd.usuarios where usuario=PUsuario and contrasena=PPassword;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_s_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_s_usuario`(pUsuario varchar(50))
BEGIN

	select * from usuarios where usuario=pUsuario;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_s_Zapatos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_s_Zapatos`(pMarca VARCHAR(50))
BEGIN

	Select a.idZapato,a.idCategoria,a.idModelo, a.idEstilo, a.url,c.nombreMod as modelo,d.nombreMar as marca, e.nombreEst as estilo,a.talla,a.color,a.precio,b.nombreCat as categoria from zapatos as a inner join categorias as b on a.idCategoria=b.idCategoria inner join modelos as c on a.idModelo=c.idModelo inner join marcas as d on c.idMarca=d.idMarca inner join estilos as e on a.idEstilo=e.idEstilo WHERE d.nombreMar=pMarca;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_s_ZapatosCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_s_ZapatosCategoria`(pCategoria varchar(50),

pMarca varchar(50))
BEGIN

Select a.idZapato,a.idCategoria,a.idModelo, a.idEstilo, a.url,c.nombreMod as modelo,d.nombreMar as marca, e.nombreEst as estilo,a.talla,a.color,a.precio,b.nombreCat as categoria from zapatos as a inner join categorias as b on a.idCategoria=b.idCategoria inner join modelos as c on a.idModelo=c.idModelo inner join marcas as d on c.idMarca=d.idMarca inner join estilos as e on a.idEstilo=e.idEstilo where b.nombreCat=pCategoria AND d.nombreMar=pMarca;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-30 23:09:44
