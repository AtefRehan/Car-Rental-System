-- Creating the User table
CREATE TABLE `User`
(
    `id`           BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username`     VARCHAR(50) UNIQUE  NOT NULL,
    `password`     VARCHAR(255)        NOT NULL,
    `email`        VARCHAR(100) UNIQUE NOT NULL,
    `role`         VARCHAR(50) NOT NULL,
    `first_name`   VARCHAR(50),
    `last_name`    VARCHAR(50),
    `phone_number` VARCHAR(20)
);

-- Creating the Car table
CREATE TABLE `Car`
(
    `id`                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    `brand`                VARCHAR(50)        NOT NULL,
    `model`               VARCHAR(50)        NOT NULL,
    `year`                INT                NOT NULL,
    `vin`                 VARCHAR(50) UNIQUE NOT NULL,
    `price_per_day`       DECIMAL(10, 2)     NOT NULL,
    `availability_status` VARCHAR(50) NOT NULL,
    `fuel_type`           VARCHAR(50) NOT NULL,
    `transmission`        VARCHAR(50) NOT NULL,
    `seating_capacity`    INT                NOT NULL,
    `color`               VARCHAR(30)
);

-- Creating the Rental table
CREATE TABLE `Rental`
(
    `id`                BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id`           BIGINT         NOT NULL,
    `car_id`            BIGINT         NOT NULL,
    `rental_start_date` DATE           NOT NULL,
    `rental_end_date`   DATE           NOT NULL,
    `rental_status`     VARCHAR(50) NOT NULL,
    `total_amount`      DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
    FOREIGN KEY (`car_id`) REFERENCES `Car` (`id`)
);

-- Creating the Payment table
CREATE TABLE `Payment`
(
    `id`             BIGINT AUTO_INCREMENT PRIMARY KEY,
    `rental_id`      BIGINT         NOT NULL,
    `payment_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `amount`         DECIMAL(10, 2) NOT NULL,
    `payment_method` VARCHAR(50) NOT NULL,
    `payment_status` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`rental_id`) REFERENCES `Rental` (`id`)
);

-- Creating the Maintenance table
CREATE TABLE `Maintenance`
(
    `id`               BIGINT AUTO_INCREMENT PRIMARY KEY,
    `car_id`           BIGINT NOT NULL,
    `maintenance_date` DATE   NOT NULL,
    `description`      VARCHAR(255),
    `cost`             DECIMAL(10, 2),
    FOREIGN KEY (`car_id`) REFERENCES `Car` (`id`)
);

-- Creating the Review table
CREATE TABLE `Review`
(
    `id`          BIGINT AUTO_INCREMENT PRIMARY KEY,
    `car_id`      BIGINT                               NOT NULL,
    `user_id`     BIGINT                               NOT NULL,
    `rating`      INT CHECK (`rating` BETWEEN 1 AND 5) NOT NULL,
    `comment`     VARCHAR(255),
    `review_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`car_id`) REFERENCES `Car` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
);