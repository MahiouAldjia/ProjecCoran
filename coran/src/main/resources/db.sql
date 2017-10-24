DROP SCHEMA IF EXISTS koran $$

CREATE SCHEMA IF NOT EXISTS koran DEFAULT CHARACTER SET utf8 $$
USE koran $$

CREATE TABLE IF NOT EXISTS langue (
  id_langue CHAR(3) NOT NULL,
  nom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_langue))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 $$


CREATE TABLE IF NOT EXISTS sorate (
  id_sorate INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_sorate))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 $$


CREATE TABLE IF NOT EXISTS variante (
  id_variante INT(11) NOT NULL AUTO_INCREMENT,
  nom VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (id_variante))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 $$


CREATE TABLE IF NOT EXISTS verset (
  id_verset INT(11) NOT NULL AUTO_INCREMENT,
  numero INT(11) NOT NULL,
  id_sorate INT(11) NOT NULL,
  PRIMARY KEY (id_verset),
  INDEX fk_verset_sorate_idx (id_sorate ASC),
  CONSTRAINT fk_verset_sorate
    FOREIGN KEY (id_sorate)
    REFERENCES sorate (id_sorate)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 $$


CREATE TABLE IF NOT EXISTS verset_variante_langue (
  ayat TEXT NOT NULL,
  id_verset INT(11) NOT NULL,
  id_langue CHAR(3) NOT NULL,
  id_variante INT(11) NOT NULL,
  PRIMARY KEY (id_verset, id_langue, id_variante),
  INDEX fk_verset_variante_langue_langue_idx (id_langue ASC),
  INDEX fk_verset_variante_langue_variante_idx (id_variante ASC),
  CONSTRAINT fk_verset_variante_langue_langue
    FOREIGN KEY (id_langue)
    REFERENCES langue (id_langue)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_verset_variante_langue_variante
    FOREIGN KEY (id_variante)
    REFERENCES variante (id_variante)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_verset_variante_langue_verset
    FOREIGN KEY (id_verset)
    REFERENCES verset (id_verset)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 $$