-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.27-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema infopais
--

CREATE DATABASE IF NOT EXISTS infopais;
USE infopais;

--
-- Definition of table `infopais`.`departamentos`
--

DROP TABLE IF EXISTS `infopais`.`departamentos`;
CREATE TABLE  `infopais`.`departamentos` (
  `id_depto` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id depto.',
  `abreviatura` varchar(5) NOT NULL COMMENT 'Abrev. depto.',
  `nombre_depto` varchar(35) NOT NULL COMMENT 'Nom. depto',
  PRIMARY KEY (`id_depto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='Tabla de departamentos';

--
-- Dumping data for table `infopais`.`departamentos`
--

/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
LOCK TABLES `departamentos` WRITE;
INSERT INTO `infopais`.`departamentos` VALUES  (1,'AHU','Ahuachapan'),
 (2,'SANA','Santa Ana'),
 (3,'SON','Sonsonate'),
 (4,'LIB','La Libertad'),
 (5,'SS','San Salvador'),
 (6,'CHA','Chalatenango'),
 (7,'CUS','Cuscatlan'),
 (8,'PAZ','La Paz'),
 (9,'CAB','Cabañas'),
 (10,'SANV','San Vicente'),
 (11,'USU','Usulutan'),
 (12,'SANM','San Miguel'),
 (13,'MOR','Morazan'),
 (14,'LUN','La Union'),
 (15,'USA','USA');
UNLOCK TABLES;
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;


--
-- Definition of table `infopais`.`municipios`
--

DROP TABLE IF EXISTS `infopais`.`municipios`;
CREATE TABLE  `infopais`.`municipios` (
  `id_muni` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id muni',
  `nombre_muni` varchar(50) NOT NULL COMMENT 'Nom Muni',
  `id_depto` int(11) NOT NULL COMMENT 'Id depto',
  `cabecera` int(11) NOT NULL DEFAULT '0' COMMENT '0-No 1-SI',
  PRIMARY KEY (`id_muni`),
  KEY `fk_deptos` (`id_depto`),
  CONSTRAINT `fk_deptos` FOREIGN KEY (`id_depto`) REFERENCES `departamentos` (`id_depto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Municipios de un pais';

--
-- Dumping data for table `infopais`.`municipios`
--

/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
LOCK TABLES `municipios` WRITE;
INSERT INTO `infopais`.`municipios` VALUES  (1,'San Salvador',5,1),
 (2,'Soyapango',5,0),
 (3,'Delgado',5,0),
 (4,'San Martin',5,0),
 (5,'Mejicanos',5,0),
 (6,'Santa Tecla',4,0),
 (7,'Lourdes',4,0),
 (8,'El congo',2,0),
 (9,'Concepción de Ataco',1,0),
 (10,'Apaneca',1,0),
 (11,'Ahuchapan',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
