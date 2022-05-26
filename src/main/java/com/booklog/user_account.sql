-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 26, 2022 at 02:35 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `educapedia`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
CREATE TABLE IF NOT EXISTS `user_account` (
  `username` varchar(45) NOT NULL,
  `secretkey` varchar(45) NOT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contactNo` varchar(12) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5510 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`username`, `secretkey`, `user_id`, `firstname`, `lastname`, `email`, `contactNo`) VALUES
('DbroStudio', 'UOK-UOK', 5491, 'Dumindu', 'Patabandi', 'dppatabandi@gmail.com', '0715236895'),
('Chamma', '123456', 5508, 'Chamuditha', 'Heshan', 'heshan@gmail.com', '5654654'),
('SamanK', 'UOKUOK99', 5509, 'Saman', 'Ishan', 'saman@gmail.com', '0782266354'),
('Vidwanpower98', '12345', 5499, 'Dulmith', 'Vidwan', 'vidwan@gmail.com', '0715462354'),
('C', 'D', 5500, 'A', 'B', 'E', 'F'),
('SKbro', 'password', 5507, 'Saman', 'Kumara', 'samank@gmail.com', '077882356');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
