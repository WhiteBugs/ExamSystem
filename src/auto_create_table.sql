-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema examination
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `examination` ;

-- -----------------------------------------------------
-- Schema examination
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `examination` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `examination` ;

-- -----------------------------------------------------
-- Table `examination`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`admin` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`admin` (
  `COUNT` VARCHAR(200) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Safe_Question` TEXT NULL DEFAULT NULL,
  `Safe_Answer` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`COUNT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`blank_filling_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`blank_filling_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`blank_filling_question` (
  `Tittle` TEXT NOT NULL,
  `Blank_Filling_Question_ID` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Blank_Filling_Question_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`blank_filling_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`blank_filling_answer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`blank_filling_answer` (
  `Answer` TEXT NOT NULL,
  `orders` INT(11) NOT NULL,
  `Blank_Filling_Question_ID` INT(11) NOT NULL,
  INDEX `Blank_Filling_Question_ID_Answer_tk` (`Blank_Filling_Question_ID` ASC),
  PRIMARY KEY (`Blank_Filling_Question_ID`, `orders`),
  CONSTRAINT `Blank_Filling_Question_ID_Answer_tk`
    FOREIGN KEY (`Blank_Filling_Question_ID`)
    REFERENCES `examination`.`blank_filling_question` (`Blank_Filling_Question_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`blank_filling_answer_of_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`blank_filling_answer_of_student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`blank_filling_answer_of_student` (
  `Orders` INT(11) NOT NULL,
  `Blank_Filling_Answer_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Answer` VARCHAR(4000) NOT NULL,
  PRIMARY KEY (`Blank_Filling_Answer_ID`, `Orders`),
  UNIQUE INDEX `Orders_UNIQUE` (`Orders` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`student` (
  `Student_ID` BIGINT(20) NOT NULL,
  `Examinee_Number` BIGINT(20) NULL DEFAULT NULL,
  `ID` BIGINT(20) NULL DEFAULT NULL,
  `Name` VARCHAR(100) NOT NULL,
  `SEX` VARCHAR(100) NOT NULL,
  `grade` INT(11) NOT NULL,
  `Major` VARCHAR(100) NULL DEFAULT NULL,
  `classes` INT(11) NULL DEFAULT NULL,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Student_ID`),
  UNIQUE INDEX `Student_ID_UNIQUE` (`Student_ID` ASC),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`teacher` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`teacher` (
  `COUNT` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Safe_Question` TEXT NULL DEFAULT NULL,
  `Safe_Answer` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`COUNT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`test_paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`test_paper` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`test_paper` (
  `Exam_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Count` VARCHAR(400) NOT NULL,
  `Begin_Time` DATETIME(6) NOT NULL,
  `End_Time` DATETIME(6) NOT NULL,
  `Exam_Name` VARCHAR(45) NOT NULL,
  `Answer` TEXT NULL,
  PRIMARY KEY (`Exam_ID`),
  INDEX `Teacher_Count_TestPaper_tk` (`Count` ASC),
  CONSTRAINT `Teacher_Count_TestPaper_tk`
    FOREIGN KEY (`Count`)
    REFERENCES `examination`.`teacher` (`COUNT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`blank_filling_answer_of_student_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`blank_filling_answer_of_student_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`blank_filling_answer_of_student_junction` (
  `Orders` INT(11) NOT NULL,
  `Score` INT(11) NOT NULL,
  `Student_ID` BIGINT(20) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  `blank_filling_answer_ID_of_student` INT(11) NOT NULL,
  INDEX `Student_ID_BF_AnswerJunction_tk` (`Student_ID` ASC),
  INDEX `TestPaper_ExamID_BlankFillingAnswerJunction_tk` (`Exam_ID` ASC),
  INDEX `fk_blank_filling_answer_of_student_junction_blank_filling_a_idx` (`blank_filling_answer_ID_of_student` ASC),
  PRIMARY KEY (`blank_filling_answer_ID_of_student`, `Exam_ID`, `Student_ID`, `Orders`),
  UNIQUE INDEX `Orders_UNIQUE` (`Orders` ASC),
  CONSTRAINT `Student_ID_BF_AnswerJunction_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `TestPaper_ExamID_BlankFillingAnswerJunction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`),
  CONSTRAINT `fk_blank_filling_answer_of_student_junction_blank_filling_ans1`
    FOREIGN KEY (`blank_filling_answer_ID_of_student`)
    REFERENCES `examination`.`blank_filling_answer_of_student` (`Blank_Filling_Answer_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`blank_filling_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`blank_filling_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`blank_filling_junction` (
  `Orders` INT(11) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  `Blank_Filling_Question_ID` INT(11) NOT NULL,
  INDEX `Test_Paper_examid_blank_filling_junction_tk` (`Exam_ID` ASC),
  INDEX `blank_filling_question_id_blank_filling_junction_tk` (`Blank_Filling_Question_ID` ASC),
  PRIMARY KEY (`Exam_ID`, `Blank_Filling_Question_ID`),
  UNIQUE INDEX `Orders_UNIQUE` (`Orders` ASC),
  CONSTRAINT `Test_Paper_examid_blank_filling_junction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`),
  CONSTRAINT `blank_filling_question_id_blank_filling_junction_tk`
    FOREIGN KEY (`Blank_Filling_Question_ID`)
    REFERENCES `examination`.`blank_filling_question` (`Blank_Filling_Question_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`choice_answer_of_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`choice_answer_of_student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`choice_answer_of_student` (
  `Answer` VARCHAR(4000) NOT NULL,
  `Orders` INT(11) NOT NULL,
  `Score` INT(11) NOT NULL DEFAULT '0',
  `Exam_ID` INT(11) NOT NULL,
  `Student_ID` BIGINT(20) NOT NULL,
  INDEX `Test_Paper_Exam_ID_ChoiceAnswer_tk` (`Exam_ID` ASC),
  INDEX `Student_StudentID_ChoiceAnswer_tk` (`Student_ID` ASC),
  PRIMARY KEY (`Exam_ID`, `Student_ID`, `Orders`),
  UNIQUE INDEX `Orders_UNIQUE` (`Orders` ASC),
  CONSTRAINT `Student_StudentID_ChoiceAnswer_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `Test_Paper_Exam_ID_ChoiceAnswer_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`choice_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`choice_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`choice_question` (
  `Choice_Question_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Tittle` TEXT NULL DEFAULT NULL,
  `Choice1` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice2` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice3` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice4` VARCHAR(4000) NULL DEFAULT NULL,
  `Answer` VARCHAR(4000) NULL DEFAULT NULL,
  PRIMARY KEY (`Choice_Question_ID`),
  UNIQUE INDEX `Choice_Question_ID_UNIQUE` (`Choice_Question_ID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`choice_question_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`choice_question_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`choice_question_junction` (
  `orders` INT(11) NOT NULL,
  `Choice_Question_ID` INT(11) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  INDEX `Choice_Question_ID_choice_Junction_tk` (`Choice_Question_ID` ASC),
  INDEX `Test_Paper_ExamID_choice_Junction_tk` (`Exam_ID` ASC),
  PRIMARY KEY (`Choice_Question_ID`, `Exam_ID`),
  UNIQUE INDEX `orders_UNIQUE` (`orders` ASC),
  CONSTRAINT `Choice_Question_ID_choice_Junction_tk`
    FOREIGN KEY (`Choice_Question_ID`)
    REFERENCES `examination`.`choice_question` (`Choice_Question_ID`),
  CONSTRAINT `Test_Paper_ExamID_choice_Junction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`eassy_answer_of_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`eassy_answer_of_student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`eassy_answer_of_student` (
  `Orders` INT(11) NOT NULL,
  `Score` INT(11) NOT NULL,
  `Answer` TEXT NOT NULL,
  `Student_ID` BIGINT(20) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  INDEX `Student_ID_Eassy_Answer_tk` (`Student_ID` ASC),
  INDEX `Test_Paper_ExamID_Eassy_Answer_tk` (`Exam_ID` ASC),
  PRIMARY KEY (`Student_ID`, `Exam_ID`, `Orders`),
  UNIQUE INDEX `Orders_UNIQUE` (`Orders` ASC),
  CONSTRAINT `Student_ID_Eassy_Answer_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `Test_Paper_ExamID_Eassy_Answer_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`eassy_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`eassy_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`eassy_question` (
  `Tittle` TEXT NOT NULL,
  `Answer` TEXT NOT NULL,
  `Eassy_Question_ID` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Eassy_Question_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`eassy_question_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`eassy_question_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`eassy_question_junction` (
  `orders` INT(11) NOT NULL,
  `Eassy_Question_ID` INT(11) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  INDEX `EassyQuestion_ID_Junction_tk` (`Eassy_Question_ID` ASC),
  INDEX `TestPaper_ExamID_EassyQuestionJunction_tk` (`Exam_ID` ASC),
  PRIMARY KEY (`Eassy_Question_ID`, `Exam_ID`),
  UNIQUE INDEX `orders_UNIQUE` (`orders` ASC),
  CONSTRAINT `EassyQuestion_ID_Junction_tk`
    FOREIGN KEY (`Eassy_Question_ID`)
    REFERENCES `examination`.`eassy_question` (`Eassy_Question_ID`),
  CONSTRAINT `TestPaper_ExamID_EassyQuestionJunction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`student_exam_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`student_exam_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`student_exam_junction` (
  `Student_ID` BIGINT(20) NOT NULL,
  `Exam_ID` INT(11) NOT NULL,
  `score` INT NULL,
  INDEX `Student_StudentID_StudentExamJunction_tk` (`Student_ID` ASC),
  INDEX `testpaper_ExamID_StudentExamJunction_tk` (`Exam_ID` ASC),
  PRIMARY KEY (`Student_ID`, `Exam_ID`),
  CONSTRAINT `Student_StudentID_StudentExamJunction_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `testpaper_ExamID_StudentExamJunction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
