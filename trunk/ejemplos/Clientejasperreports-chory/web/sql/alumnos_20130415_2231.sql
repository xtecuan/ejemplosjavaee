-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.30-MariaDB-log


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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alumnos`.`alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
LOCK TABLES `alumnos` WRITE;
INSERT INTO `alumnos`.`alumnos` VALUES  (1,'RP95003500','Julian Tadeo','Rivera Pineda','xtecuan@gmail.com','1976-11-05'),
 (2,'RP95003600','Julio Adalberto','Rivera Pineda','juliux@gmail.com','1978-01-16'),
 (3,'RP95003700','Jonatan','Rivera Pineda','kingofkings1982@live.com','1967-11-09'),
 (4,'1234567890','Amanda Elizabeth','Hernandez Rivera','amandadepaz@gmail.com','1980-11-13');
UNLOCK TABLES;
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;


--
-- Definition of table `alumnos`.`detalles_alumno`
--

DROP TABLE IF EXISTS `alumnos`.`detalles_alumno`;
CREATE TABLE  `alumnos`.`detalles_alumno` (
  `direccion` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  KEY `genero` (`genero`),
  KEY `genero_2` (`genero`),
  CONSTRAINT `detalles_alumno_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `detalles_alumno` (`genero`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumnos`.`detalles_alumno`
--

/*!40000 ALTER TABLE `detalles_alumno` DISABLE KEYS */;
LOCK TABLES `detalles_alumno` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `detalles_alumno` ENABLE KEYS */;


--
-- Definition of table `alumnos`.`usuario`
--

DROP TABLE IF EXISTS `alumnos`.`usuario`;
CREATE TABLE  `alumnos`.`usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumnos`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
INSERT INTO `alumnos`.`usuario` VALUES  (1,'xtecuan','welcome1'),
 (2,'admin','welcome1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
