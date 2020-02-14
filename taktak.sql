-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 13 Février 2020 à 17:32
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `taktak`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` varchar(10) NOT NULL,
  `prenom` varchar(12) DEFAULT NULL,
  `nom` varchar(12) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pswd` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

CREATE TABLE IF NOT EXISTS `avis` (
  `id_avis` varchar(10) NOT NULL,
  `date_avis` date DEFAULT NULL,
  `contenu` varchar(65) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `id_p` enum('id_client','','','') DEFAULT NULL,
  PRIMARY KEY (`id_avis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE IF NOT EXISTS `chauffeur` (
  `id_chauffeur` varchar(10) NOT NULL,
  `prenom` varchar(12) DEFAULT NULL,
  `nom` varchar(12) DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pswd` varchar(15) DEFAULT NULL,
  `email` varchar(28) DEFAULT NULL,
  `photo` varchar(28) DEFAULT NULL,
  `cin` varchar(8) DEFAULT NULL,
  `permis` varchar(28) DEFAULT NULL,
  `adresse` varchar(28) DEFAULT NULL,
  `statut` varchar(15) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_chauffeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` varchar(10) NOT NULL,
  `prenom` varchar(12) DEFAULT NULL,
  `nom` varchar(12) DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pswd` varchar(15) DEFAULT NULL,
  `email` varchar(28) DEFAULT NULL,
  `photo` varchar(28) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `colis`
--

CREATE TABLE IF NOT EXISTS `colis` (
  `id_colis` varchar(10) NOT NULL,
  `id_client` varchar(10) DEFAULT NULL,
  `id_transporteur` varchar(10) DEFAULT NULL,
  `colis` varchar(30) DEFAULT NULL,
  `reponse` varchar(10) DEFAULT NULL,
  `raison` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_colis`),
  KEY `fk_c` (`id_client`),
  KEY `fk_t` (`id_transporteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id_course` varchar(10) NOT NULL,
  `id_client` varchar(10) DEFAULT NULL,
  `id_chauffeur` varchar(10) DEFAULT NULL,
  `reponse` varchar(10) DEFAULT NULL,
  `raison` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_course`),
  KEY `fk_cc` (`id_client`),
  KEY `fk_tt` (`id_chauffeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

CREATE TABLE IF NOT EXISTS `localisation` (
  `id_localisation` varchar(10) NOT NULL,
  `date_loc` date DEFAULT NULL,
  `adresse_debut` varchar(20) DEFAULT NULL,
  `adresse_fin` varchar(20) DEFAULT NULL,
  `id_p` enum('id_chauffeur','id_transporteur','','') DEFAULT NULL,
  PRIMARY KEY (`id_localisation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

CREATE TABLE IF NOT EXISTS `offres` (
  `id_offre` varchar(10) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `code` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id_offre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE IF NOT EXISTS `reclamation` (
  `id_reclamation` varchar(10) NOT NULL,
  `date_reclamation` date DEFAULT NULL,
  `contenu` varchar(100) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `etat` varchar(14) DEFAULT NULL,
  `id_p` enum('id_client','id_admin','id_chauffeur','id_transporteur') DEFAULT NULL,
  PRIMARY KEY (`id_reclamation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `transporteur`
--

CREATE TABLE IF NOT EXISTS `transporteur` (
  `id_transporteur` varchar(10) NOT NULL,
  `prenom` varchar(12) DEFAULT NULL,
  `nom` varchar(12) DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `pswd` varchar(15) DEFAULT NULL,
  `email` varchar(28) DEFAULT NULL,
  `photo` varchar(28) DEFAULT NULL,
  `cin` varchar(8) DEFAULT NULL,
  `permis` varchar(28) DEFAULT NULL,
  `adresse` varchar(28) DEFAULT NULL,
  `statut` varchar(15) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transporteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE IF NOT EXISTS `voiture` (
  `immatricule` varchar(12) NOT NULL,
  `model` varchar(12) DEFAULT NULL,
  `cartegrise` varchar(28) DEFAULT NULL,
  `assurance` varchar(28) DEFAULT NULL,
  `date_mis_circulation` date DEFAULT NULL,
  `etat` varchar(14) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `id_tc` enum('id_chauffeur','id_transporteur','','') DEFAULT NULL,
  PRIMARY KEY (`immatricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `colis`
--
ALTER TABLE `colis`
  ADD CONSTRAINT `fk_c` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `fk_t` FOREIGN KEY (`id_transporteur`) REFERENCES `transporteur` (`id_transporteur`);

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_cc` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `fk_tt` FOREIGN KEY (`id_chauffeur`) REFERENCES `chauffeur` (`id_chauffeur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
