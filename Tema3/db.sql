SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `db` DEFAULT CHARACTER SET utf8 ;
USE `db` ;

-- -----------------------------------------------------
-- Table `db`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Phone` VARCHAR(45) NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `idCustomer` INT NOT NULL,
  PRIMARY KEY (`idOrder`, `idCustomer`),
  INDEX `idCustomer_idx` (`idCustomer` ASC),
  CONSTRAINT `idCustomer`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `db`.`Customer` (`idCustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`customer` (
  `idCustomer` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Phone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`order` (
  `idOrder` INT(11) NOT NULL AUTO_INCREMENT,
  `idCustomer` INT(11) NOT NULL,
  PRIMARY KEY (`idOrder`, `idCustomer`),
  INDEX `idCustomer_idx` (`idCustomer` ASC),
  CONSTRAINT `idCustomer`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `db`.`customer` (`idCustomer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`product` (
  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`order_has_product` (
  `idOrder` INT(11) NOT NULL,
  `idProduct` INT(11) NOT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idOrder`, `idProduct`),
  INDEX `idProduct_idx` (`idProduct` ASC),
  CONSTRAINT `idOrder`
    FOREIGN KEY (`idOrder`)
    REFERENCES `db`.`order` (`idOrder`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idProduct`
    FOREIGN KEY (`idProduct`)
    REFERENCES `db`.`product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db`.`warehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`warehouse` (
  `idProduct` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  INDEX `idProduct_idx` (`idProduct` ASC),
  CONSTRAINT `idProducttt`
    FOREIGN KEY (`idProduct`)
    REFERENCES `db`.`product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
