-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 juin 2024 à 01:00
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jee-exam`
--

-- --------------------------------------------------------

--
-- Structure de la table `contrat_de_location`
--

CREATE TABLE `contrat_de_location` (
  `ID` int(11) NOT NULL,
  `Date_debut` date NOT NULL,
  `Date_fin` date NOT NULL,
  `Loyer_mensuel` decimal(10,2) NOT NULL,
  `ID_Unite` int(11) DEFAULT NULL,
  `ID_Locataire` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `immeuble`
--

CREATE TABLE `immeuble` (
  `ID` int(11) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Nom` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `équipements` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `locataire`
--

CREATE TABLE `locataire` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(100) NOT NULL,
  `Prenom` varchar(100) NOT NULL,
  `Date_de_naissance` date NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `ID` int(11) NOT NULL,
  `Date_paiement` date NOT NULL,
  `Montant` decimal(10,2) NOT NULL,
  `ID_Contrat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `unite_de_location`
--

CREATE TABLE `unite_de_location` (
  `ID` int(11) NOT NULL,
  `Numero` varchar(50) NOT NULL,
  `Surface` decimal(10,2) NOT NULL,
  `nbr_piece` varchar(50) NOT NULL,
  `loyer` varchar(50) NOT NULL,
  `ID_Immeuble` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `role` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contrat_de_location`
--
ALTER TABLE `contrat_de_location`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Unite` (`ID_Unite`),
  ADD KEY `ID_Locataire` (`ID_Locataire`);

--
-- Index pour la table `immeuble`
--
ALTER TABLE `immeuble`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `locataire`
--
ALTER TABLE `locataire`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Contrat` (`ID_Contrat`);

--
-- Index pour la table `unite_de_location`
--
ALTER TABLE `unite_de_location`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Immeuble` (`ID_Immeuble`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contrat_de_location`
--
ALTER TABLE `contrat_de_location`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `immeuble`
--
ALTER TABLE `immeuble`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `locataire`
--
ALTER TABLE `locataire`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `unite_de_location`
--
ALTER TABLE `unite_de_location`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contrat_de_location`
--
ALTER TABLE `contrat_de_location`
  ADD CONSTRAINT `contrat_de_location_ibfk_1` FOREIGN KEY (`ID_Unite`) REFERENCES `unite_de_location` (`ID`),
  ADD CONSTRAINT `contrat_de_location_ibfk_2` FOREIGN KEY (`ID_Locataire`) REFERENCES `locataire` (`ID`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`ID_Contrat`) REFERENCES `contrat_de_location` (`ID`);

--
-- Contraintes pour la table `unite_de_location`
--
ALTER TABLE `unite_de_location`
  ADD CONSTRAINT `unite_de_location_ibfk_1` FOREIGN KEY (`ID_Immeuble`) REFERENCES `immeuble` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
