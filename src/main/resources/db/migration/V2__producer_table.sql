CREATE TABLE `producer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `bio` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci