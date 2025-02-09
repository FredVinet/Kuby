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
                          `orders_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          `orders_date` timestamp NOT NULL,
                          `orders_status` integer DEFAULT 1 NOT NULL,
                          `orders_amount` DECIMAL(10,2) NOT NULL,
                          `id_localisation` integer NOT NULL,
                          FOREIGN KEY (`id_localisation`) REFERENCES `localisation` (`localisation_id`)
);



CREATE TABLE `order_items` (
                               `order_items_id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `id_order` integer NOT NULL,
                               `id_article` integer NOT NULL,
                               `order_items_quantity` integer NOT NULL,
                               `unit_price` DECIMAL(10,6) NOT NULL,
                               FOREIGN KEY (`id_order`) REFERENCES `orders` (`orders_id`),
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
    ('Vins Rouges', 'Vins de couleur rouge, produits à partir de divers cépages rouges.'),
    ('Vins Blancs', 'Vins de couleur blanche, souvent fabriqués à partir de raisins blancs.'),
    ('Vins Effervescents', 'Vins avec des bulles, produits principalement avec des raisins blancs.');

-- Insertion des cépages
INSERT INTO `grape` (`grape_name`, `grape_description`) VALUES
    ('Cabernet Sauvignon', 'Un cépage rouge populaire, connu pour son goût robuste.'),
    ('Chardonnay', 'Un cépage de raisin blanc utilisé pour produire des vins comme le Chardonnay.'),
    ('Pinot Noir', 'Un cépage rouge délicat, connu pour ses arômes fruités et floraux.');

INSERT INTO `article` (`article_name`, `article_description`, `article_yearprod`, `article_price`, `article_quantity_in`, `article_quantity_out`, `id_family`, `id_grape`) VALUES
    ('Cabernet Sauvignon 2020', 'Un vin rouge riche et puissant, parfait pour les repas de viande.', 2020, 25.50, 100, 0, 1, 1),
    ('Chardonnay 2021', 'Un vin blanc fruité, idéal pour les apéritifs.', 2021, 22.00, 150, 0, 2, 2),
    ('Pinot Noir 2019', 'Un vin rouge léger et élégant, avec des notes de fruits rouges.', 2019, 28.00, 80, 0, 1, 3);

INSERT INTO `users` (`user_firstname`, `user_name`, `user_phone`, `user_mail`, `user_password`, `user_type`, `user_admin`) VALUES
    ('Pierre', 'Dupont', '0123456789', 'pierre.dupont@email.com', 'password_hashed', 1, FALSE),
    ('Sophie', 'Lemoine', '0987654321', 'sophie.lemoine@email.com', 'password_hashed', 1, FALSE);

-- Insertion des fournisseurs (user_type = 2)
INSERT INTO `users` (`user_firstname`, `user_name`, `user_phone`, `user_mail`, `user_password`, `user_type`, `user_admin`) VALUES
    ('Jacques', 'Martin', '0612345678', 'jacques.martin@supplier.com', 'password_hashed', 2, FALSE),
    ('Claire', 'Bernard', '0678901234', 'claire.bernard@supplier.com', 'password_hashed', 2, FALSE);

INSERT INTO `adress` (`adress_number`, `adress_country`, `adress_state`, `adress_name`, `adress_city`, `adress_code`) VALUES
    (12, 'France', 'Île-de-France', 'Rue de Paris', 'Paris', '75001'),
    (56, 'France', 'Provence-Alpes-Côte d Azur', 'Avenue des Vins', 'Nice', '06000'),
    (6, 'France', 'Finistère', 'Place Keruscun', 'Brest', '29200'),
    (27, 'France', 'Finistère', 'Douvez Bourg', 'Guipavas', '29490');

INSERT INTO `localisation` (`id_user`, `id_adress`) VALUES
    (1, 1),  
    (2, 2),
    (3, 3),  
    (4, 4);  

INSERT INTO `orders` (`orders_date`, `orders_status`, `orders_amount`, `id_localisation`) VALUES
    ('2025-02-08 12:30:00', 1, 51.00, 1),  
    ('2025-02-08 14:00:00', 1, 66.00, 2),
    ('2025-02-08 14:00:00', 1, 66.00, 3);

INSERT INTO `order_items` (`id_order`, `id_article`, `order_items_quantity`, `unit_price`) VALUES
    (1, 1, 2, 25.50),  
    (1, 2, 1, 22.00),  
    (2, 2, 3, 22.00),  
    (2, 3, 2, 28.00), 
    (3, 3, 2, 28.00);  

INSERT INTO `supplier_article` (`id_user`, `id_article`) VALUES
    (3, 1),  
    (4, 2); 