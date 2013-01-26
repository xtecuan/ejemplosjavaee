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
-- Create schema alumnos
--

CREATE DATABASE IF NOT EXISTS alumnos;
USE alumnos;

--
-- Definition of table `alumnos`.`alumnos`
--

DROP TABLE IF EXISTS `alumnos`.`alumnos`;
CREATE TABLE  `alumnos`.`alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carnet` varchar(10) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `fechanac` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alumnos`.`alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
LOCK TABLES `alumnos` WRITE;
INSERT INTO `alumnos`.`alumnos` VALUES  (1,'RP95003500','Julian Tadeomarcos','Rivera Pineda','xtecuan@gmail.com','1976-11-04'),
 (2,'RP95003600','Julio Adalberto','Rivera Pineda','juliux@gmail.com','1978-01-16'),
 (3,'RP950037','Jonatan','Rivera Pineda','kingofkings1982@live.com',NULL),
 (4,'HP0001','Amanda Elizabeth','Hernandez Rivera','amandadepaz@gmail.com','1980-11-13'),
 (7,'ER7890','JUlio jandre ','GAy','sjobs@apple.com',NULL),
 (8,'ER890735','Ramon','Valdez','donramon@gmail.com','1946-02-23'),
 (10,'ER23456784','Pablo','Marmol','pmarmol@gmail.com',NULL),
 (11,'AH34567890','Fulanita1','De Tal','fulanita@yahoo.com','1985-11-22'),
 (12,'SE12345678','Francisco','Gavidia','fgavidia@ufg.edu.sv','1934-06-16'),
 (14,'WE34567800','Clark','Kent','ckent@gmail.com','1976-11-05'),
 (15,'DF55555555','Dumbo','El Elefante','dumbo@orejas.com','1950-07-08'),
 (18,'RHJUFERIHE','Julian Fernando','Rivera Hernandez','jfrivera@gmail.com','2010-01-27'),
 (21,'AB12345678','Mario Alexander','Alvarado Bernal','mario.aalvaradob@gmail.com','1989-03-20'),
 (22,'654564','Erick samael','Hernandez','boxout@hotmail.es','0089-03-01');
UNLOCK TABLES;
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
