-- MySQL Script generated by MySQL Workbench
-- Tue Apr 24 09:48:29 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_over_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_over_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_over_system` DEFAULT CHARACTER SET utf8 ;
USE `db_over_system` ;

-- -----------------------------------------------------
-- Table `db_over_system`.` CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.` CLIENTE` (
  `idCLIENTE` INT NOT NULL AUTO_INCREMENT,
  `NOME_FANTASIA` VARCHAR(45) NOT NULL,
  `CNPJ` VARCHAR(18) NOT NULL,
  `SERVICO_CONTRATADO` VARCHAR(45) NOT NULL,
  `TELEFONE` VARCHAR(15) NOT NULL,
  `ENDERECO` VARCHAR(100) NOT NULL,
  `EMAIL` VARCHAR(35) NULL,
  `DESCRICAO` VARCHAR(45) NULL,
  PRIMARY KEY (`idCLIENTE`),
  UNIQUE INDEX `idCLIENTE_UNIQUE` (`idCLIENTE` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`PERFIL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`PERFIL` (
  `idPERFIL` INT NOT NULL AUTO_INCREMENT,
  `PERFIL` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPERFIL`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`USUARIO` (
  `idUSUARIO` INT NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(45) NOT NULL,
  `SENHA` VARCHAR(45) NOT NULL,
  `PERFIL_idPERFIL` INT NOT NULL,
  PRIMARY KEY (`idUSUARIO`),
  UNIQUE INDEX `idUSUARIO_UNIQUE` (`idUSUARIO` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  INDEX `fk_USUARIO_PERFIL1_idx` (`PERFIL_idPERFIL` ASC),
  CONSTRAINT `fk_USUARIO_PERFIL1`
    FOREIGN KEY (`PERFIL_idPERFIL`)
    REFERENCES `db_over_system`.`PERFIL` (`idPERFIL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`FUNCIONARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`FUNCIONARIO` (
  `idFUNCIONARIO` INT NOT NULL AUTO_INCREMENT,
  `CPF` VARCHAR(15) NOT NULL,
  `NOME` VARCHAR(45) NOT NULL,
  `RG` VARCHAR(9) NOT NULL,
  `DATA_DE_NASCIMENTO` DATE NOT NULL,
  `SEXO` VARCHAR(45) NOT NULL,
  `CARGO` VARCHAR(45) NOT NULL,
  `ENDERECO` VARCHAR(100) NOT NULL,
  `TELEFONE` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `USUARIO_idUSUARIO` INT NOT NULL,
  PRIMARY KEY (`idFUNCIONARIO`),
  UNIQUE INDEX `idCADSATRO DE FUNCIONARIO_UNIQUE` (`idFUNCIONARIO` ASC),
  INDEX `fk_FUNCIONARIO_USUARIO1_idx` (`USUARIO_idUSUARIO` ASC),
  CONSTRAINT `fk_FUNCIONARIO_USUARIO1`
    FOREIGN KEY (`USUARIO_idUSUARIO`)
    REFERENCES `db_over_system`.`USUARIO` (`idUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`ENTRADA_PRODUTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`ENTRADA_PRODUTO` (
  `idENTRADA_PRODUTO` INT NOT NULL AUTO_INCREMENT,
  `QUANT` INT(11) NOT NULL,
  `VALOR_UNIT` DECIMAL(9,2) NOT NULL DEFAULT 0.00,
  `DATA_ENTRADA` DATE NOT NULL,
  PRIMARY KEY (`idENTRADA_PRODUTO`),
  UNIQUE INDEX `idENTRADA_PRODUTO_UNIQUE` (`idENTRADA_PRODUTO` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`SAIDA_PRODUTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`SAIDA_PRODUTO` (
  `idENTRADA_PRODUTO` INT NOT NULL AUTO_INCREMENT,
  `QUANT` INT(11) NOT NULL,
  `VALOR_UNIT` DECIMAL(9,2) NOT NULL DEFAULT 0.00,
  `DATA_SAIDA` DATE NOT NULL,
  PRIMARY KEY (`idENTRADA_PRODUTO`),
  UNIQUE INDEX `idENTRADA_PRODUTO_UNIQUE` (`idENTRADA_PRODUTO` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`PRODUTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`PRODUTO` (
  `idPRODUTO` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(45) NOT NULL,
  `STATUS` VARCHAR(12) NOT NULL,
  `CATEGORIA` VARCHAR(65) NOT NULL,
  `ENTRADA_PRODUTO_idENTRADA_PRODUTO` INT NOT NULL,
  `SAIDA_PRODUTO_idENTRADA_PRODUTO` INT NOT NULL,
  PRIMARY KEY (`idPRODUTO`),
  UNIQUE INDEX `idPRODUTO_UNIQUE` (`idPRODUTO` ASC),
  INDEX `fk_PRODUTO_ENTRADA_PRODUTO1_idx` (`ENTRADA_PRODUTO_idENTRADA_PRODUTO` ASC),
  INDEX `fk_PRODUTO_SAIDA_PRODUTO1_idx` (`SAIDA_PRODUTO_idENTRADA_PRODUTO` ASC),
  CONSTRAINT `fk_PRODUTO_ENTRADA_PRODUTO1`
    FOREIGN KEY (`ENTRADA_PRODUTO_idENTRADA_PRODUTO`)
    REFERENCES `db_over_system`.`ENTRADA_PRODUTO` (`idENTRADA_PRODUTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUTO_SAIDA_PRODUTO1`
    FOREIGN KEY (`SAIDA_PRODUTO_idENTRADA_PRODUTO`)
    REFERENCES `db_over_system`.`SAIDA_PRODUTO` (`idENTRADA_PRODUTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`ESTOQUE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`ESTOQUE` (
  `idESTOQUE` INT NOT NULL AUTO_INCREMENT,
  `QUANT` INT(11) NOT NULL,
  `VALOR_UNIT` DECIMAL(9,2) NOT NULL DEFAULT 0.00,
  `PRODUTO_idPRODUTO` INT NOT NULL,
  PRIMARY KEY (`idESTOQUE`),
  UNIQUE INDEX `idESTOQUE_UNIQUE` (`idESTOQUE` ASC),
  INDEX `fk_ESTOQUE_PRODUTO1_idx` (`PRODUTO_idPRODUTO` ASC),
  CONSTRAINT `fk_ESTOQUE_PRODUTO1`
    FOREIGN KEY (`PRODUTO_idPRODUTO`)
    REFERENCES `db_over_system`.`PRODUTO` (`idPRODUTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`MENU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`MENU` (
  `idMENU` INT NOT NULL AUTO_INCREMENT,
  `LINK` VARCHAR(145) NOT NULL,
  `MENU` VARCHAR(45) NOT NULL,
  `STATUS` INT(2) NOT NULL,
  `ICON` VARCHAR(45) NULL,
  PRIMARY KEY (`idMENU`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`MENU_PERFIL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`MENU_PERFIL` (
  `idMENU` INT NOT NULL,
  `idPERFIL` INT NOT NULL,
  PRIMARY KEY (`idMENU`, `idPERFIL`),
  INDEX `fk_MENU_has_PERFIL_PERFIL1_idx` (`idPERFIL` ASC),
  INDEX `fk_MENU_has_PERFIL_MENU1_idx` (`idMENU` ASC),
  CONSTRAINT `fk_MENU_has_PERFIL_MENU1`
    FOREIGN KEY (`idMENU`)
    REFERENCES `db_over_system`.`MENU` (`idMENU`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_MENU_has_PERFIL_PERFIL1`
    FOREIGN KEY (`idPERFIL`)
    REFERENCES `db_over_system`.`PERFIL` (`idPERFIL`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`SERVICO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`SERVICO` (
  `idSERVICO` INT NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(145) NOT NULL,
  `VALOR` VARCHAR(45) NOT NULL,
  `DATA_INICIAL` VARCHAR(45) NOT NULL,
  `DATA_FINAL` VARCHAR(45) NOT NULL,
  ` CLIENTE_idCLIENTE` INT NOT NULL,
  PRIMARY KEY (`idSERVICO`),
  INDEX `fk_SERVICO_ CLIENTE1_idx` (` CLIENTE_idCLIENTE` ASC),
  CONSTRAINT `fk_SERVICO_ CLIENTE1`
    FOREIGN KEY (` CLIENTE_idCLIENTE`)
    REFERENCES `db_over_system`.` CLIENTE` (`idCLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`SERVICO_has_FUNCIONARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`SERVICO_has_FUNCIONARIO` (
  `SERVICO_idSERVICO` INT NOT NULL,
  `FUNCIONARIO_idFUNCIONARIO` INT NOT NULL,
  PRIMARY KEY (`SERVICO_idSERVICO`, `FUNCIONARIO_idFUNCIONARIO`),
  INDEX `fk_SERVICO_has_FUNCIONARIO_FUNCIONARIO1_idx` (`FUNCIONARIO_idFUNCIONARIO` ASC),
  INDEX `fk_SERVICO_has_FUNCIONARIO_SERVICO1_idx` (`SERVICO_idSERVICO` ASC),
  CONSTRAINT `fk_SERVICO_has_FUNCIONARIO_SERVICO1`
    FOREIGN KEY (`SERVICO_idSERVICO`)
    REFERENCES `db_over_system`.`SERVICO` (`idSERVICO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SERVICO_has_FUNCIONARIO_FUNCIONARIO1`
    FOREIGN KEY (`FUNCIONARIO_idFUNCIONARIO`)
    REFERENCES `db_over_system`.`FUNCIONARIO` (`idFUNCIONARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_over_system`.`SERVICO_has_PRODUTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_over_system`.`SERVICO_has_PRODUTO` (
  `SERVICO_idSERVICO` INT NOT NULL,
  `PRODUTO_idPRODUTO` INT NOT NULL,
  PRIMARY KEY (`SERVICO_idSERVICO`, `PRODUTO_idPRODUTO`),
  INDEX `fk_SERVICO_has_PRODUTO_PRODUTO1_idx` (`PRODUTO_idPRODUTO` ASC),
  INDEX `fk_SERVICO_has_PRODUTO_SERVICO1_idx` (`SERVICO_idSERVICO` ASC),
  CONSTRAINT `fk_SERVICO_has_PRODUTO_SERVICO1`
    FOREIGN KEY (`SERVICO_idSERVICO`)
    REFERENCES `db_over_system`.`SERVICO` (`idSERVICO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SERVICO_has_PRODUTO_PRODUTO1`
    FOREIGN KEY (`PRODUTO_idPRODUTO`)
    REFERENCES `db_over_system`.`PRODUTO` (`idPRODUTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;