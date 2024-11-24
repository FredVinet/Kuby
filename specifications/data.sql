CREATE TABLE `article` (
  `article_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `article_name` varchar(50) NOT NULL,
  `article_description` varchar(500),
  `article_grape` varchar(200),
  `article_yearprod` integer,
  `article_price` integer NOT NULL,
  `id_family` integer NOT NULL
);

CREATE TABLE `family` (
  `family_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `family_name` VARCHAR(50) NOT NULL,
  `family_description` varchar(500)
);

CREATE TABLE `localisation` (
  `localisation_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `id_user` integer NOT NULL,
  `id_adress` integer NOT NULL
);

CREATE TABLE `stock` (
  `stock_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `stock_date_in` TIMESTAMP NOT NULL,
  `stock_date_out` TIMESTAMP NOT NULL,
  `stock_quantity_in` integer NOT NULL,
  `stock_quantity_out` integer NOT NULL,
  `id_article` integer
);

CREATE TABLE `user` (
  `user_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `user_firstname` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_phone` varchar(50),
  `user_mail` varchar(50) NOT NULL,
  `user_password` char(255),
  `user_type` int NOT NULL,
  `user_admin` boolean NOT NULL
);

CREATE TABLE `adress` (
  `adress_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `adress_number` integer NOT NULL,
  `adress_name` varchar(100) NOT NULL,
  `adress_city` varchar(50) NOT NULL,
  `adress_code` varchar(5) NOT NULL
);

CREATE TABLE `order` (
  `order_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NOT NULL,
  `order_status` int NOT NULL,
  `id_localisation` integer NOT NULL
);

CREATE TABLE `order_items` (
  `order_items_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `order_items_quantity` integer NOT NULL,
  `id_order` integer NOT NULL,
  `id_article` integer NOT NULL
);

ALTER TABLE `family` ADD FOREIGN KEY (`family_id`) REFERENCES `article` (`id_family`);

ALTER TABLE `article` ADD FOREIGN KEY (`article_id`) REFERENCES `stock` (`id_article`);

ALTER TABLE `article` ADD FOREIGN KEY (`article_id`) REFERENCES `order_items` (`id_article`);

ALTER TABLE `localisation` ADD FOREIGN KEY (`localisation_id`) REFERENCES `order` (`id_localisation`);

ALTER TABLE `user` ADD FOREIGN KEY (`user_id`) REFERENCES `localisation` (`id_user`);

ALTER TABLE `adress` ADD FOREIGN KEY (`adress_id`) REFERENCES `localisation` (`id_adress`);

ALTER TABLE `order` ADD FOREIGN KEY (`order_id`) REFERENCES `order_items` (`id_order`);
