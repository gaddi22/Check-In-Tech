CREATE DATABASE  IF NOT EXISTS `checkintech` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `checkintech`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: checkintech
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping events for database 'checkintech'
--

--
-- Dumping routines for database 'checkintech'
--
/*!50003 DROP PROCEDURE IF EXISTS `checkAttended` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkAttended`(IN firstc DATETIME, IN lastc DATETIME, IN dur TIME)
BEGIN
	IF (abs(firstc - lastc) >= dur) THEN
		SELECT 0;
	ELSE SELECT 1;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkInMobile` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkInMobile`(IN targetAttendee VARCHAR(10),IN targetEventID VARCHAR(10),IN signInMethod VARCHAR(6),IN inMAC VARCHAR(12))
BEGIN

declare isCheck TINYINT;
declare dur time;
declare firstc DATETIME;
declare lastc DATETIME;

SET dur = (SELECT Duration FROM event WHERE ID = targetEventID),
	firstc = (select FirstCheck FROM attends WHERE AttID = targetAttendee AND EventID = targetEventID),
	lastc = (select LastCheck FROM attends WHERE AttID = targetAttendee AND EventID = targetEventID);

IF (abs( firstc - lastc) >= dur) THEN
	set isCheck = 1;
ELSE set isCheck = 0;
END IF;

UPDATE attends 
	SET LastCheck = current_timestamp(),
	HasAttended = isCheck
	WHERE AttID = targetAttendee AND
	EventID = targetEventID;
    
IF (firstc IS NULL) THEN
	UPDATE attends 
		SET 
        FirstCheck = current_timestamp(),
        LastCheck = current_timestamp(),
        HasAttended = 0, 
        SignMethod = signInMethod,
        MAC = inMAC
        WHERE AttID = targetAttendee AND
        EventID = targetEventID;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkInOther` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkInOther`(IN targetAttendee VARCHAR(10),IN targetEventID VARCHAR(10),IN signInMethod VARCHAR(6))
BEGIN
	declare isCheck TINYINT;
	declare dur time;
	declare firstc DATETIME;
	declare lastc DATETIME;

	SET dur = (SELECT Duration FROM event WHERE ID = targetEventID),
		firstc = (select FirstCheck FROM attends WHERE AttID = targetAttendee AND EventID = targetEventID),
		lastc = (select LastCheck FROM attends WHERE AttID = targetAttendee AND EventID = targetEventID);

	IF (abs( firstc - lastc) >= dur) THEN
		set isCheck = 1;
	ELSE set isCheck = 0;
	END IF;

	UPDATE attends 
		SET LastCheck = current_timestamp(),
		HasAttended = isCheck
		WHERE AttID = targetAttendee AND
		EventID = targetEventID;
		
	IF (firstc IS NULL) THEN
		UPDATE attends 
			SET 
			FirstCheck = current_timestamp(),
			LastCheck = current_timestamp(),
			HasAttended = 0, 
			SignMethod = signInMethod
			WHERE AttID = targetAttendee AND
			EventID = targetEventID;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 19:43:15
