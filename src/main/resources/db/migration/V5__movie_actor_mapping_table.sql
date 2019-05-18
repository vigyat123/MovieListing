CREATE TABLE `movie_actor_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_id` bigint(20) DEFAULT NULL,
  `actor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci