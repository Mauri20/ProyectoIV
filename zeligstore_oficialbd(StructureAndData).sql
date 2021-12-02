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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estilos`
--

LOCK TABLES `estilos` WRITE;
/*!40000 ALTER TABLE `estilos` DISABLE KEYS */;
INSERT INTO `estilos` VALUES (1,'Running'),(2,'Basketball'),(3,'Football'),(4,'Soccer'),(5,'Training & Gym'),(6,'Skateboarding'),(7,'Baseball'),(8,'Golf'),(9,'Tennis'),(10,'Walking'),(11,'Track & Field'),(12,'Sandals & Slides');
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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelos`
--

LOCK TABLES `modelos` WRITE;
/*!40000 ALTER TABLE `modelos` DISABLE KEYS */;
INSERT INTO `modelos` VALUES (1,'PW-RusticFlower',3),(2,'PM-Intense',3),(3,'PK-ClearPink',3),(4,'PK-WaveBlue',3),(5,'PW-SandalsWinter',3),(6,'PK-BlueSky',3),(7,'PM-FitPlay',3),(8,'PK-OceanGalaxy',3),(9,'AW-WinterHold',2),(10,'AK-WalkingEve',2),(11,'AM-BlackPlanet',2),(12,'AK-OceanWay',2),(13,'AW-GalaxyFound',2),(14,'AK-KidsStyle',2),(15,'AM-FitnessSmart',2),(16,'AK-FootField',2),(17,'CW-SoldierWoman',4),(18,'CK-HeartBeats',4),(19,'CM-BasicStars',4),(20,'CK-KidsFancy',4),(21,'CW-WayHome',4),(22,'CK-WonderfulKids',4),(23,'CK-StudentsWay',4),(24,'CK-FormalFancy',4),(25,'NW-PinkGrateful',1),(26,'NK-PaintPink',1),(27,'NM-NaturalBlank',1),(28,'NK-FancyLittle',1),(29,'NW-FlagsGray',1),(30,'NK-PurpleSpace',1),(31,'NM-SoldierMan',1),(32,'NK-PowerfulRed',1),(33,'RW-GalaxyPink',5),(34,'RW-Sunshine',5),(35,'RM-Runaways',5),(36,'RK-SkyBlue',5),(37,'RW-QuestionMid',5),(38,'RK-NanoX1',5),(39,'RM-ZigWild',5),(40,'RK-FloatRide',5),(41,'VW-OldSkool',6),(42,'VK-Authentic',6),(43,'VM-PigSuede59',6),(44,'VK-KidsSK8-Mid',6),(45,'VW-ScottSurff',6),(46,'VK-ToddlerUnicorn',6),(47,'VM-SK8-Hi',6),(48,'VK-ReIssue',6);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Andrés Córdova','6789-7654','cordova','1234',1),(2,'Mauricio Rosa','7865-5678','mauri','1234',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zapatos`
--

LOCK TABLES `zapatos` WRITE;
/*!40000 ALTER TABLE `zapatos` DISABLE KEYS */;
INSERT INTO `zapatos` VALUES (1,10.00,'Rosado y Negro',109.99,'src//main//resources//static/images/PW-RusticFlower.jpg',1,1,5),(2,9.50,'Negros',99.99,'src//main//resources//static/images/PM-Intense.jpg',3,2,1),(3,5.00,'Rosado',72.99,'src//main//resources//static/images/PK-ClearPink.jpg',2,3,10),(4,5.00,'Blanco',56.99,'src//main//resources//static/images/PK-WaveBlue.jpg',4,4,11),(5,9.00,'Rosada',34.99,'src//main//resources//static/images/PW-SandalsWinter.jpg',1,5,12),(6,5.20,'Azul con Blanco',65.99,'src//main//resources//static/images/PK-BlueSky.jpg',2,6,9),(7,9.00,'Multi-Color',67.99,'src//main//resources//static/images/PM-FitPlay.jpg',3,7,5),(8,4.00,'Azul',78.99,'src//main//resources//static/images/PK-OceanGalaxy.jpg',4,8,1),(9,9.00,'Beige',89.45,'src//main//resources//static/images/AW-WinterHold.jpg',1,9,11),(10,4.50,'Rosado',56.99,'src//main//resources//static/images/AK-WalkingEve.jpg',2,10,10),(11,10.00,'Negro y Blanco',99.99,'src//main//resources//static/images/AM-BlackPlanet.jpg',3,11,2),(12,4.50,'Blancos',78.99,'src//main//resources//static/images/AK-OceanWay.jpg',4,12,10),(13,10.00,'Rosado',109.99,'src//main//resources//static/images/AW-GalaxyFound.jpg',1,13,5),(14,4.00,'Blanco',89.99,'src//main//resources//static/images/AK-KidsStyle.jpg',2,14,1),(15,8.60,'Multi-Color',100.99,'src//main//resources//static/images/AM-FitnessSmart.jpg',3,15,5),(16,4.80,'Negro',67.99,'src//main//resources//static/images/AK-FootField.jpg',4,16,11),(17,9.00,'Blanco/Rosado',78.99,'src//main//resources//static/images/CW-SoldierWoman.jpg',1,17,11),(18,4.50,'Blanco decorado',67.99,'src//main//resources//static/images/CK-HeartBeats.jpg',2,18,11),(19,11.00,'Negro',89.99,'src//main//resources//static/images/CM-BasicStars.jpg',3,19,11),(20,5.00,'Negro',56.95,'src//main//resources//static/images/CK-KidsFancy.jpg',4,20,10),(21,8.90,'Beige/Rosado',78.99,'src//main//resources//static/images/CW-WayHome.jpg',1,21,11),(22,6.00,'Rosado',78.99,'src//main//resources//static/images/CK-WonderfulKids.jpg',2,22,11),(23,9.00,'Gris/Blanco/Naranja',89.99,'src//main//resources//static/images/CK-StudentsWay.jpg',3,23,11),(24,4.00,'Café/Amarillo',67.99,'src//main//resources//static/images/CK-FormalFancy.jpg',4,24,11),(25,9.50,'Rosado/Blanco',89.99,'src//main//resources//static/images/NW-PinkGrateful.jpg',1,25,10),(26,4.70,'Rosado',45.99,'src//main//resources//static/images/NK-PaintPink.jpg',2,26,10),(27,7.90,'Negro/Blanco',78.99,'src//main//resources//static/images/NM-NaturalBlank.jpg',3,27,9),(28,5.00,'Gris/Blanco',67.88,'src//main//resources//static/images/NK-FancyLittle.jpg',4,28,1),(29,9.00,'Blanco/Salmón',99.99,'src//main//resources//static/images/NW-FlagsGray.jpg',1,29,11),(30,5.00,'Morado/Blanco/Amarillo',56.99,'src//main//resources//static/images/NK-PurpleSpace.jpg',2,30,11),(31,11.00,'Negro',120.25,'src//main//resources//static/images/NM-SoldierMan.jpg',3,31,5),(32,6.00,'Rojo/Negro/Blanco',78.99,'src//main//resources//static/images/NK-PowerfulRed.jpg',4,32,9),(33,8.90,'Rosado/Blanco',89.75,'src//main//resources//static/images/RW-GalaxyPink.jpg',1,33,5),(34,5.00,'Rosado/Rojo/Amarillo',67.99,'src//main//resources//static/images/RW-Sunshine.jpg',2,34,9),(35,9.50,'Multi-Color',190.99,'src//main//resources//static/images/RM-Runaways.jpg',3,35,2),(36,4.00,'Azul',56.99,'src//main//resources//static/images/RK-SkyBlue.jpg',4,36,10),(37,12.00,'Rosado',120.00,'src//main//resources//static/images/RW-QuestionMid.jpg',1,37,2),(38,7.00,'Rosado',89.99,'src//main//resources//static/images/RK-NanoX1.jpg',2,38,10),(39,9.00,'Blanco',96.99,'src//main//resources//static/images/RM-ZigWild.jpg',3,39,1),(40,5.00,'Gris/Verde/Blanco',89.95,'src//main//resources//static/images/RK-FloatRide.jpg',4,40,1),(41,10.00,'Rosado/Negro',90.99,'src//main//resources//static/images/VW-OldSkool.jpg',1,41,10),(42,6.00,'Multi-Color',57.14,'src//main//resources//static/images/VK-Authentic.jpg',2,42,10),(43,11.00,'Negro/Blanco',100.00,'src//main//resources//static/images/VM-PigSuede59.jpg',3,43,8),(44,4.00,'Negro/Blanco',50.00,'src//main//resources//static/images/VK-KidsSK8-Mid.jpg',4,44,11),(45,12.00,'Rosado brillante',78.95,'src//main//resources//static/images/VW-ScottSurff.jpg',1,45,10),(46,6.00,'Multi-Color',45.00,'src//main//resources//static/images/VK-ToddlerUnicorn.png',2,46,11),(47,9.00,'Azul/Blanco/Negro',78.90,'src//main//resources//static/images/VM-SK8-Hi.jpg',3,47,10),(48,4.00,'Café/Gris',78.99,'src//main//resources//static/images/VK-ReIssue.jpg',4,48,10);
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

-- Dump completed on 2021-12-01 18:39:14
