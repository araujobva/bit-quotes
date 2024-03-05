CREATE TABLE IF NOT EXISTS `bit_quote`.`quote` (
  `qu_id` INT NOT NULL AUTO_INCREMENT,
  `qu_quote` LONGTEXT NOT NULL,
  `qu_book_page` SMALLINT NOT NULL,
  `bo_id` INT NOT NULL,
  `us_name` VARCHAR(45) NOT NULL,
  INDEX `fk_citacao_livro1_idx` (`bo_id` ASC) VISIBLE,
  PRIMARY KEY (`qu_id`),
  INDEX `fk_citacao_usuario1_idx` (`us_name` ASC) VISIBLE,
  CONSTRAINT `fk_citacao_livro1`
    FOREIGN KEY (`bo_id`)
    REFERENCES `bit_quote`.`book` (`bo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_citacao_usuario1`
    FOREIGN KEY (`us_name`)
    REFERENCES `bit_quote`.`user` (`us_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB