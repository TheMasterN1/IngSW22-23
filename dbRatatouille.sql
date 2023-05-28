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

-- Dump della struttura di tabella ratatouille.bacheca
CREATE TABLE IF NOT EXISTS `bacheca` (
  `IDnotifica` int(11) NOT NULL,
  `oggetto` varchar(70) NOT NULL,
  `testo` varchar(1000) NOT NULL,
  `IDutente` int(11) NOT NULL,
  PRIMARY KEY (`IDnotifica`),
  KEY `sender` (`IDutente`),
  CONSTRAINT `sender` FOREIGN KEY (`IDutente`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.ingrediente
CREATE TABLE IF NOT EXISTS `ingrediente` (
  `nome` varchar(50) NOT NULL,
  `ingredienteId` int(11) NOT NULL AUTO_INCREMENT,
  `quantita` int(11) NOT NULL,
  PRIMARY KEY (`ingredienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `menuID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menuID`),
  KEY `menuID` (`menuID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.ordinazione
CREATE TABLE IF NOT EXISTS `ordinazione` (
  `ordineID` int(11) DEFAULT NULL,
  `prodottoID` int(11) DEFAULT NULL,
  KEY `ordineID` (`ordineID`),
  KEY `FK__prodotto` (`prodottoID`),
  CONSTRAINT `FK__ordine` FOREIGN KEY (`ordineID`) REFERENCES `ordine` (`ordineId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__prodotto` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.ordine
CREATE TABLE IF NOT EXISTS `ordine` (
  `ordineId` int(11) NOT NULL AUTO_INCREMENT,
  `costoOrdine` int(11) NOT NULL,
  `prodId` int(11) NOT NULL,
  `tavoloID` int(11) NOT NULL,
  PRIMARY KEY (`ordineId`),
  KEY `FK1_prodID` (`prodId`),
  KEY `FK2_tavoloID` (`tavoloID`),
  CONSTRAINT `FK1_prodID` FOREIGN KEY (`prodId`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK2_tavoloID` FOREIGN KEY (`tavoloID`) REFERENCES `tavolo` (`tavoloID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.portata
CREATE TABLE IF NOT EXISTS `portata` (
  `menuID` int(11) DEFAULT NULL,
  `prodottoID` int(11) DEFAULT NULL,
  KEY `FK_1` (`menuID`),
  KEY `FK_2` (`prodottoID`),
  CONSTRAINT `FK_1` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_2` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  PRIMARY KEY (`prodottoID`),
  KEY `prodottoID` (`prodottoID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000121213 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella ratatouille.ricetta
CREATE TABLE IF NOT EXISTS `ricetta` (
  `prodottoID` int(11) DEFAULT NULL,
  `ingredienteID` int(11) DEFAULT NULL,
  KEY `FK` (`prodottoID`),
  KEY `FK1` (`ingredienteID`),
  CONSTRAINT `FK` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK1` FOREIGN KEY (`ingredienteID`) REFERENCES `ingrediente` (`ingredienteId`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump della struttura di tabella ratatouille.visualizzazione
CREATE TABLE IF NOT EXISTS `visualizzazione` (
  `ID` int(11) NOT NULL,
  `IDnotifica` int(11) NOT NULL,
  `visualizzato` binary(1) NOT NULL DEFAULT '\0',
  KEY `FK1IDnotifica` (`IDnotifica`),
  KEY `FK2ID` (`ID`),
  CONSTRAINT `FK1IDnotifica` FOREIGN KEY (`IDnotifica`) REFERENCES `bacheca` (`IDnotifica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK2ID` FOREIGN KEY (`ID`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
