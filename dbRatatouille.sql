-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              11.1.0-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database ratatouille
CREATE DATABASE IF NOT EXISTS `ratatouille` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `ratatouille`;

-- Dump della struttura di tabella ratatouille.bacheca
CREATE TABLE IF NOT EXISTS `bacheca` (
  `IDnotifica` int(11) NOT NULL AUTO_INCREMENT,
  `oggetto` varchar(70) NOT NULL,
  `testo` varchar(1000) NOT NULL,
  `IDutente` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDnotifica`),
  KEY `sender` (`IDutente`),
  CONSTRAINT `sender` FOREIGN KEY (`IDutente`) REFERENCES `utente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.bacheca: ~3 rows (circa)
INSERT IGNORE INTO `bacheca` (`IDnotifica`, `oggetto`, `testo`, `IDutente`) VALUES
	(23, 'Saluto', 'ciao pisello come va ti voglio bene', 2),
	(28, 'Avviso Limite Superato', 'L\'ingrediente Pancia ha raggiunto il limite minimo, si prega di fare rifornimento al più presto', NULL);

-- Dump della struttura di tabella ratatouille.ingrediente
CREATE TABLE IF NOT EXISTS `ingrediente` (
  `nome` varchar(50) NOT NULL,
  `ingredienteId` int(11) NOT NULL AUTO_INCREMENT,
  `quantita` int(11) NOT NULL,
  PRIMARY KEY (`ingredienteId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.ingrediente: ~2 rows (circa)
INSERT IGNORE INTO `ingrediente` (`nome`, `ingredienteId`, `quantita`) VALUES
	('Pancia', 2, 4);

-- Dump della struttura di tabella ratatouille.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `menuID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menuID`),
  KEY `menuID` (`menuID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.menu: ~0 rows (circa)

-- Dump della struttura di tabella ratatouille.ordinazione
CREATE TABLE IF NOT EXISTS `ordinazione` (
  `ordineID` int(11) DEFAULT NULL,
  `prodottoID` int(11) DEFAULT NULL,
  `quantità` int(11) DEFAULT NULL,
  KEY `ordineID` (`ordineID`),
  KEY `FK__prodotto` (`prodottoID`),
  CONSTRAINT `FK__ordine` FOREIGN KEY (`ordineID`) REFERENCES `ordine` (`ordineId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__prodotto` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.ordinazione: ~0 rows (circa)

-- Dump della struttura di tabella ratatouille.ordine
CREATE TABLE IF NOT EXISTS `ordine` (
  `ordineId` int(11) NOT NULL AUTO_INCREMENT,
  `costoOrdine` float NOT NULL DEFAULT 0,
  `tavoloID` int(11) NOT NULL,
  PRIMARY KEY (`ordineId`),
  KEY `FK2_tavoloID` (`tavoloID`),
  CONSTRAINT `FK2_tavoloID` FOREIGN KEY (`tavoloID`) REFERENCES `tavolo` (`tavoloID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.ordine: ~9 rows (circa)
INSERT IGNORE INTO `ordine` (`ordineId`, `costoOrdine`, `tavoloID`) VALUES
	(2, 0, 20),
	(3, 0, 21),
	(4, 0, 22),
	(5, 0, 23),
	(6, 0, 24),
	(7, 0, 25),
	(8, 0, 26),
	(9, 0, 27);

-- Dump della struttura di tabella ratatouille.portata
CREATE TABLE IF NOT EXISTS `portata` (
  `menuID` int(11) DEFAULT NULL,
  `prodottoID` int(11) DEFAULT NULL,
  KEY `FK_1` (`menuID`),
  KEY `FK_2` (`prodottoID`),
  CONSTRAINT `FK_1` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_2` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.portata: ~0 rows (circa)

-- Dump della struttura di tabella ratatouille.prodotto
CREATE TABLE IF NOT EXISTS `prodotto` (
  `costo` float NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '',
  `descrizione` varchar(100) NOT NULL DEFAULT '',
  `prodottoID` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` enum('Primo','Secondo','Contorno','Dolce','Antipasto','Bibita') NOT NULL,
  `allergeni` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`prodottoID`),
  KEY `prodottoID` (`prodottoID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000121222 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.prodotto: ~1 rows (circa)
INSERT IGNORE INTO `prodotto` (`costo`, `nome`, `descrizione`, `prodottoID`, `categoria`, `allergeni`) VALUES
	(0.5, 'Gelato', 'Gelato caldo', 1, 'Primo', 'Uova');

-- Dump della struttura di tabella ratatouille.ricetta
CREATE TABLE IF NOT EXISTS `ricetta` (
  `prodottoID` int(11) DEFAULT NULL,
  `ingredienteID` int(11) DEFAULT NULL,
  `quantità` int(11) DEFAULT NULL,
  KEY `FK` (`prodottoID`),
  KEY `FK1` (`ingredienteID`),
  CONSTRAINT `FK` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`prodottoID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK1` FOREIGN KEY (`ingredienteID`) REFERENCES `ingrediente` (`ingredienteId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.ricetta: ~0 rows (circa)
INSERT IGNORE INTO `ricetta` (`prodottoID`, `ingredienteID`, `quantità`) VALUES
	(1, 2, 4);

-- Dump della struttura di tabella ratatouille.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `salaID` int(11) NOT NULL,
  PRIMARY KEY (`salaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.sala: ~2 rows (circa)
INSERT IGNORE INTO `sala` (`salaID`) VALUES
	(1);

-- Dump della struttura di tabella ratatouille.tavolo
CREATE TABLE IF NOT EXISTS `tavolo` (
  `tavoloID` int(11) NOT NULL AUTO_INCREMENT,
  `numeroPosti` int(11) NOT NULL,
  `salaID` int(11) NOT NULL,
  PRIMARY KEY (`tavoloID`),
  KEY `FK1_salaID` (`salaID`),
  CONSTRAINT `FK1_salaID` FOREIGN KEY (`salaID`) REFERENCES `sala` (`salaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.tavolo: ~9 rows (circa)
INSERT IGNORE INTO `tavolo` (`tavoloID`, `numeroPosti`, `salaID`) VALUES
	(20, 3, 1),
	(21, 5, 1),
	(22, 1, 1),
	(23, 5, 1),
	(24, 5, 1),
	(25, 4, 1),
	(26, 5, 1),
	(27, 5, 1);

-- Dump della struttura di tabella ratatouille.utente
CREATE TABLE IF NOT EXISTS `utente` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruolo` enum('Amministratore','Supervisore','Addetto_Sala','Addetto_Cucina') NOT NULL,
  `IDsala` int(11) DEFAULT NULL,
  `nuovoUtente` enum('Y','N') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1_IDsala` (`IDsala`),
  CONSTRAINT `FK1_IDsala` FOREIGN KEY (`IDsala`) REFERENCES `sala` (`salaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.utente: ~3 rows (circa)
INSERT IGNORE INTO `utente` (`username`, `password`, `id`, `ruolo`, `IDsala`, `nuovoUtente`) VALUES
	('q', 'q', 2, 'Amministratore', NULL, 'N'),
	('asd', 'asd', 3, 'Addetto_Cucina', NULL, 'N'),
	('c', 'ciccia', 4, 'Addetto_Sala', 1, 'N');

-- Dump della struttura di tabella ratatouille.visualizzazione
CREATE TABLE IF NOT EXISTS `visualizzazione` (
  `ID` int(11) NOT NULL,
  `IDnotifica` int(11) NOT NULL,
  `visualizzato` enum('Y','N') NOT NULL DEFAULT 'N',
  KEY `FK1IDnotifica` (`IDnotifica`),
  KEY `FK2ID` (`ID`),
  CONSTRAINT `FK1ID` FOREIGN KEY (`ID`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK2Notifica` FOREIGN KEY (`IDnotifica`) REFERENCES `bacheca` (`IDnotifica`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dump dei dati della tabella ratatouille.visualizzazione: ~6 rows (circa)
INSERT IGNORE INTO `visualizzazione` (`ID`, `IDnotifica`, `visualizzato`) VALUES
	(3, 23, 'N'),
	(4, 23, 'N'),
	(2, 23, 'Y'),
	(2, 28, 'Y'),
	(3, 28, 'N'),
	(4, 28, 'N');

-- Dump della struttura di trigger ratatouille.bacheca_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `bacheca_insert` AFTER INSERT ON `bacheca` FOR EACH ROW BEGIN
   DECLARE X INTEGER;
   DECLARE done INT DEFAULT FALSE;
   
   DECLARE cur CURSOR FOR SELECT id FROM utente WHERE id <> NEW.IDutente OR id IS NOT NULL; 
   
   DECLARE CONTINUE handler FOR NOT FOUND SET done = TRUE;
   
   OPEN cur;
   
   readloop: LOOP
   	
   	FETCH cur INTO X;
   
  		if done then
   		leave readloop;
   	END if;
   
		INSERT INTO visualizzazione VALUES(X, NEW.IDnotifica, 'N');
	END LOOP;
	
	close cur;
	
	if NEW.IDutente <> NULL THEN
		INSERT INTO visualizzazione VALUES(NEW.IDutente, NEW.IDnotifica, 'Y');
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger ratatouille.ingrediente_after_update
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `ingrediente_after_update` AFTER UPDATE ON `ingrediente` FOR EACH ROW BEGIN
	if NEW.quantita <= 5 THEN
		INSERT INTO bacheca(oggetto, testo) VALUES('Avviso Limite Superato', CONCAT('L\'ingrediente ', NEW.nome, ' ha raggiunto il limite minimo, si prega di fare rifornimento al più presto'));
	END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger ratatouille.ordinazione_after_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `ordinazione_after_insert` AFTER INSERT ON `ordinazione` FOR EACH ROW BEGIN
	DECLARE X FLOAT DEFAULT (SELECT costo FROM prodotto WHERE prodottoID = NEW.prodottoID);
	DECLARE Y INTEGER DEFAULT (SELECT quantità FROM ordinazione WHERE prodottoID = NEW.prodottoID);
	
	UPDATE ordine 
	SET costoOrdine = costoOrdine + X*Y
	WHERE ordineID = NEW.ordineID;
	
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger ratatouille.ordinazione_before_delete
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `ordinazione_before_delete` BEFORE DELETE ON `ordinazione` FOR EACH ROW BEGIN
	DECLARE X FLOAT DEFAULT (SELECT costo FROM prodotto WHERE prodottoID = OLD.prodottoID);
	DECLARE Y INTEGER DEFAULT (SELECT quantità FROM ordinazione WHERE prodottoID = OLD.prodottoID);
	DECLARE J, K INTEGER;
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR FOR SELECT quantità FROM ricetta WHERE prodottoID = OLD.prodottoID; 
	DECLARE cur2 CURSOR FOR SELECT ingredienteID FROM ricetta WHERE prodottoID = OLD.prodottoID; 
   DECLARE CONTINUE handler FOR NOT FOUND SET done = TRUE;

	UPDATE ordine 
	SET costoOrdine = costoOrdine - X*Y
	WHERE ordineID = OLD.ordineID;
   
   OPEN cur;
   OPEN cur2;
   
   readloop: LOOP
   	
   	FETCH cur INTO J;
		FETCH cur2 INTO K;
   
  		if done then
   		leave readloop;
   	END if;
				
		UPDATE ingrediente
		SET quantità = quantità - J*Y
		WHERE K = ingredienteID; 

	END LOOP;
	
	close cur;
	close cur2;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger ratatouille.tavolo_after_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tavolo_after_insert` AFTER INSERT ON `tavolo` FOR EACH ROW BEGIN
	INSERT INTO ordine(tavoloID) VALUES (NEW.tavoloID);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
