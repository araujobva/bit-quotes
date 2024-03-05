CREATE TABLE IF NOT EXISTS `bit_quote`.`book` (
  `bo_id` INT NOT NULL AUTO_INCREMENT,
  `bo_name` VARCHAR(90) NOT NULL,
  `bo_author` VARCHAR(90) NOT NULL,
  `bo_photo` LONGBLOB NULL,
  `us_us_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`bo_id`),
  INDEX `fk_book_user1_idx` (`us_us_name` ASC) VISIBLE,
  UNIQUE INDEX `bo_name_UNIQUE` (`bo_name` ASC) VISIBLE,
  CONSTRAINT `fk_book_user1`
    FOREIGN KEY (`us_us_name`)
    REFERENCES `bit_quote`.`user` (`us_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB