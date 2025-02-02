-- Creation of tables
CREATE TABLE `family` (
                          `family_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          `family_name` VARCHAR(50) NOT NULL,
                          `family_description` varchar(500)
);

CREATE TABLE `grape` (
                         `grape_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `grape_name` VARCHAR(50) NOT NULL,
                         `grape_description` varchar(500)
);

CREATE TABLE `article` (
                           `article_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `article_name` varchar(50) NOT NULL,
                           `article_description` varchar(500),
                           `article_grape` varchar(200),
                           `article_yearprod` integer,
                           `article_price` integer NOT NULL,
                           `id_family` integer NOT NULL,
                           `id_grape` integer NOT NULL,
                           FOREIGN KEY (`id_family`) REFERENCES `family` (`family_id`),
                           FOREIGN KEY (`id_grape`) REFERENCES `grape` (`grape_id`)
);

CREATE TABLE `users` (
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
                          `adress_country` varchar(100) NOT NULL,
                          `adress_state` varchar(100) NOT NULL,
                          `adress_name` varchar(100) NOT NULL,
                          `adress_city` varchar(50) NOT NULL,
                          `adress_code` varchar(5) NOT NULL
);

CREATE TABLE `localisation` (
                                `localisation_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                `id_user` integer NOT NULL,
                                `id_adress` integer NOT NULL,
                                FOREIGN KEY (`id_user`) REFERENCES `users` (`user_id`),
                                FOREIGN KEY (`id_adress`) REFERENCES `adress` (`adress_id`)
);

CREATE TABLE `stock` (
                         `stock_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `stock_date_in` TIMESTAMP NOT NULL,
                         `stock_date_out` TIMESTAMP,
                         `stock_quantity_in` integer NOT NULL,
                         `stock_quantity_out` integer,
                         `id_article` integer NOT NULL,
                         FOREIGN KEY (`id_article`) REFERENCES `article` (`article_id`)
);

CREATE TABLE `orders` (
                         `order_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `order_date` timestamp NOT NULL,
                         `order_status` int NOT NULL,
                         `id_localisation` integer NOT NULL,
                         FOREIGN KEY (`id_localisation`) REFERENCES `localisation` (`localisation_id`)
);

CREATE TABLE `order_items` (
                               `order_items_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `order_items_quantity` integer NOT NULL,
                               `id_order` integer NOT NULL,
                               `id_article` integer NOT NULL,
                               FOREIGN KEY (`id_order`) REFERENCES `orders` (`order_id`),
                               FOREIGN KEY (`id_article`) REFERENCES `article` (`article_id`)
);

CREATE TABLE `supplier_article` (
                                    `supplier_article_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                    `id_user` integer NOT NULL,
                                    `id_article` integer NOT NULL,
                                    FOREIGN KEY (`id_user`) REFERENCES `users` (`user_id`),
                                    FOREIGN KEY (`id_article`) REFERENCES `article` (`article_id`)
);

-- Inserting data
INSERT INTO `family` (`family_name`, `family_description`) VALUES
                                                               ('Red Wines', 'Wines that are red in color, made from a variety of red grapes.'),
                                                               ('White Wines', 'Wines that are white in color, usually made from white grapes.'),
                                                               ('Sparkling Wines', 'Effervescent wines made from various grapes.');

INSERT INTO `grape` (`grape_name`, `grape_description`) VALUES
                                                            ('Cabernet Sauvignon', 'A popular variety of red grape known for its robust flavor.'),
                                                            ('Chardonnay', 'A widely cultivated white wine grape used in the production of Chardonnay.'),
                                                            ('Pinot Noir', 'A red wine grape variety of the species Vitis vinifera.');

INSERT INTO `article` (`article_name`, `article_description`, `article_grape`, `article_yearprod`, `article_price`, `id_family`, `id_grape`) VALUES
                                                                                                                                                 ('2019 Napa Valley Cabernet', 'A rich and full-bodied red wine from Napa Valley.', 'Cabernet Sauvignon', 2019, 120, 1, 1),
                                                                                                                                                 ('2020 Chardonnay Reserve', 'A vibrant and smooth Chardonnay.', 'Chardonnay', 2020, 90, 2, 2),
                                                                                                                                                 ('2018 Classic Pinot Noir', 'A delicate and fruity Pinot Noir.', 'Pinot Noir', 2018, 110, 1, 3);

INSERT INTO `users` (`user_firstname`, `user_name`, `user_phone`, `user_mail`, `user_password`, `user_type`, `user_admin`) VALUES
                                                                                                                               ('John', 'Doe', '123-456-7890', 'john.doe@example.com', 'hashed_password', 1, TRUE),
                                                                                                                               ('Jane', 'Smith', '987-654-3210', 'jane.smith@example.com', 'hashed_password', 2, FALSE);

INSERT INTO `adress` (`adress_number`, `adress_country`, `adress_state`, `adress_name`, `adress_city`, `adress_code`) VALUES
                                                                                                                          (101, 'USA', 'California', 'Vine St', 'Napa', '94558'),
                                                                                                                          (202, 'France', 'Bordeaux', 'Chateau Rd', 'Bordeaux', '33000');

INSERT INTO `localisation` (`id_user`, `id_adress`) VALUES
                                                        (1, 1),
                                                        (2, 2);

INSERT INTO `stock` (`stock_date_in`, `stock_date_out`, `stock_quantity_in`, `stock_quantity_out`, `id_article`) VALUES
                                                                                                                     ('2022-01-01 00:00:00', '2022-01-10 00:00:00', 100, 10, 1),
                                                                                                                     ('2022-02-01 00:00:00', '2022-02-10 00:00:00', 150, 15, 2);

INSERT INTO `orders` (`order_date`, `order_status`, `id_localisation`) VALUES
                                                                          ('2022-03-01 00:00:00', 1, 1),
                                                                          ('2022-04-01 00:00:00', 2, 2);

INSERT INTO `order_items` (`order_items_quantity`, `id_order`, `id_article`) VALUES
                                                                                 (2, 1, 1),
                                                                                 (3, 2, 2);

INSERT INTO `supplier_article` (`id_user`, `id_article`) VALUES
                                                             (1, 1),
                                                             (2, 2);