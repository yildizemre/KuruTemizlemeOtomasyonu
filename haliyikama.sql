-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 May 2019, 16:04:55
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `haliyikama`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `halilar`
--

CREATE TABLE `halilar` (
  `Id` int(11) NOT NULL,
  `MusteriAd` varchar(50) NOT NULL,
  `MusteriTelefon` varchar(13) NOT NULL,
  `HaliBoyut` varchar(13) NOT NULL,
  `ToplamFiyat` varchar(14) NOT NULL,
  `Durumu` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `halilar`
--

INSERT INTO `halilar` (`Id`, `MusteriAd`, `MusteriTelefon`, `HaliBoyut`, `ToplamFiyat`, `Durumu`) VALUES
(1, 'Yeni Musteri', '234234234', '45', '450', 'Yikandi'),
(2, 'Yeni Musteri', '45613165', '115', '720', 'Beklemede'),
(3, 'Yeni Musteri', '84613546485', '123', '85678', 'Siparis Alindi'),
(4, 'Giden Musteri', '3424324234', '120', '780', 'Beklemede'),
(5, 'Yeni Musteri4', '84613546485', '123', '85678', 'Bekleme'),
(6, 'Giden Musteri3', '3424324234', '120', '780', 'Teslim Edildi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `KullaniciAd` varchar(255) NOT NULL,
  `Sifre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`Id`, `KullaniciAd`, `Sifre`) VALUES
(1, 'Deneme', '12');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `halilar`
--
ALTER TABLE `halilar`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `halilar`
--
ALTER TABLE `halilar`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
