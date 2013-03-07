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
-- Create schema regciclistas
--

CREATE DATABASE IF NOT EXISTS regciclistas;
USE regciclistas;

grant all privileges on regciclistas.* to 'regciclistas'@'localhost' identified by 'welcome1';

--
-- Definition of table `regciclistas`.`bicicletas`
--

DROP TABLE IF EXISTS `regciclistas`.`bicicletas`;
CREATE TABLE  `regciclistas`.`bicicletas` (
  `idbici` int(10) NOT NULL AUTO_INCREMENT,
  `codmodelo` int(10) NOT NULL,
  `id_ciclista` int(10) NOT NULL,
  `desbici` varchar(25) DEFAULT NULL,
  `seriebici` varchar(35) NOT NULL,
  `color` varchar(25) NOT NULL,
  `observaciones` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idbici`),
  KEY `codmodelo` (`codmodelo`),
  KEY `id_ciclista` (`id_ciclista`),
  CONSTRAINT `fk_ciclistas_1` FOREIGN KEY (`id_ciclista`) REFERENCES `ciclistas` (`id_ciclista`),
  CONSTRAINT `fk_modelo_1` FOREIGN KEY (`codmodelo`) REFERENCES `cat_modelos` (`codmodelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regciclistas`.`bicicletas`
--

/*!40000 ALTER TABLE `bicicletas` DISABLE KEYS */;
LOCK TABLES `bicicletas` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `bicicletas` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`cat_departamentos`
--

DROP TABLE IF EXISTS `regciclistas`.`cat_departamentos`;
CREATE TABLE  `regciclistas`.`cat_departamentos` (
  `coddepto` int(11) NOT NULL DEFAULT '0',
  `desdepto` varchar(50) NOT NULL,
  `codpais` int(11) NOT NULL,
  PRIMARY KEY (`coddepto`),
  KEY `fk_pais_1` (`codpais`),
  CONSTRAINT `fk_pais_1` FOREIGN KEY (`codpais`) REFERENCES `cat_paises` (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla de departamentos';

--
-- Dumping data for table `regciclistas`.`cat_departamentos`
--

/*!40000 ALTER TABLE `cat_departamentos` DISABLE KEYS */;
LOCK TABLES `cat_departamentos` WRITE;
INSERT INTO `regciclistas`.`cat_departamentos` VALUES  (1,'AHUACHAPAN',4),
 (2,'SANTA ANA',4),
 (3,'SONSONATE',4),
 (4,'CHALATENANGO',4),
 (5,'LA LIBERTAD',4),
 (6,'SAN SALVADOR',4),
 (7,'CUSCATLAN',4),
 (8,'LA PAZ',4),
 (9,'CABAÑAS',4),
 (10,'SAN VICENTE',4),
 (11,'USULUTAN',4),
 (12,'SAN MIGUEL',4),
 (13,'MORAZAN',4),
 (14,'LA UNION',4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cat_departamentos` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`cat_marcas`
--

DROP TABLE IF EXISTS `regciclistas`.`cat_marcas`;
CREATE TABLE  `regciclistas`.`cat_marcas` (
  `codmarca` int(10) NOT NULL AUTO_INCREMENT,
  `desmarca` varchar(65) NOT NULL,
  PRIMARY KEY (`codmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='Tablas de marcas de equipos para ciclismo';

--
-- Dumping data for table `regciclistas`.`cat_marcas`
--

/*!40000 ALTER TABLE `cat_marcas` DISABLE KEYS */;
LOCK TABLES `cat_marcas` WRITE;
INSERT INTO `regciclistas`.`cat_marcas` VALUES  (1,'CORSARIO'),
 (2,'LYNX'),
 (3,'GIANT'),
 (4,'CHAMPION'),
 (5,'FUJI'),
 (6,'TREK');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cat_marcas` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`cat_modelos`
--

DROP TABLE IF EXISTS `regciclistas`.`cat_modelos`;
CREATE TABLE  `regciclistas`.`cat_modelos` (
  `codmodelo` int(10) NOT NULL AUTO_INCREMENT,
  `codmarca` int(10) DEFAULT NULL,
  `desmodelo` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`codmodelo`),
  KEY `codmarca` (`codmarca`),
  CONSTRAINT `fk_marca` FOREIGN KEY (`codmarca`) REFERENCES `cat_marcas` (`codmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regciclistas`.`cat_modelos`
--

/*!40000 ALTER TABLE `cat_modelos` DISABLE KEYS */;
LOCK TABLES `cat_modelos` WRITE;
INSERT INTO `regciclistas`.`cat_modelos` VALUES  (1,1,'LXMX');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cat_modelos` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`cat_municipios`
--

DROP TABLE IF EXISTS `regciclistas`.`cat_municipios`;
CREATE TABLE  `regciclistas`.`cat_municipios` (
  `codmuni` int(11) NOT NULL,
  `coddepto` int(11) NOT NULL,
  `desmuni` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codmuni`),
  KEY `fk_depto` (`coddepto`),
  CONSTRAINT `fk_depto` FOREIGN KEY (`coddepto`) REFERENCES `cat_departamentos` (`coddepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla Municipios';

--
-- Dumping data for table `regciclistas`.`cat_municipios`
--

/*!40000 ALTER TABLE `cat_municipios` DISABLE KEYS */;
LOCK TABLES `cat_municipios` WRITE;
INSERT INTO `regciclistas`.`cat_municipios` VALUES  (1,1,'AHUACHAPAN'),
 (2,1,'APANECA'),
 (3,1,'ATIQUIZAYA'),
 (4,1,'CONCEPCION DE ATACO'),
 (5,1,'EL REFUGIO'),
 (6,1,'GUAYMANGO'),
 (7,1,'JUJUTLA'),
 (8,1,'SAN FRANCISCO MENENDEZ'),
 (9,1,'SAN LORENZO'),
 (10,1,'SAN PEDRO PUXTLA'),
 (11,1,'TACUBA'),
 (12,1,'TURIN'),
 (13,2,'CANDELARIA DE LA FRONTERA'),
 (14,2,'COATEPEQUE'),
 (15,2,'CHALCHUAPA'),
 (16,2,'EL CONGO'),
 (17,2,'EL PORVENIR'),
 (18,2,'MASAHUAT'),
 (19,2,'METAPAN'),
 (20,2,'SAN ANTONIO PAJONAL'),
 (21,2,'AN SEBASTIAN SALITRILLO'),
 (22,2,'SANTA ANA'),
 (23,2,'SANTA ROSA GUACHIPILIN'),
 (24,2,'SANTIAGO DE LA FRONTERA'),
 (25,2,'TEXISTEPEQUE'),
 (26,3,'ACAJUTLA'),
 (27,3,'ARMENIA'),
 (28,3,'CALUCO'),
 (29,3,'CUISNAHUAT'),
 (30,3,'SANTA ISABEL ISHUATAN'),
 (31,3,'IZALCO'),
 (32,3,'JUAYUA'),
 (33,3,'NAHUIZALCO'),
 (34,3,'NAHULINGO'),
 (35,3,'SALCOATITAN'),
 (36,3,'SAN ANTONIO DEL MONTE'),
 (37,3,'SAN JULIAN'),
 (38,3,'SANTA CATARINA MASAHUAT'),
 (39,3,'SANTO DOMINGO DE GUZMAN'),
 (40,3,'SONSONATE'),
 (41,3,'SONZACATE'),
 (42,4,'AGUA CALIENTE'),
 (43,4,'ARCATAO'),
 (44,4,'AZACUALPA'),
 (45,4,'CITALA'),
 (46,4,'COMALAPA'),
 (47,4,'CONCEPCION QUEZALTEPEQUE'),
 (48,4,'CHALATENANGO'),
 (49,4,'DULCE NOMBRE DE MARIA'),
 (50,4,'EL CARRIZAL'),
 (51,4,'EL PARAISO'),
 (52,4,'LA LAGUNA'),
 (53,4,'LA PALMA'),
 (54,4,'LA REINA'),
 (55,4,'LAS VUELTAS'),
 (56,4,'NOMBRE DE JESUS'),
 (57,4,'NUEVA CONCEPCION'),
 (58,4,'NUEVA TRINIDAD'),
 (59,4,'OJOS DE AGUA'),
 (60,4,'POTONICO'),
 (61,4,'SAN ANTONIO LA CRUZ'),
 (62,4,'SAN ANTONIO LOS RANCHOS'),
 (63,4,'SAN FERNANDO'),
 (64,4,'SAN FRANCISCO LEMPA'),
 (65,4,'SAN FRANCISCO MORAZAN'),
 (66,4,'SAN IGNACIO'),
 (67,4,'SAN ISIDRO LABRADOR'),
 (68,4,'SAN JOSE CANCASQUE'),
 (69,4,'SAN JOSE LAS FLORES'),
 (70,4,'SAN LUIS DEL CARMEN'),
 (71,4,'SAN MIGUEL DE MERCEDES'),
 (72,4,'SAN RAFAEL'),
 (73,4,'SANTA RITA'),
 (74,4,'TEJUTLA'),
 (75,5,'ANTIGUO CUSCATLAN'),
 (76,5,'CIUDAD ARCE'),
 (77,5,'COLON'),
 (78,5,'COMASAGUA'),
 (79,5,'CHILTIUPAN'),
 (80,5,'HUIZUCAR'),
 (81,5,'JAYAQUE'),
 (82,5,'JICALAPA'),
 (83,5,'LA LIBERTAD'),
 (84,5,'NUEVO CUSCATLAN'),
 (85,5,'SANTA TECLA'),
 (86,5,'QUEZALTEPEQUE'),
 (87,5,'SACACOYO'),
 (88,5,'SAN JOSE VILLANUEVA'),
 (89,5,'SAN JUAN OPICO'),
 (90,5,'SAN MATIAS'),
 (91,5,'SAN PABLO TACACHICO'),
 (92,5,'TAMANIQUE'),
 (93,5,'TALNIQUE'),
 (94,5,'TEOTEPEQUE'),
 (95,5,'TEPECOYO'),
 (96,5,'ZARAGOZA'),
 (97,6,'AGUILARES'),
 (98,6,'APOPA'),
 (99,6,'AYUTUXTEPEQUE'),
 (100,6,'CUSCATANCINGO'),
 (101,6,'EL PAISNAL'),
 (102,6,'GUAZAPA'),
 (103,6,'ILOPANGO'),
 (104,6,'MEJICANOS'),
 (105,6,'NEJAPA'),
 (106,6,'PANCHIMALCO'),
 (107,6,'ROSARIO DE MORA'),
 (108,6,'SAN MARCOS'),
 (109,6,'SAN MARTIN'),
 (110,6,'SAN SALVADOR'),
 (111,6,'SANTIAGO TEXACUANGOS'),
 (112,6,'SANTO TOMAS'),
 (113,6,'SOYAPANGO'),
 (114,6,'TONACATEPEQUE'),
 (115,6,'DELGADO'),
 (116,7,'CANDELARIA  '),
 (117,7,'COJUTEPEQUE'),
 (118,7,'EL CARMEN'),
 (119,7,'EL ROSARIO'),
 (120,7,'MONTE SAN JUAN'),
 (121,7,'ORATORIO DE CONCEPCION'),
 (122,7,'SAN BARTOLOME PERULAPIA'),
 (123,7,'SAN CRISTOBAL'),
 (124,7,'SAN JOSE GUAYABAL'),
 (125,7,'SAN PEDRO PERULAPAN'),
 (126,7,'SAN RAFAEL CEDROS'),
 (127,7,'SAN RAMON'),
 (128,7,'SANTA CRUZ ANALQUITO'),
 (129,7,'SANTA CRUZ MICHAPA'),
 (130,7,'SUCHITOTO'),
 (131,7,'TENANCINGO'),
 (154,9,'CINQUERA'),
 (155,9,'GUACOTECTI'),
 (156,9,'ILOBASCO'),
 (157,9,'JUTIAPA'),
 (158,9,'SAN ISIDRO  '),
 (159,9,'SENSUNTEPEQUE'),
 (160,9,'TEJUTEPEQUE'),
 (161,9,'VICTORIA'),
 (162,9,'VILLA DOLORES'),
 (163,10,'APASTEPEQUE'),
 (164,10,'GUADALUPE'),
 (165,10,'SAN CAYETANO ISTEPEQUE'),
 (166,10,'SANTA CLARA'),
 (167,10,'SANTO DOMINGO'),
 (168,10,'SAN ESTEBAN CATARINA'),
 (169,10,'SAN ILDEFONSO'),
 (170,10,'SAN LORENZO'),
 (171,10,'SAN SEBASTIAN'),
 (172,10,'SAN VICENTE'),
 (173,10,'TECOLULA'),
 (174,10,'TEPETITAN'),
 (175,10,'VERAPAZ'),
 (176,11,'ALEGRIA'),
 (177,11,'BERLIN'),
 (178,11,'CALIFORNIA'),
 (179,11,'CONCEPCION BATRES'),
 (180,11,'VILLA EL TRIUNFO'),
 (181,11,'EREGUAYQUIN'),
 (182,11,'ESTANZUELAS'),
 (183,11,'JIQUILISCO'),
 (184,11,'JUCUAPA'),
 (185,11,'JUCUARAN'),
 (186,11,'MERCEDES UMAÑA'),
 (187,11,'NUEVA GRANADA'),
 (188,11,'OZATLAN'),
 (189,11,'PUERTO EL TRIUNFO'),
 (190,11,'SAN AGUSTIN'),
 (191,11,'SAN BUENA VENTURA'),
 (192,11,'SAN DIONISIO'),
 (193,11,'SANTA ELENA'),
 (194,11,'SAN FRANCISCO JAVIER'),
 (195,11,'SANTA MARIA '),
 (196,11,'SANTIAGO DE MARIA'),
 (197,11,'TECAPAN'),
 (198,11,'USULUTAN'),
 (199,12,'CAROLINA'),
 (200,12,'CIUDAD BARRIOS'),
 (201,12,'COMACARAN'),
 (202,12,'CHAPELTIQUE'),
 (203,12,'CHINAMECA'),
 (204,12,'CHIRILAGUA'),
 (205,12,'EL TRANSITO'),
 (206,12,'LOLOTIQUE'),
 (207,12,'MONCAGUA'),
 (208,12,'NUEVA GUADALUPE'),
 (209,12,'NUEVO EDEN DE SAN JUAN'),
 (210,12,'QUELEPA'),
 (211,12,'SAN ANTONIO DEL MOSCOSO'),
 (212,12,'SAN GERARDO'),
 (213,12,'SAN JORGE'),
 (214,12,'SAN LUIS LA REINA'),
 (215,12,'SAN MIGUEL'),
 (216,12,'SAN RAFAEL ORIENTE'),
 (217,12,'SESORI'),
 (218,12,'ULUAZAPA'),
 (219,13,'ARAMBALA'),
 (220,13,'CACAOPERA'),
 (221,13,'CORINTO'),
 (222,13,'CHILANGA'),
 (223,13,'DELICIAS DE CONCEPCION'),
 (224,13,'EL DIVISADERO'),
 (225,13,'EL ROSARIO'),
 (226,13,'GUALOCOCTI'),
 (227,13,'GUATAJIAGUA'),
 (228,13,'JOATECA'),
 (229,13,'JOCOAITIQUE'),
 (230,13,'JOCORO'),
 (231,13,'LOLOTIQUILLO'),
 (232,13,'MEANGUERA'),
 (233,13,'OSICALA'),
 (234,13,'PERQUIN'),
 (235,13,'SAN CARLOS'),
 (236,13,'SAN FERNANDO'),
 (237,13,'SAN FRANCISCO GOTERA'),
 (238,13,'SAN ISIDRO'),
 (239,13,'SAN SIMON'),
 (240,13,'SENSEMBRA'),
 (241,13,'SOCIEDAD'),
 (242,13,'TOROLA'),
 (243,13,'YAMABAL'),
 (244,13,'YOLOAYQUIN'),
 (245,14,'ANAMOROS'),
 (246,14,'BOLIVAR'),
 (247,14,'CONCEPCION DE ORIENTE'),
 (248,14,'CONCHAGUA'),
 (249,14,'EL CARMEN'),
 (250,14,'EL SAUSE'),
 (251,14,'INTIPUCA'),
 (252,14,'LA UNION'),
 (253,14,'LISLIQUE'),
 (254,14,'MEANGUERA DEL GOLFO'),
 (255,14,'NUEVA ESPARTA'),
 (256,14,'PASAQUINA'),
 (257,14,'POLOROS'),
 (258,14,'SAN ALEJO'),
 (259,14,'SAN JOSE LAS FUENTES'),
 (260,14,'SANTA ROSA DE LIMA'),
 (261,14,'YAYANTIQUE'),
 (262,14,'YUCUAIQUIN'),
 (263,8,'ZACATECOLUCA'),
 (264,8,'SANTIAGO NONUALCO'),
 (800,8,'SAN JUAN TEPEZONTES'),
 (1001,8,'SAN PEDRO MASAHUAT'),
 (1002,8,'SAN EMIGDIO'),
 (1003,8,'TACACHICO'),
 (1004,8,'SAN LUIS TALPA');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cat_municipios` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`cat_paises`
--

DROP TABLE IF EXISTS `regciclistas`.`cat_paises`;
CREATE TABLE  `regciclistas`.`cat_paises` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `des_pais` varchar(50) DEFAULT NULL,
  `cod_area_tel` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='Paises';

--
-- Dumping data for table `regciclistas`.`cat_paises`
--

/*!40000 ALTER TABLE `cat_paises` DISABLE KEYS */;
LOCK TABLES `cat_paises` WRITE;
INSERT INTO `regciclistas`.`cat_paises` VALUES  (1,'GUATEMALA','502'),
 (2,'BELICE','501'),
 (3,'HONDURAS','504'),
 (4,'EL SALVADOR','503'),
 (5,'NICARAGUA','505'),
 (6,'COSTA RICA','506'),
 (7,'PANAMA','507');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cat_paises` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`ciclistas`
--

DROP TABLE IF EXISTS `regciclistas`.`ciclistas`;
CREATE TABLE  `regciclistas`.`ciclistas` (
  `id_ciclista` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(100) NOT NULL,
  `alias` varchar(25) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ciclista`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='Tabla Maesta de ciclistas';

--
-- Dumping data for table `regciclistas`.`ciclistas`
--

/*!40000 ALTER TABLE `ciclistas` DISABLE KEYS */;
LOCK TABLES `ciclistas` WRITE;
INSERT INTO `regciclistas`.`ciclistas` VALUES  (11,'amandadepaz@gmail.com','amandadepaz','201f00b5ca5d65a1c118e5e32431514c'),
 (12,'juliux@gmail.com','juliux','201f00b5ca5d65a1c118e5e32431514c'),
 (13,'kingofkings1982@live.com','kingofkings','201f00b5ca5d65a1c118e5e32431514c'),
 (14,'xrecinos@gmail.com','xrecinos','201f00b5ca5d65a1c118e5e32431514c'),
 (17,'luis.cordero@gmail.com','lcordero','e10adc3949ba59abbe56e057f20f883e'),
 (18,'sepa@gmail.com','sepa','5078e2842ecf808df5510dd3375b0aa4'),
 (19,'jriveramancia@gmail.com','jriveramancia','e10adc3949ba59abbe56e057f20f883e'),
 (20,'test@yahoo.com','test','e10adc3949ba59abbe56e057f20f883e'),
 (21,'sample@fuss.org','sampletext','e10adc3949ba59abbe56e057f20f883e');
UNLOCK TABLES;
/*!40000 ALTER TABLE `ciclistas` ENABLE KEYS */;


--
-- Definition of table `regciclistas`.`det_ciclistas`
--

DROP TABLE IF EXISTS `regciclistas`.`det_ciclistas`;
CREATE TABLE  `regciclistas`.`det_ciclistas` (
  `coddetciclista` int(11) NOT NULL AUTO_INCREMENT,
  `id_ciclista` int(11) NOT NULL,
  `dui` varchar(10) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `primernombre` varchar(55) NOT NULL,
  `segundonombre` varchar(55) DEFAULT NULL,
  `primerapellido` varchar(55) NOT NULL,
  `segundoapellido` varchar(55) DEFAULT NULL,
  `apellidodecasada` varchar(55) DEFAULT NULL,
  `sexo` varchar(3) DEFAULT 'MAS',
  `fechanac` date DEFAULT NULL,
  `telefonofijo` varchar(10) DEFAULT NULL,
  `telefonomovil` varchar(10) DEFAULT NULL,
  `codpais` int(11) NOT NULL,
  `codmuni` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `twitter` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`coddetciclista`) USING BTREE,
  KEY `fk_ciclista1` (`id_ciclista`),
  KEY `codpais` (`codpais`),
  KEY `codmuni` (`codmuni`),
  CONSTRAINT `fk_ciclista1` FOREIGN KEY (`id_ciclista`) REFERENCES `ciclistas` (`id_ciclista`),
  CONSTRAINT `fk_munis1` FOREIGN KEY (`codmuni`) REFERENCES `cat_municipios` (`codmuni`),
  CONSTRAINT `fk_paises1` FOREIGN KEY (`codpais`) REFERENCES `cat_paises` (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `regciclistas`.`det_ciclistas`
--

/*!40000 ALTER TABLE `det_ciclistas` DISABLE KEYS */;
LOCK TABLES `det_ciclistas` WRITE;
INSERT INTO `regciclistas`.`det_ciclistas` VALUES  (7,11,'99999999-9','9999-999999-999-9','Amanda','Elizabeth','Hernandez','De Paz','Rivera','FEM','1980-11-13','','99-99-9999',4,113,'Jardines del Cerro Senda 2 Poligono 3','amandadepaz',''),
 (8,12,'99999999-9','9999-999999-999-9','Julio','Adalberto','Rivera','Pineda','','MAS','1978-01-16','','70-00-0000',4,109,'Altavista Calle Las Delicias','juliux','basuriando'),
 (9,13,'77777777-7','7777-777777-777-7','Jonatan','','Rivera','Pineda','','MAS','1982-11-09','99-99-9999','88-88-8888',4,113,'Repto. Los Santos No.2','kingofkings','kingofkings'),
 (10,14,'44444444-4','5555-555555-555-5','Xenia','Luz','Recinos','','Rivera','FEM','1978-01-03','77-77-7777','88-88-8888',4,109,'Altavista','xrecinos',''),
 (13,17,'00000000-0','0000-000000-000-0','Luis','','Cordero','','','MAS','2013-02-19','','00-00-0000',4,104,'NOSE','lcordero','lcordero'),
 (14,18,'','','Test','Test','Test','Test','','0','2013-02-19','','',4,2,'SEPA','',''),
 (15,19,'','','Julian','','Rivera','Mancia','','MAS','1952-02-22','22-91-9340','',4,113,'Reparto los santos 2','',''),
 (16,20,'','','xx','xx','xx','xx','yy','MAS','2013-03-06','','',4,113,'','',''),
 (17,21,'','','qwerty','sample','sample','sample','sample','FEM','2013-03-13','','',4,100,'Sample Dir','xtecuan','xtecuan');
UNLOCK TABLES;
/*!40000 ALTER TABLE `det_ciclistas` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
