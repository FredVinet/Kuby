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
                           `article_yearprod` integer,
                           `article_price` DECIMAL(10, 2),
                           `article_quantity_in` integer,
                           `article_quantity_out` integer,
                           `id_family` integer NOT NULL,
                           `id_grape` integer NOT NULL,
                           FOREIGN KEY (`id_family`) REFERENCES `family` (`family_id`),
                           FOREIGN KEY (`id_grape`) REFERENCES `grape` (`grape_id`)
);

CREATE TABLE `users` (
    `user_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `user_firstname` varchar(50),
    `user_name` varchar(50) NOT NULL,
    `user_phone` varchar(50),
    `user_mail` varchar(50) NOT NULL,
    `user_password` char(255),
    `user_type` int NOT NULL
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
    FOREIGN KEY (`id_user`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`id_adress`) REFERENCES `adress` (`adress_id`) ON DELETE CASCADE
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
    `orders_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `orders_date` timestamp NOT NULL,
    `orders_status` ENUM('Payée', 'En cours de livraison', 'Livrée','Sortie stock') DEFAULT 'Payée' NOT NULL,
    `orders_amount` DECIMAL(10,2) NOT NULL,
    `id_localisation` integer NOT NULL,
    FOREIGN KEY (`id_localisation`) REFERENCES `localisation` (`localisation_id`) ON DELETE CASCADE
);

CREATE TABLE `order_items` (
                               `order_items_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `id_order` integer NOT NULL,
                               `id_article` integer NOT NULL,
                               `order_items_quantity` integer NOT NULL,
                               `unit_price` DECIMAL(10,6) NOT NULL,
                               FOREIGN KEY (`id_order`) REFERENCES `orders` (`orders_id`) ON DELETE CASCADE,
                               FOREIGN KEY (`id_article`) REFERENCES `article` (`article_id`)
);

CREATE TABLE `supplier_article` (
    `supplier_article_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `id_user` integer NOT NULL,
    `id_article` integer NOT NULL,
    FOREIGN KEY (`id_user`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`id_article`) REFERENCES `article` (`article_id`)
);

-- Insertion des familles de vin
INSERT INTO `family` (`family_name`, `family_description`) VALUES
('Rouge', 'Vin rouge issu de raisins noirs'),
('Blanc', 'Vin blanc élaboré à partir de raisins blancs'),
('Rosé', 'Vin rosé obtenu par macération limitée'),
('Pétillant', 'Vin effervescent avec bulles'),
('Dessert', 'Vin sucré pour accompagner les desserts');

-- Insertion des types de raisins
INSERT INTO `grape` (`grape_name`, `grape_description`) VALUES
('Cabernet Sauvignon', 'Cépage rouge tannique'),
('Merlot', 'Cépage rouge souple et fruité'),
('Chardonnay', 'Cépage blanc élégant'),
('Sauvignon Blanc', 'Cépage blanc frais et aromatique'),
('Syrah', 'Cépage rouge épicé et puissant');

-- Insertion des utilisateurs (2 type 1, 2 type 2, 1 type 3)
INSERT INTO `users` (`user_firstname`, `user_name`, `user_phone`, `user_mail`, `user_password`, `user_type`) VALUES
('Jean', 'Dupont', '0123456789', 'jean.dupont@mail.com', '$2a$10$SwfT.uq8w/R0OnI1Z/adluKN3ciJ.R0L1DsBHTWOGkpQo7ByB4sXq', 1),
('Marie', 'Curie', '0234567890', 'marie.curie@mail.com', '$2a$10$Z.X0M9T8VQlPe.HP/Fn9h.YuYa7FHxwvyeuI0.lBj/JU4eq4V/Y3K', 1),
('Paul', 'Durand', '0345678901', 'paul.durand@mail.com', '$2a$10$/S5WZhsLeSuUGpjjDLTIk.uA.SjXk4iT0Wex2BvWZpyCu2Xb4pN2y', 2),
('Sophie', 'Lemoine', '0456789012', 'sophie.lemoine@mail.com', '$2a$10$uwsqmBHoHxTOLEwVdwxpEuEiBdNwCAQmCcdBy0jICIqNLtLOMY8Ey', 2),
('admin', 'istrateur', '0567890123', 'admin@mail.com', '$2a$10$VX80Z6vu301YR4aM1zeWnuW7usGkWoghulBq42ar0WPwjENUn4B9q', 3);

-- Insertion des adresses (2 par utilisateur)
INSERT INTO `adress` (`adress_number`, `adress_country`, `adress_state`, `adress_name`, `adress_city`, `adress_code`) VALUES
(10, 'France', 'Île-de-France', 'Rue de Paris', 'Paris', '75001'),
(20, 'France', 'Île-de-France', 'Avenue des Champs', 'Paris', '75008'),
(15, 'France', 'Normandie', 'Rue des Fleurs', 'Rouen', '76000'),
(25, 'France', 'Normandie', 'Boulevard Maritime', 'Le Havre', '76600'),
(30, 'France', 'Provence', 'Chemin du Soleil', 'Nice', '06000'),
(40, 'France', 'Provence', 'Rue des Lavandes', 'Marseille', '13000'),
(50, 'France', 'Alsace', 'Route des Vins', 'Strasbourg', '67000'),
(60, 'France', 'Alsace', 'Rue du Riesling', 'Colmar', '68000'),
(70, 'France', 'Bordeaux', 'Cours de l''Intendance', 'Bordeaux', '33000'),
(80, 'France', 'Bordeaux', 'Quai des Chartrons', 'Bordeaux', '33000');

-- Association des adresses avec les utilisateurs (localisation)
INSERT INTO `localisation` (`id_user`, `id_adress`) VALUES
(1, 1), (1, 2),
(2, 3), (2, 4),
(3, 5), (3, 6),
(4, 7), (4, 8),
(5, 9), (5, 10);

-- Insertion des articles (vins)
INSERT INTO `article` (`article_name`, `article_description`, `article_yearprod`, `article_price`, `article_quantity_in`, `article_quantity_out`, `id_family`, `id_grape`) VALUES
('Château Margaux', 'Grand cru rouge', 2015, 250.00, 200, 0, 1, 1),
('Petrus', 'Vin rouge rare', 2018, 3000.00, 200, 0, 1, 2),
('Dom Pérignon', 'Champagne prestige', 2012, 180.00, 200, 0, 4, 3),
('Chablis Premier Cru', 'Vin blanc minéral', 2020, 45.00, 200, 0, 2, 4),
('Côte Rôtie', 'Syrah d''exception', 2019, 85.00, 200, 0, 1, 5),
('Château Latour', 'Vin rouge prestigieux', 2016, 320.00, 200, 0, 1, 1),
('Opus One', 'Vin rouge californien', 2017, 350.00, 200, 0, 1, 2),
('Ruinart Blanc de Blancs', 'Champagne de Chardonnay', 2018, 90.00, 200, 0, 4, 3),
('Pouilly-Fumé', 'Vin blanc aromatique', 2020, 40.00, 200, 0, 2, 4),
('Hermitage La Chapelle', 'Vin rouge puissant', 2019, 120.00, 200, 0, 1, 5),
('Sancerre', 'Vin blanc sec et minéral', 2021, 30.00, 200, 0, 2, 4),
('Gevrey-Chambertin', 'Pinot Noir d''exception', 2018, 140.00, 200, 0, 1, 1),
('Château d''Yquem', 'Vin liquoreux renommé', 2015, 450.00, 200, 0, 5, 3),
('Beaujolais Nouveau', 'Vin jeune et fruité', 2023, 15.00, 200, 0, 1, 2),
('Tavel', 'Vin rosé corsé', 2022, 25.00, 200, 0, 3, 5);

-- Insertion des stocks
INSERT INTO `stock` (`stock_date_in`, `stock_date_out`, `stock_quantity_in`, `stock_quantity_out`, `id_article`) VALUES
(NOW(), NULL, 200, 0, 1),
(NOW(), NULL, 200, 0, 2),
(NOW(), NULL, 200, 0, 3),
(NOW(), NULL, 200, 0, 4),
(NOW(), NULL, 200, 0, 5),
(NOW(), NULL, 200, 0, 6),
(NOW(), NULL, 200, 0, 7),
(NOW(), NULL, 200, 0, 8),
(NOW(), NULL, 200, 0, 9),
(NOW(), NULL, 200, 0, 10),
(NOW(), NULL, 200, 0, 11),
(NOW(), NULL, 200, 0, 12),
(NOW(), NULL, 200, 0, 13),
(NOW(), NULL, 200, 0, 14),
(NOW(), NULL, 200, 0, 15);

-- Insertion des fournisseurs (les utilisateurs type 2)
INSERT INTO `supplier_article` (`id_user`, `id_article`) VALUES
(3, 1), (3, 2), (4, 3), (4, 4), (4, 5),
(3, 6), (3, 7), (3, 8), (3, 9), (3, 10),
(4, 11), (4, 12), (4, 13), (4, 14), (4, 15);

-- Insertion des commandes (2 par utilisateur)
INSERT INTO `orders` (`orders_date`, `orders_status`, `orders_amount`, `id_localisation`) VALUES
(NOW(), 'Payée', 500.00, 1),
(NOW(), 'Livrée', 800.00, 2),
(NOW(), 'Payée', 1200.00, 3),
(NOW(), 'En cours de livraison', 900.00, 4),
(NOW(), 'Sortie stock', 1500.00, 5);

-- Insertion des articles commandés (order_items)
INSERT INTO `order_items` (`id_order`, `id_article`, `order_items_quantity`, `unit_price`) VALUES
(1, 1, 2, 250.00),
(2, 3, 4, 180.00),
(3, 5, 1, 85.00),
(4, 2, 1, 3000.00),
(5, 4, 5, 45.00);