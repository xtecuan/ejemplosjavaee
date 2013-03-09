/*
 Navicat MySQL Data Transfer

 Source Server         : alumnos
 Source Server Version : 50527
 Source Host           : localhost
 Source Database       : alumnos

 Target Server Version : 50527
 File Encoding         : utf-8

 Date: 03/09/2013 11:51:24 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `alumnos`
-- ----------------------------
DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carnet` varchar(10) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `fechanac` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `alumnos`
-- ----------------------------
BEGIN;
INSERT INTO `alumnos` VALUES ('1', 'RP95003500', 'Julian Tadeo', 'Rivera Pineda', 'xtecuan@gmail.com', '1976-11-04'), ('2', 'RP95003600', 'Julio Adalberto', 'Rivera Pineda', 'juliux@gmail.com', '1978-01-16'), ('3', 'RP950037', 'Jonatan', 'Rivera Pineda', 'kingofkings1982@live.com', null), ('4', 'HP0001', 'Amanda Elizabeth', 'Hernandez Rivera', 'amandadepaz@gmail.com', '1980-11-13'), ('7', 'ER7890', 'JUlio jandre ', 'Jandre', 'sjobs@apple.com', null), ('8', 'ER890735', 'Ramon', 'Valdez', 'donramon@gmail.com', '1946-02-23'), ('10', 'ER23456784', 'Pablo', 'Marmol', 'pmarmol@gmail.com', null), ('11', 'AH34567890', 'Fulanita1', 'De Tal', 'fulanita@yahoo.com', '1985-11-22'), ('12', 'SE12345678', 'Francisco', 'Gavidia', 'fgavidia@ufg.edu.sv', '1934-06-16'), ('14', 'WE34567800', 'Clark', 'Kent', 'ckent@gmail.com', '1976-11-05'), ('15', 'DF55555555', 'Dumbo', 'El Elefante', 'dumbo@orejas.com', '1950-07-08'), ('18', 'RHJUFERIHE', 'Julian Fernando', 'Rivera Hernandez', 'jfrivera@gmail.com', '2010-01-27'), ('21', 'AB12345678', 'Mario Alexander', 'Alvarado Bernal', 'mario.aalvaradob@gmail.com', '1989-03-20'), ('22', '654564', 'Erick samael', 'Hernandez', 'boxout@hotmail.es', '0089-03-01'), ('80', 'smis018908', 'FATIMA', 'AMAYA', 'fatiamaya_2006@hotmail.com', '2013-02-13'), ('81', 'smis012308', 'NIDIA', 'TORRES', 'torres_mn@gmail.com', '2013-02-15');
COMMIT;

-- ----------------------------
--  Table structure for `detalles_alumno`
-- ----------------------------
DROP TABLE IF EXISTS `detalles_alumno`;
CREATE TABLE `detalles_alumno` (
  `direccion` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  KEY `genero` (`genero`),
  KEY `genero_2` (`genero`),
  CONSTRAINT `detalles_alumno_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `detalles_alumno` (`genero`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `usuario`
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `usuario`
-- ----------------------------
BEGIN;
INSERT INTO `usuario` VALUES ('1', 'xtecuan', 'welcome1'), ('2', 'admin', 'welcome1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
