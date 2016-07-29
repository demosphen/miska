USE store_test;

DROP TABLE IF EXISTS `products`;

CREATE TABLE IF NOT EXISTS `products` (
  `id`          INT(11)   NOT NULL AUTO_INCREMENT,
  `name`        CHAR(255) NOT NULL,
  `description` TEXT      NOT NULL,
  `price`       BIGINT    NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
