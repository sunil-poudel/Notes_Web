CREATE DATABASE IF NOT EXISTS `notes_tracker`;
USE `notes_tracker`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
    `id` int NOT NULL AUTO_INCREMENT,
    `date` varchar(45) DEFAULT NULL,
    `mood` varchar(30) DEFAULT NULL,
    `text` varchar(250) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

