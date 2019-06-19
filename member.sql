-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.15-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- temp 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `temp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `temp`;

-- 테이블 temp.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `mNumber` int(11) NOT NULL AUTO_INCREMENT,
  `mName` varchar(12) DEFAULT NULL,
  `mIdenti` varchar(16) DEFAULT NULL,
  `mPass` varchar(32) DEFAULT NULL,
  `mDate` timestamp NULL DEFAULT current_timestamp(),
  `mGrade` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`mNumber`),
  UNIQUE KEY `mIdenti` (`mIdenti`),
  UNIQUE KEY `mName` (`mName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='This is member table.';

-- 테이블 데이터 temp.member:~11 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`mNumber`, `mName`, `mIdenti`, `mPass`, `mDate`, `mGrade`) VALUES
	(1, 'Narae', 'narae', '1q2w3e4r!', '2019-06-18 11:22:13', 9),
	(2, 'Bada', 'mysea', '1q2w3e4r!', '2019-06-18 11:25:19', 1),
	(3, 'Mirinae', 'milkyway', '1q2w3e4r!', '2019-06-18 11:30:07', 5),
	(4, 'Gureum', 'cloudy', '#333Cl0udy!', '2019-06-18 11:30:07', 1),
	(5, 'Sarang', 'luvme', '1Q2W3E##', '2019-06-18 11:30:07', 1),
	(6, 'Dalbyeol', 'moonstar', 'lua4t1c!', '2019-06-18 11:30:07', 3),
	(7, 'Yuri', 'yuriyuri', '!q@w#e!!!', '2019-06-18 11:30:07', 1),
	(8, 'Luna', 'luvluna', 'Lun4t1c!', '2019-06-18 14:50:34', 3),
	(9, 'Sora', 'luvsora', '!q@w#e123!', '2019-06-18 14:50:54', 4),
	(10, 'Saetbyeol', 'twinklestar', '#Star4u!@#', '2019-06-18 15:43:56', 7),
	(11, 'Sena', 'sena22', '#sena22!', '2019-06-19 10:16:48', 4);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
