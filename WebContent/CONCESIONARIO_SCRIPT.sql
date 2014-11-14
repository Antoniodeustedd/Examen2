DROP DATABASE IF EXISTS `concesionario`;
CREATE DATABASE IF NOT EXISTS `concesionario` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `concesionario`;

DROP TABLE IF EXISTS `vehiculo`;
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `id` int(4) NOT NULL auto_increment,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `modelo` varchar(4) NOT NULL,
  `color` varchar(20) NOT NULL,
  `numeroCaballos` int(5) NOT NULL,
  `marchas` tinyint(5) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
