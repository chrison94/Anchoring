-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 15. Dez 2018 um 16:43
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
-- Datenbank: `dbanchoring`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `accessions`
--

CREATE TABLE `accessions` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `fkHeaderid` bigint(11) DEFAULT NULL,
  `name` text,
  `fkAccInfoId` bigint(11) DEFAULT NULL,
  `accessions_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `accinfos`
--

CREATE TABLE `accinfos` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `moltype` text,
  `seqspec` text,
  `fkAccessionId` bigint(11) DEFAULT NULL,
  `accinfo_id` bigint(11) DEFAULT NULL,
  `fkAccInfoId` bigint(11) DEFAULT NULL,
  `fkReferenceId` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `authors`
--

CREATE TABLE `authors` (
  `id` bigint(11) NOT NULL,
  `fkRefinfoId` bigint(11) DEFAULT NULL,
  `name` text,
  `authors_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `classifications`
--

CREATE TABLE `classifications` (
  `id` bigint(11) NOT NULL,
  `fkProteinEntryId` bigint(11) DEFAULT NULL,
  `name` text,
  `classification_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `features`
--

CREATE TABLE `features` (
  `id` bigint(11) NOT NULL,
  `fkProteinEntryId` bigint(11) NOT NULL,
  `featureType` text,
  `description` text,
  `seqSqc` text,
  `status` text,
  `features_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `genetics`
--

CREATE TABLE `genetics` (
  `id` bigint(11) NOT NULL,
  `introns` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `headers`
--

CREATE TABLE `headers` (
  `id` bigint(11) NOT NULL,
  `uid` text,
  `createdDate` text,
  `seqRevDate` text,
  `txtRevDate` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `keywords`
--

CREATE TABLE `keywords` (
  `id` bigint(11) NOT NULL,
  `fkProteinEntryId` bigint(11) DEFAULT NULL,
  `name` text,
  `keywords_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `organism`
--

CREATE TABLE `organism` (
  `id` bigint(11) NOT NULL,
  `source` text,
  `common` text,
  `formal` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `proteinentries`
--

CREATE TABLE `proteinentries` (
  `id` bigint(11) NOT NULL,
  `sequence` text,
  `fkHeaderId` bigint(11) DEFAULT NULL,
  `fkProteinId` bigint(11) DEFAULT NULL,
  `fkOrganismId` bigint(11) DEFAULT NULL,
  `fkGeneticsId` bigint(11) DEFAULT NULL,
  `fkSummaryId` bigint(11) DEFAULT NULL,
  `fkProteinEntryId` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `proteins`
--

CREATE TABLE `proteins` (
  `id` bigint(11) NOT NULL,
  `name` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reference`
--

CREATE TABLE `reference` (
  `id` bigint(11) NOT NULL,
  `fkProteinEntryId` bigint(11) DEFAULT NULL,
  `contents` text,
  `note` text,
  `fkRefinfoId` bigint(11) DEFAULT NULL,
  `fkAccinfoId` bigint(11) DEFAULT NULL,
  `references_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `refinfos`
--

CREATE TABLE `refinfos` (
  `id` bigint(11) NOT NULL,
  `citation` text,
  `volume` text,
  `year` text,
  `pages` text,
  `title` text,
  `fkReferenceId` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `summary`
--

CREATE TABLE `summary` (
  `id` bigint(11) NOT NULL,
  `length` text,
  `type` text,
  `status` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `xrefs`
--

CREATE TABLE `xrefs` (
  `id` bigint(11) NOT NULL,
  `fkRefinfoId` bigint(11) DEFAULT NULL,
  `db` text,
  `uid` text,
  `fkAccinfoId` bigint(11) DEFAULT NULL,
  `xrefs_id` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `accessions`
--
ALTER TABLE `accessions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indizes für die Tabelle `accinfos`
--
ALTER TABLE `accinfos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `accinfos`
--
ALTER TABLE `accinfos`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `authors`
--
ALTER TABLE `authors`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `classifications`
--
ALTER TABLE `classifications`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `features`
--
ALTER TABLE `features`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `genetics`
--
ALTER TABLE `genetics`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `headers`
--
ALTER TABLE `headers`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `keywords`
--
ALTER TABLE `keywords`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `organism`
--
ALTER TABLE `organism`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `proteinentries`
--
ALTER TABLE `proteinentries`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `proteins`
--
ALTER TABLE `proteins`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `reference`
--
ALTER TABLE `reference`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `refinfos`
--
ALTER TABLE `refinfos`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `summary`
--
ALTER TABLE `summary`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `xrefs`
--
ALTER TABLE `xrefs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
