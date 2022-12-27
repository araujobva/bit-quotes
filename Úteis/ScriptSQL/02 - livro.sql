CREATE TABLE IF NOT EXISTS `bit_quotes`.`livro` (
  `li_id` INT NOT NULL AUTO_INCREMENT,
  `li_nome` VARCHAR(90) NOT NULL,
  `li_autor` VARCHAR(90) NOT NULL,
  `li_foto` LONGBLOB NULL,
  PRIMARY KEY (`li_id`))
ENGINE = InnoDB