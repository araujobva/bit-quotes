CREATE TABLE IF NOT EXISTS `bit_quote`.`user` (
  `us_name` VARCHAR(45) NOT NULL,
  `us_password` VARCHAR(45) NOT NULL,
  `us_administrator` TINYINT(1) NOT NULL,
  PRIMARY KEY (`us_name`))
ENGINE = InnoDB
