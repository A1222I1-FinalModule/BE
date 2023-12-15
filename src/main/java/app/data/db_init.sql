create database fashion_shop;
use fashion_shop;

CREATE TABLE tag (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE news (
    id INT AUTO_INCREMENT NOT NULL,
    title LONGTEXT DEFAULT NULL,
    content LONGTEXT DEFAULT NULL,
    image LONGTEXT DEFAULT NULL,
    creator VARCHAR(255) DEFAULT NULL,
    tag_id INT DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tag_id)
        REFERENCES tag (id)
);

CREATE TABLE customer_type (
    id INT AUTO_INCREMENT NOT NULL,
    type_name VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE discount (
    discount_code VARCHAR(255) NOT NULL,
    `description` LONGTEXT DEFAULT NULL,
    reward_point INT DEFAULT 0,
    `condition` LONGTEXT DEFAULT NULL,
    begin_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    customer_type_id INT DEFAULT NULL,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id),
    PRIMARY KEY (discount_code)
);

CREATE TABLE customer (
    id VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) DEFAULT NULL,
    gender BOOL DEFAULT NULL,
    `point` INT DEFAULT 0,
    date_of_birth DATE NOT NULL,
    address LONGTEXT NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type_id INT DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (type_id)
        REFERENCES customer_type (id)
);

CREATE TABLE bill (
    id VARCHAR(255) NOT NULL,
    total INT NOT NULL,
    release_date DATETIME NOT NULL,
    customer_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (customer_id)
        REFERENCES customer (id),
    PRIMARY KEY (id)
);

CREATE TABLE product_category (
    id INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE size (
    id INT NOT NULL,
    size VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product (
    product_code VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    quantity INT DEFAULT 0,
    product_category_id INT NOT NULL,
    size_id INT NOT NULL,
    FOREIGN KEY (size_id)
        REFERENCES size (id),
    FOREIGN KEY (product_category_id)
        REFERENCES product_category (id),
    PRIMARY KEY (product_code)
);

CREATE TABLE bill_detail (
    id VARCHAR(255) NOT NULL,
    quantity INT DEFAULT 0,
    product_id VARCHAR(255) NOT NULL,
    bill_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (product_id)
        REFERENCES product (product_code),
    FOREIGN KEY (bill_id)
        REFERENCES bill (id),
    PRIMARY KEY (id)
);

CREATE TABLE `role` (
    id INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE notification (
    id INT NOT NULL,
    start_date DATETIME NOT NULL,
    content LONGTEXT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES `role` (id),
    PRIMARY KEY (id)
);

CREATE TABLE `user` (
    id VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES `role` (id),
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    address LONGTEXT NOT NULL,
    phone VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES `user` (id),
    PRIMARY KEY (id)
);