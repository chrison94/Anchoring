-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 18. Nov 2018 um 17:56
-- Server-Version: 10.1.35-MariaDB
-- PHP-Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `proteindatabase`
--
CREATE DATABASE IF NOT EXISTS `proteindatabase` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proteindatabase`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `accessions`
--

CREATE TABLE `accessions` (
  `id` int(11) NOT NULL,
  `fkHeaderId` int(11) NOT NULL,
  `name` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `accinfos`
--

CREATE TABLE `accinfos` (
  `id` int(11) NOT NULL,
  `moltype` varchar(300) DEFAULT NULL,
  `seqspec` varchar(300) DEFAULT NULL,
  `fkAccessionId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `authors`
--

CREATE TABLE `authors` (
  `id` int(11) NOT NULL,
  `fkRefinfoId` int(11) DEFAULT NULL,
  `name` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `classifications`
--

CREATE TABLE `classifications` (
  `id` int(11) NOT NULL,
  `fkProteinEntryId` int(11) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `features`
--

CREATE TABLE `features` (
  `id` int(11) NOT NULL,
  `fkProteinEntryId` int(11) NOT NULL,
  `featureType` varchar(90) DEFAULT NULL,
  `description` varchar(90) DEFAULT NULL,
  `seqSqc` varchar(90) DEFAULT NULL,
  `status` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `genetics`
--

CREATE TABLE `genetics` (
  `id` int(11) NOT NULL,
  `introns` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `headers`
--

CREATE TABLE `headers` (
  `id` int(11) NOT NULL,
  `uid` varchar(90) DEFAULT NULL,
  `createdDate` varchar(90) DEFAULT NULL,
  `seqRevDate` varchar(90) DEFAULT NULL,
  `txtRevDate` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `keywords`
--

CREATE TABLE `keywords` (
  `id` int(11) NOT NULL,
  `fkProteinEntryId` int(11) NOT NULL,
  `name` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `organism`
--

CREATE TABLE `organism` (
  `id` int(11) NOT NULL,
  `source` varchar(90) DEFAULT NULL,
  `common` varchar(90) DEFAULT NULL,
  `formal` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `proteinentries`
--

CREATE TABLE `proteinentries` (
  `id` int(11) NOT NULL,
  `sequence` varchar(300) DEFAULT NULL,
  `fkHeaderId` int(11) DEFAULT NULL,
  `fkProteinId` int(11) DEFAULT NULL,
  `fkOrganismId` int(11) DEFAULT NULL,
  `fkGeneticsId` int(11) DEFAULT NULL,
  `fkSummaryId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `proteins`
--

CREATE TABLE `proteins` (
  `id` int(11) NOT NULL,
  `name` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reference`
--

CREATE TABLE `reference` (
  `id` int(11) NOT NULL,
  `fkProteinEntryId` int(11) DEFAULT NULL,
  `contents` varchar(90) DEFAULT NULL,
  `note` varchar(90) DEFAULT NULL,
  `fkRefinfoId` int(11) DEFAULT NULL,
  `fkAccinfoId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `refinfos`
--

CREATE TABLE `refinfos` (
  `id` int(11) NOT NULL,
  `citation` varchar(300) DEFAULT NULL,
  `volume` varchar(300) DEFAULT NULL,
  `year` varchar(300) DEFAULT NULL,
  `pages` varchar(300) DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `summary`
--

CREATE TABLE `summary` (
  `id` int(11) NOT NULL,
  `length` varchar(90) DEFAULT NULL,
  `type` varchar(90) DEFAULT NULL,
  `status` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `xrefs`
--

CREATE TABLE `xrefs` (
  `id` int(11) NOT NULL,
  `fkRefinfoId` int(11) DEFAULT NULL,
  `db` varchar(90) DEFAULT NULL,
  `uid` varchar(90) DEFAULT NULL,
  `fkAccinfoId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `accessions`
--
ALTER TABLE `accessions`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `accinfos`
--
ALTER TABLE `accinfos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKovl2omfpol2po9vgiw3c2l15e` (`fkAccessionId`);

--
-- Indizes für die Tabelle `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `classifications`
--
ALTER TABLE `classifications`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `features`
--
ALTER TABLE `features`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `genetics`
--
ALTER TABLE `genetics`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `headers`
--
ALTER TABLE `headers`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `keywords`
--
ALTER TABLE `keywords`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `organism`
--
ALTER TABLE `organism`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `proteinentries`
--
ALTER TABLE `proteinentries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs5skj9tcu0cr7n498uq2u12r0` (`fkHeaderId`),
  ADD KEY `FKm4ha1kuumjis6saay1psx74yu` (`fkGeneticsId`),
  ADD KEY `FK51aarfldtollm0orcps54x2oc` (`fkOrganismId`),
  ADD KEY `FKhw4tawu693s3ovlsvvtlnd60k` (`fkProteinId`),
  ADD KEY `FKgmmdoclkakeqxc2m03bl47pbu` (`fkSummaryId`);

--
-- Indizes für die Tabelle `proteins`
--
ALTER TABLE `proteins`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `reference`
--
ALTER TABLE `reference`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `refinfos`
--
ALTER TABLE `refinfos`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `summary`
--
ALTER TABLE `summary`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `xrefs`
--
ALTER TABLE `xrefs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `accessions`
--
ALTER TABLE `accessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `accinfos`
--
ALTER TABLE `accinfos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `authors`
--
ALTER TABLE `authors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `classifications`
--
ALTER TABLE `classifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `features`
--
ALTER TABLE `features`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `genetics`
--
ALTER TABLE `genetics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `headers`
--
ALTER TABLE `headers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `keywords`
--
ALTER TABLE `keywords`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `organism`
--
ALTER TABLE `organism`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `proteinentries`
--
ALTER TABLE `proteinentries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `proteins`
--
ALTER TABLE `proteins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `reference`
--
ALTER TABLE `reference`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `refinfos`
--
ALTER TABLE `refinfos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `summary`
--
ALTER TABLE `summary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `xrefs`
--
ALTER TABLE `xrefs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `accessions`
--
ALTER TABLE `accessions`
  ADD CONSTRAINT `FK2w2dcdts4meho0wk2aikgs41o` FOREIGN KEY (`fkHeaderid`) REFERENCES `headers` (`id`);

--
-- Constraints der Tabelle `accinfos`
--
ALTER TABLE `accinfos`
  ADD CONSTRAINT `FKovl2omfpol2po9vgiw3c2l15e` FOREIGN KEY (`fkAccessionId`) REFERENCES `accessions` (`id`);

--
-- Constraints der Tabelle `authors`
--
ALTER TABLE `authors`
  ADD CONSTRAINT `FK5j3w1nwtao64adby3f9vncsip` FOREIGN KEY (`fkRefinfoId`) REFERENCES `refinfos` (`id`);

--
-- Constraints der Tabelle `classifications`
--
ALTER TABLE `classifications`
  ADD CONSTRAINT `FKcsmjv4lpu4kruejkud7bckcof` FOREIGN KEY (`fkProteinEntryId`) REFERENCES `proteinentries` (`id`);

--
-- Constraints der Tabelle `features`
--
ALTER TABLE `features`
  ADD CONSTRAINT `FKfvl3l71sagphmmrt7boku9drn` FOREIGN KEY (`fkProteinEntryId`) REFERENCES `proteinentries` (`id`);

--
-- Constraints der Tabelle `keywords`
--
ALTER TABLE `keywords`
  ADD CONSTRAINT `FKh72dmw54hl5iotf5jed4q8vj6` FOREIGN KEY (`fkProteinEntryId`) REFERENCES `proteinentries` (`id`);

--
-- Constraints der Tabelle `proteinentries`
--
ALTER TABLE `proteinentries`
  ADD CONSTRAINT `FK51aarfldtollm0orcps54x2oc` FOREIGN KEY (`fkOrganismId`) REFERENCES `organism` (`id`),
  ADD CONSTRAINT `FKgmmdoclkakeqxc2m03bl47pbu` FOREIGN KEY (`fkSummaryId`) REFERENCES `summary` (`id`),
  ADD CONSTRAINT `FKhw4tawu693s3ovlsvvtlnd60k` FOREIGN KEY (`fkProteinId`) REFERENCES `proteins` (`id`),
  ADD CONSTRAINT `FKm4ha1kuumjis6saay1psx74yu` FOREIGN KEY (`fkGeneticsId`) REFERENCES `genetics` (`id`),
  ADD CONSTRAINT `FKs5skj9tcu0cr7n498uq2u12r0` FOREIGN KEY (`fkHeaderId`) REFERENCES `headers` (`id`);

--
-- Constraints der Tabelle `reference`
--
ALTER TABLE `reference`
  ADD CONSTRAINT `FK1r3neea2cm4naadfbuful2w5l` FOREIGN KEY (`fkAccinfoId`) REFERENCES `accinfos` (`id`),
  ADD CONSTRAINT `FKbplacwxlgt693050jjn4hsg0j` FOREIGN KEY (`fkProteinEntryId`) REFERENCES `proteinentries` (`id`),
  ADD CONSTRAINT `FKrfworny7luch2lqa39ujie1pd` FOREIGN KEY (`fkRefinfoId`) REFERENCES `refinfos` (`id`);

--
-- Constraints der Tabelle `xrefs`
--
ALTER TABLE `xrefs`
  ADD CONSTRAINT `FK5efvs8llmwyld5i8ddvoiq0vk` FOREIGN KEY (`fkRefinfoId`) REFERENCES `refinfos` (`id`),
  ADD CONSTRAINT `FKemhxm1jnh76jwrrr4p6ryhfpd` FOREIGN KEY (`fkAccinfoId`) REFERENCES `accinfos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
