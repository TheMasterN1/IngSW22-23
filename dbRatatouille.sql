-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.6.5-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database ratatouille
CREATE DATABASE IF NOT EXISTS `ratatouille` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ratatouille`;

-- Dump della struttura di tabella ratatouille.ingrediente
CREATE TABLE IF NOT EXISTS `ingrediente` (
  `nome` varchar(50) NOT NULL,
  `ingredienteId` int(11) NOT NULL AUTO_INCREMENT,
  `quantita` int(11) NOT NULL,
  `prodotID` int(11) NOT NULL,
  PRIMARY KEY (`ingredienteId`),
  KEY `FK1_prodotID` (`prodotID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `menuID` int(11) NOT NULL AUTO_INCREMENT,
  `prodottoID` int(11) NOT NULL,
  PRIMARY KEY (`menuID`),
  KEY `menuID` (`menuID`),
  KEY `prodottoID` (`prodottoID`),
  CONSTRAINT `FK1_prodottoID` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.ordine
CREATE TABLE IF NOT EXISTS `ordine` (
  `ordineId` int(11) NOT NULL AUTO_INCREMENT,
  `costoOrdine` int(11) NOT NULL,
  `prodId` int(11) NOT NULL,
  PRIMARY KEY (`ordineId`),
  KEY `FK1_prodID` (`prodId`),
  CONSTRAINT `FK1_prodID` FOREIGN KEY (`prodId`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.prodotto
CREATE TABLE IF NOT EXISTS `prodotto` (
  `costo` float NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '',
  `allergeni` varchar(50) NOT NULL DEFAULT '',
  `descrizione` varchar(100) NOT NULL DEFAULT '',
  `prodottoID` int(11) NOT NULL AUTO_INCREMENT,
  `quantita` int(11) NOT NULL,
  `categoria` enum('Primo','Secondo','Contorno','Dolce','Antipasto','Bibita') NOT NULL,
  `menuID` int(11) NOT NULL,
  `ordineID` int(11) NOT NULL,
  `ingredID` int(11) DEFAULT NULL,
  PRIMARY KEY (`prodottoID`),
  KEY `prodottoID` (`prodottoID`),
  KEY `FK1_oridneID` (`ordineID`),
  KEY `FK2_prodotto_menu` (`menuID`),
  KEY `FK3_ingredID` (`ingredID`),
  CONSTRAINT `FK1_oridneID` FOREIGN KEY (`ordineID`) REFERENCES `ordine` (`ordineId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK2_prodotto_menu` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK3_ingredID` FOREIGN KEY (`ingredID`) REFERENCES `ingrediente` (`ingredienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `salaID` int(11) NOT NULL AUTO_INCREMENT,
  `quantitaTavoli` int(11) NOT NULL,
  `tavoliID` int(11) NOT NULL,
  PRIMARY KEY (`salaID`),
  KEY `FK1_tavoliID` (`tavoliID`),
  CONSTRAINT `FK1_tavoliID` FOREIGN KEY (`tavoliID`) REFERENCES `tavolo` (`tavoloID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.tavolo
CREATE TABLE IF NOT EXISTS `tavolo` (
  `tavoloID` int(11) NOT NULL AUTO_INCREMENT,
  `numeroPosti` int(11) NOT NULL,
  `salaID` int(11) NOT NULL,
  PRIMARY KEY (`tavoloID`),
  KEY `FK1_salaID` (`salaID`),
  CONSTRAINT `FK1_salaID` FOREIGN KEY (`salaID`) REFERENCES `sala` (`salaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.utente
CREATE TABLE IF NOT EXISTS `utente` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruolo` enum('Amministratore','Supervisore','Addetto Sala','Addetto Cucina') NOT NULL,
  `IDsala` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `password` (`password`),
  KEY `FK1_IDsala` (`IDsala`),
  CONSTRAINT `FK1_IDsala` FOREIGN KEY (`IDsala`) REFERENCES `sala` (`salaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
