-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_library
-- ------------------------------------------------------
-- Server version	5.7.27-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ISBN` int(11) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `Availability` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  `Is_rent` int(1) NOT NULL,
  `Total_copies` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogue`
--

DROP TABLE IF EXISTS `catalogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogue` (
  `ISBN` int(14) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  `BType` varchar(45) NOT NULL,
  `Subjectarea` varchar(45) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogue`
--

LOCK TABLES `catalogue` WRITE;
/*!40000 ALTER TABLE `catalogue` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checks_out`
--

DROP TABLE IF EXISTS `checks_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checks_out` (
  `CID` int(11) NOT NULL,
  `O_ISBN` int(11) NOT NULL,
  `Check_out_date` datetime NOT NULL,
  `Due_date` datetime NOT NULL,
  `No_books` int(11) NOT NULL,
  `is_overdue` tinyint(4) NOT NULL,
  `grace_date` datetime NOT NULL,
  `Enum` int(11) NOT NULL,
  PRIMARY KEY (`O_ISBN`),
  UNIQUE KEY `CID_UNIQUE` (`CID`),
  KEY `enum_idx` (`Enum`),
  CONSTRAINT `enumfk` FOREIGN KEY (`Enum`) REFERENCES `staff` (`Eno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checks_out`
--

LOCK TABLES `checks_out` WRITE;
/*!40000 ALTER TABLE `checks_out` DISABLE KEYS */;
/*!40000 ALTER TABLE `checks_out` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `LID` int(10) NOT NULL,
  `SSN` int(9) NOT NULL,
  `Fname` varchar(45) NOT NULL,
  `Mname` varchar(45) NOT NULL,
  `Lname` varchar(45) NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `MType` varchar(20) NOT NULL,
  `HAddr` varchar(45) NOT NULL,
  `CAddr` varchar(45) NOT NULL,
  `Valid_thru` date NOT NULL,
  `Validity` varchar(3) NOT NULL,
  PRIMARY KEY (`LID`),
  UNIQUE KEY `SSN_UNIQUE` (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `NID` int(11) NOT NULL,
  `Ret_date` datetime NOT NULL,
  `NType` varchar(45) NOT NULL,
  `NTMType` varchar(45) NOT NULL,
  `Enum` int(11) DEFAULT NULL,
  PRIMARY KEY (`NID`),
  KEY `enumfk_idx` (`Enum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `Eno` int(11) NOT NULL,
  `SName` varchar(45) NOT NULL,
  `job_type` varchar(45) NOT NULL,
  PRIMARY KEY (`Eno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-17 17:11:01
