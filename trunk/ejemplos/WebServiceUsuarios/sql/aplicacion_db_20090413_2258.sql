-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-24


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema aplicacion
--

CREATE DATABASE IF NOT EXISTS aplicacion;
grant all privileges on aplicacion.* to 'aplicacion'@'localhost' identified by 'welcome1';
USE aplicacion;

--
-- Definition of table `aplicacion`.`ALUMNOS`
--

DROP TABLE IF EXISTS `aplicacion`.`ALUMNOS`;
CREATE TABLE  `aplicacion`.`ALUMNOS` (
  `CODIGOA` varchar(8) NOT NULL,
  `NOMBRE` varchar(60) default NULL,
  `DIRECCION` varchar(60) default NULL,
  `TELE` varchar(10) default NULL,
  `SEXO` varchar(1) default NULL,
  `CODIGOC` varchar(8) default NULL,
  PRIMARY KEY  (`CODIGOA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aplicacion`.`ALUMNOS`
--

/*!40000 ALTER TABLE `ALUMNOS` DISABLE KEYS */;
LOCK TABLES `ALUMNOS` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `ALUMNOS` ENABLE KEYS */;


--
-- Definition of table `aplicacion`.`maestro_equipos`
--

DROP TABLE IF EXISTS `aplicacion`.`maestro_equipos`;
CREATE TABLE  `aplicacion`.`maestro_equipos` (
  `cod_equipo` smallint(6) NOT NULL,
  `marca` varchar(100) default NULL,
  `modelo` varchar(100) default NULL,
  `cod_inventario` smallint(6) default NULL,
  `serie` varchar(100) default NULL,
  `cod_departamento` smallint(6) default NULL,
  `cod_ubicacion` smallint(6) default NULL,
  `fecha_ingreso` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `fecha_caducidad` timestamp NOT NULL default '0000-00-00 00:00:00',
  `cod_clase` smallint(6) default NULL,
  `cod_tipo_equipo` smallint(6) default NULL,
  PRIMARY KEY  (`cod_equipo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aplicacion`.`maestro_equipos`
--

/*!40000 ALTER TABLE `maestro_equipos` DISABLE KEYS */;
LOCK TABLES `maestro_equipos` WRITE;
INSERT INTO `aplicacion`.`maestro_equipos` VALUES  (1,'Dell','Latitude D820',1,'XXXX-0001',1,1,'2009-04-08 02:03:02','2009-11-05 00:00:00',1,1),
 (2,'Dell','Desktop',2,'XXXX-0002',1,1,'2009-04-08 02:04:06','2009-11-05 00:00:00',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `maestro_equipos` ENABLE KEYS */;


--
-- Definition of table `aplicacion`.`usuario`
--

DROP TABLE IF EXISTS `aplicacion`.`usuario`;
CREATE TABLE  `aplicacion`.`usuario` (
  `usuario` varchar(25) NOT NULL,
  `clave` varchar(150) NOT NULL,
  `nombres` varchar(150) default NULL,
  `apellidos` varchar(150) default NULL,
  `correo` varchar(150) NOT NULL,
  `estaadentro` smallint(6) default '0',
  `ultimoLogin` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aplicacion`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
INSERT INTO `aplicacion`.`usuario` VALUES  ('mandy','123456','Amanda Elizabeth','Hernandez Rivera','amandadepaz@gmail.com',0,'2009-04-13 22:58:00'),
 ('julian.rivera','123456','Julian','Rivera Pineda','julian.riverapineda@gmail.com',0,'2009-04-13 22:58:00'),
 ('xtecuan','admin','Julian Tadeo','Rivera Pineda','xtecuan@gmail.com',0,'2009-04-13 22:58:00'),
 ('test','test','test','test','tadeo@gmail.com',0,'2009-04-13 00:00:00');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
