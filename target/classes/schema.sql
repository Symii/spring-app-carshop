CREATE DATABASE IF NOT EXISTS car_shop;
use car_shop;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adres` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES (1,'Warszawa Mokotow 55','anna@gmail.com',_binary '','Anna','Kowalska','$2a$12$/vLeO2WkzFQDF3l6UbqlaewDEAw.k.np5dh0SWi7CRD9xOlFexRUe','321234764'),(2,'Słupsk Szczecinska 21','michal@gmail.com',_binary '','Michał','Nowak','$2a$12$/vLeO2WkzFQDF3l6UbqlaewDEAw.k.np5dh0SWi7CRD9xOlFexRUe','567343223'),(3,'Gdańsk Wczasowa 5a','maria@gmail.com',_binary '','Maria','Wiśniewska','$2a$12$/vLeO2WkzFQDF3l6UbqlaewDEAw.k.np5dh0SWi7CRD9xOlFexRUe','690213433'),(4,NULL,'anna@gmail.com',_binary '\0','Anna','Kowalska',NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `engine`
--

DROP TABLE IF EXISTS `engine`;
CREATE TABLE `engine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacity` float DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `fuel_type` varchar(255) DEFAULT NULL,
  `horsepower` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `engine`
--

LOCK TABLES `engine` WRITE;
INSERT INTO `engine` VALUES (1,2,'2024-04-25 10:04:38.023865','diesel',252,'TFSI 2.0L'),(2,3,'2024-04-25 10:04:38.023865','diesel',286,'TDI 3.0L'),(3,2.5,'2024-04-25 10:04:38.023865','benzyna',400,'TFSI 2.5L'),(4,2,'2024-04-25 10:04:38.023865','diesel',204,'40 TDI'),(5,3,'2024-04-25 10:04:38.023865','benzyna',456,'TFSI 3.0L'),(6,2,'2024-05-16 12:42:41.000000','diesel',252,'TFSI 2.0L'),(7,3,'2024-05-16 12:42:41.000000','diesel',286,'TDI 3.0L'),(8,1.8,'2024-05-16 12:42:41.000000','benzyna',180,'TFSI 1.8L'),(9,2.5,'2024-05-16 12:42:41.000000','benzyna',230,'N52B25 2.5L'),(10,2.2,'2024-05-16 12:42:41.000000','diesel',190,'CDI 2.2L'),(11,2,'2024-05-16 12:42:41.000000','benzyna',190,'TFSI 2.0L'),(12,1.6,'2024-05-16 12:42:41.000000','benzyna',120,'VTi 1.6L'),(13,3.5,'2024-05-16 12:42:41.000000','benzyna',310,'VQ35DE 3.5L'),(14,2.4,'2024-05-16 12:42:41.000000','benzyna',190,'K24Z3 2.4L'),(15,1.5,'2024-05-16 12:42:41.000000','diesel',110,'1.5L TDI'),(16,3,'2024-06-11 18:26:55.284436','diesel',286,'TDI 3.0L'),(18,3,'2024-06-11 18:30:31.280107','diesel',286,'TDI 3.0L'),(21,1896,'2024-06-11 19:04:31.363223','Diesel',130,'2.0 TDI'),(22,3,'2024-06-11 19:07:55.374215','diesel',286,'TDI 3.0L'),(23,3,'2024-06-11 19:23:02.913431','diesel',286,'TDI 3.0L'),(24,1896,'2024-06-11 19:26:49.189821','Diesel',130,'2.0 TDI');
UNLOCK TABLES;

--
-- Table structure for table `car`
--
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `damaged` bit(1) DEFAULT NULL,
  `description` text,
  `gear_type` varchar(255) DEFAULT NULL,
  `mileage` int DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `year_produced` int DEFAULT NULL,
  `engine_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3eecoa7gmdkpx4vtj0dymbhr2` (`engine_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKnednv54lgu9rfucgemr5eal0j` FOREIGN KEY (`engine_id`) REFERENCES `engine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
INSERT INTO `car` VALUES (1,'Audi','czarny',_binary '\0','Dobre auto kontak tel: 123456789','manualna',133400,'A4 B8',79500,2017,1,1),(3,'Audi','biały',_binary '\0','Do sprzedania eleganckie Audi A4 B9 z 2020 roku w kolorze białym. Samochód w doskonałym stanie, zadbane wnętrze i imponujące osiągi. Idealny wybór dla osób ceniących styl, komfort i niezawodność. Odkryj świat klasy premium z tym wyjątkowym modelem Audi A4.','automatyczna',67000,'A4 B9',99980,2020,2,2),(24,'Audi','niebieski',_binary '\0','Audi A3 z roku 2019, w kolorze niebieskim. Niski przebieg, bez uszkodzeń.','manualna',74222,'A3',79500,2017,3,2),(25,'BMW','czarny',_binary '','BMW Serii 3 z roku 2015, w kolorze czarnym. Posiada pewne uszkodzenia.','automatyczna',55000,'3 Series',99980,2020,4,2),(26,'Mercedes','srebrny',_binary '\0','Mercedes-Benz C-Class z roku 2018, w kolorze srebrnym. Bardzo dobrze utrzymany.','manualna',92000,'C-Class',85000,2018,5,2),(27,'Volkswagen','czerwony',_binary '\0','Volkswagen Golf z roku 2017, w kolorze czerwonym. Bez większych usterek.','manualna',80000,'Golf',72000,2017,6,1),(28,'Ford','biały',_binary '','Ford Focus z roku 2016, w kolorze białym. Posiada uszkodzenia po wypadku.','automatyczna',66000,'Focus',60000,2016,7,2),(29,'Toyota','zielony',_binary '\0','Toyota Corolla z roku 2019, w kolorze zielonym. Stan bardzo dobry, regularnie serwisowana.','manualna',68000,'Corolla',85000,2019,8,1),(30,'Honda','żółty',_binary '','Honda Civic z roku 2014, w kolorze żółtym. Wymaga naprawy mechanicznej.','automatyczna',42000,'Civic',35000,2014,9,2),(31,'Lexus','granatowy',_binary '\0','Lexus IS z roku 2017, w kolorze granatowym. Bez jakichkolwiek usterek.','manualna',88000,'IS',95000,2017,10,2),(32,'Hyundai','pomarańczowy',_binary '\0','Hyundai i30 z roku 2018, w kolorze pomarańczowym. Stan bardzo dobry, jedynie kilka rys.','manualna',57000,'i30',58000,2018,11,1),(33,'Kia','fioletowy',_binary '','Kia Sportage z roku 2015, w kolorze fioletowym. Posiada mechaniczne problemy.','automatyczna',71000,'Sportage',42000,2015,12,1),(42,'BMW','czarny',_binary '\0','Dobre auto kontak tel: 123456789','manualna',364189,'X5',21500,2007,23,2),(43,'Volkswagen',NULL,_binary '\0','super auto stan idealny brak rdzy i grzyba','Manualna',0,'PASSAT B5',4500,0,24,1);
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `points` smallint DEFAULT NULL,
  `review_message` varchar(255) DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoie88l9xdqjv41ym8c1s7valq` (`car_id`),
  KEY `FKgce54o0p6uugoc2tev4awewly` (`customer_id`),
  CONSTRAINT `FKgce54o0p6uugoc2tev4awewly` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKoie88l9xdqjv41ym8c1s7valq` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `car_image`
--
DROP TABLE IF EXISTS `car_image`;
CREATE TABLE `car_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_id` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `car_image_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `car_image`
--

LOCK TABLES `car_image` WRITE;
INSERT INTO `car_image` VALUES (1,1,'assets/img/cars/car-1-1.webp'),(2,3,'assets/img/cars/car-3-1.webp'),(3,24,'assets/img/cars/car-24-1.webp'),(4,25,'assets/img/cars/car-25-1.webp'),(5,26,'assets/img/cars/car-26-1.webp'),(6,27,'assets/img/cars/car-27-1.webp'),(7,28,'assets/img/cars/car-28-1.webp'),(8,29,'assets/img/cars/car-29-1.webp'),(9,30,'assets/img/cars/car-30-1.webp'),(10,31,'assets/img/cars/car-31-1.webp'),(11,32,'assets/img/cars/car-32-1.webp'),(12,33,'assets/img/cars/car-33-1.webp'),(13,1,'assets/img/cars/car-1-2.webp'),(14,42,'assets/img/cars/car-42-1.jpg'),(15,43,'assets/img/cars/car-43-1.webp');
UNLOCK TABLES;










--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'ROLE_EMPLOYEE'),(2,'ROLE_MANAGER'),(3,'ROLE_ADMIN');
UNLOCK TABLES;


--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKk38yo1t6hqkeo4pf46u0t8t0w` (`user_id`),
  CONSTRAINT `FKk38yo1t6hqkeo4pf46u0t8t0w` FOREIGN KEY (`user_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(2,2),(3,1),(3,2),(3,3);
UNLOCK TABLES;