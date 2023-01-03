CREATE TABLE IF NOT EXISTS `bit_quote`.`book` (
  `bo_id` INT NOT NULL AUTO_INCREMENT,
  `bo_name` VARCHAR(90) NOT NULL,
  `bo_author` VARCHAR(90) NOT NULL,
  `bo_photo` LONGBLOB NULL,
  PRIMARY KEY (`bo_id`))
ENGINE = InnoDB
