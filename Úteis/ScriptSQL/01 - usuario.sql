CREATE TABLE IF NOT EXISTS `bit_quotes`.`usuario` (
  `us_nome` VARCHAR(45) NOT NULL,
  `us_senha` VARCHAR(45) NOT NULL,
  `us_administrador` TINYINT(1) NOT NULL,
  PRIMARY KEY (`us_nome`))
ENGINE = InnoDB