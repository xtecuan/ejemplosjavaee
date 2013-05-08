-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.30-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema paises
--

CREATE DATABASE IF NOT EXISTS paises;
USE paises;

--
-- Definition of table `paises`.`countries`
--

DROP TABLE IF EXISTS `paises`.`countries`;
CREATE TABLE  `paises`.`countries` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `region_id` int(11) NOT NULL,
  PRIMARY KEY (`country_id`),
  KEY `region_id` (`region_id`),
  KEY `region_id_2` (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `paises`.`countries`
--

/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
LOCK TABLES `countries` WRITE;
INSERT INTO `paises`.`countries` VALUES  (1,'El Salvador',2),
 (2,'Guatemala',2),
 (3,'U.S.A',1),
 (4,'El Salvador',2),
 (5,'Guatemala',2),
 (6,'U.S.A',1),
 (7,'CANADA',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;


--
-- Definition of table `paises`.`regions`
--

DROP TABLE IF EXISTS `paises`.`regions`;
CREATE TABLE  `paises`.`regions` (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`region_id`),
  KEY `region_id` (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `paises`.`regions`
--

/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
LOCK TABLES `regions` WRITE;
INSERT INTO `paises`.`regions` VALUES  (1,'Norte America'),
 (2,'Centro America'),
 (3,'Sur America'),
 (4,'Europa');
UNLOCK TABLES;
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
