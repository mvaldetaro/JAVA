CREATE DATABASE  IF NOT EXISTS `java_web` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `java_web`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: java_web
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assentos`
--

DROP TABLE IF EXISTS `assentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assentos` (
  `idassentos` int(11) NOT NULL AUTO_INCREMENT,
  `fk_idsala` int(11) DEFAULT NULL,
  `fila` char(1) DEFAULT NULL,
  `assento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idassentos`),
  UNIQUE KEY `idassentos_UNIQUE` (`idassentos`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assentos`
--

LOCK TABLES `assentos` WRITE;
/*!40000 ALTER TABLE `assentos` DISABLE KEYS */;
INSERT INTO `assentos` VALUES (1,1,'a',1),(2,1,'a',2),(3,1,'a',3),(4,1,'a',4),(5,1,'a',5),(6,1,'b',1),(7,1,'b',2),(8,1,'b',3),(9,1,'b',4),(10,1,'b',5),(11,1,'c',1),(12,1,'c',2),(13,1,'c',3),(14,1,'c',4),(15,1,'c',5),(16,2,'a',1),(17,2,'a',2);
/*!40000 ALTER TABLE `assentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idevento` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `descricao` longtext,
  `duracao` int(11) DEFAULT NULL,
  `faixa_etaria` varchar(45) DEFAULT NULL,
  `fk_idtipo_evento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idevento`),
  UNIQUE KEY `idevento_UNIQUE` (`idevento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Animais fantásticos e onde habitam','As aventuras do escritor Newt Scamander na sociedade secreta de bruxas e bruxos nova-iorquina 70 anos antes da leitura de seu livro por Harry Potter.',132,'12',1),(2,'Doutor Estranho','Um cirurgião com sua carreira destruída, volta a ter vontade de viver depois que um feiticeiro o treina para defender o mundo do mal',134,'12',1),(3,'Trolls','Ramo parte para uma jornada de descobertas e aventuras ao lado de Poppy, líder dos Trolls. Inicialmente inimigos, conforme os desafios são superados eles descobrem que no fundo combinam.',92,'livre',1),(4,'O Mágico de oz, o espetáculo- Teatro Ruth Escobar','A peça conta a história de Dorot,uma garotinha que se perde no Mundo de Oz e para conseguir o caminho de volta para sua casa precisa encontrar o Grande Mágico de Oz.',60,'livre',2),(5,'Segura o Velho!','O velho Josias que mora com seu filho Anacleto e sua Nora Zuleika, vive da mísera aposentadoria; um belo dia descobre os prazeres da vida depois que a medicina lançou um remédio milagroso (Viagra) e conhece uma prostituta a bela jovem. Sua Nora, cansada do comportamento e da convivência com o sogro resolve se livrar do velho.',70,'14',2),(6,'Engolindo Sapo pra um dia comer Perereca','Há quase sete anos seguidos em cartaz, agora no Teatro Bibi Ferreira, Renato Scarpin mostra as loucas relações de qualquer pessoa normal, além de personagens politicamente absurdos.',60,'12',2),(7,'A.NOTA - Negro Léo','Com cinco discos, o maranhense radicado no Rio tem se apresentado em palcos prestigiados, como o Cafe Oto (Londres) e o Counterflows Festival (Glasgow). Em 2015, sua canção, ”Você Não Vai Passar”, interpretada e gravada pela cantora Ava Rocha, foi premiada na categoria Novo Hit do Prêmio Multishow de Música Brasileira. Agora, Negro Léo lança seu sexto álbum, “Água Batizada”.',60,'14',3),(8,'Jerry Adriani','Jair Alves de Souza nasceu em 29 do janeiro de 1947, no bairro do Brás, em São Paulo. Tornou-se artisticamente conhecido com o nome de JERRY ADRIANI e iniciou vida como cantor profissional em 1964, com o LP ITALIANÍSSIMO. No mesmo ano gravou o LP CREDI A ME. Em 1965 estourou com UM GRANDE AMOR, primeiro LP gravado em português. . ',60,'16',3);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `idhistorico_compras` int(11) NOT NULL AUTO_INCREMENT,
  `fk_idsessao` int(11) NOT NULL,
  `fk_idsala` int(11) NOT NULL,
  `fk_idusuario` int(11) NOT NULL,
  `fk_idassento` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhistorico_compras`),
  UNIQUE KEY `idhistorico_compras_UNIQUE` (`idhistorico_compras`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,0,1,1,'2'),(2,1,0,4,7,'Comprado'),(3,1,0,4,5,'Comprado'),(4,1,0,4,2,'Comprado'),(5,1,1,4,3,'Comprado'),(6,1,1,4,6,'Comprado');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `idsala` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsala`),
  UNIQUE KEY `idsala_UNIQUE` (`idsala`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'01','Sala 01'),(2,'02','Sala 02'),(3,'03','Sala 03'),(4,'04','Sala 04'),(5,'05','Sala 05');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessao` (
  `idsessao` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `horario` time(1) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  `fk_idsala` int(11) DEFAULT NULL,
  `fk_idevento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsessao`),
  UNIQUE KEY `idsessao_UNIQUE` (`idsessao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
INSERT INTO `sessao` VALUES (1,'2016-12-10','15:30:00.0','12',1,1),(2,'2016-12-10','16:00:00.0','12',2,1),(3,'2016-12-10','18:00:00.0','12',1,1),(4,'2016-12-10','14:00:00.0','12',3,1),(5,'2016-12-10','21:00:00.0','12',1,1);
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_compra`
--

DROP TABLE IF EXISTS `status_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_compra` (
  `idstatus_compra` int(11) NOT NULL AUTO_INCREMENT,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstatus_compra`),
  UNIQUE KEY `idstatus_compra_UNIQUE` (`idstatus_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_compra`
--

LOCK TABLES `status_compra` WRITE;
/*!40000 ALTER TABLE `status_compra` DISABLE KEYS */;
INSERT INTO `status_compra` VALUES (1,'Em Andamento'),(2,'Efetuado'),(3,'Vencido'),(4,'Em aberto');
/*!40000 ALTER TABLE `status_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_evento`
--

DROP TABLE IF EXISTS `tipo_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_evento` (
  `idtipo_evento` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `descricao` longtext,
  PRIMARY KEY (`idtipo_evento`),
  UNIQUE KEY `idtipo_evento_UNIQUE` (`idtipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_evento`
--

LOCK TABLES `tipo_evento` WRITE;
/*!40000 ALTER TABLE `tipo_evento` DISABLE KEYS */;
INSERT INTO `tipo_evento` VALUES (1,'Cinema','Sessões de filmes'),(2,'Teatro','Peças de teatro'),(3,'Shows','Espetaculos musicais e outros');
/*!40000 ALTER TABLE `tipo_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mv@mail.com','Magno Valdetaro','123456'),(2,'teste@mail.com','Teste User','123456'),(3,'user@mail.com','Userino','123456'),(4,'magno@mail.com','Magno Valdetaro','a1s2d3f4#'),(6,'mvo@mail.com','Magno Valdetaro','a1s2d3f4#');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11 22:33:56
