CREATE TABLE IF NOT EXISTS `bit_quotes`.`citacao` (
  `ci_id` INT NOT NULL AUTO_INCREMENT,
  `ci_citacao` LONGTEXT NOT NULL,
  `ci_pagina_livro` INT NOT NULL,
  `li_id` INT NOT NULL,
  `us_nome` VARCHAR(45) NOT NULL,
  INDEX `fk_citacao_livro1_idx` (`li_id` ASC),
  PRIMARY KEY (`ci_id`),
  INDEX `fk_citacao_usuario1_idx` (`us_nome` ASC),
  CONSTRAINT `fk_citacao_livro1`
    FOREIGN KEY (`li_id`)
    REFERENCES `bit_quotes`.`livro` (`li_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_citacao_usuario1`
    FOREIGN KEY (`us_nome`)
    REFERENCES `bit_quotes`.`usuario` (`us_nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB