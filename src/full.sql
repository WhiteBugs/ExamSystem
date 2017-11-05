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
  `Title` TEXT NULL DEFAULT NULL,
  `Blank_Filling_Question_ID` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Blank_Filling_Question_ID`),
  UNIQUE INDEX `Blank_Filling_Question_ID_UNIQUE` (`Blank_Filling_Question_ID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
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
  PRIMARY KEY (`Blank_Filling_Question_ID`, `orders`),
  INDEX `Blank_Filling_Question_ID_Answer_tk` (`Blank_Filling_Question_ID` ASC),
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
  PRIMARY KEY (`Blank_Filling_Answer_ID`, `Orders`))
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
-- Table `examination`.`test_paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`test_paper` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`test_paper` (
  `Exam_ID` VARCHAR(200) NOT NULL,
  `Begin_Time` DATETIME(0) NOT NULL,
  `End_Time` DATETIME(0) NOT NULL,
  `Exam_Name` VARCHAR(45) NOT NULL,
  `Answer` TEXT NULL DEFAULT NULL,
  `path` VARCHAR(45) NULL,
  `exam_time` TIME(0) NULL,
  PRIMARY KEY (`Exam_ID`),
  UNIQUE INDEX `Exam_ID_UNIQUE` (`Exam_ID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
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
  `blank_filling_answer_ID_of_student` INT(11) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`blank_filling_answer_ID_of_student`, `Student_ID`, `Orders`, `test_paper_Exam_ID`),
  INDEX `Student_ID_BF_AnswerJunction_tk` (`Student_ID` ASC),
  INDEX `fk_blank_filling_answer_of_student_junction_blank_filling_a_idx` (`blank_filling_answer_ID_of_student` ASC),
  INDEX `fk_blank_filling_answer_of_student_junction_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `Student_ID_BF_AnswerJunction_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `fk_blank_filling_answer_of_student_junction_blank_filling_ans1`
    FOREIGN KEY (`blank_filling_answer_ID_of_student`)
    REFERENCES `examination`.`blank_filling_answer_of_student` (`Blank_Filling_Answer_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blank_filling_answer_of_student_junction_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
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
  `Blank_Filling_Question_ID` INT(11) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Blank_Filling_Question_ID`, `test_paper_Exam_ID`),
  INDEX `blank_filling_question_id_blank_filling_junction_tk` (`Blank_Filling_Question_ID` ASC),
  INDEX `fk_blank_filling_junction_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `blank_filling_question_id_blank_filling_junction_tk`
    FOREIGN KEY (`Blank_Filling_Question_ID`)
    REFERENCES `examination`.`blank_filling_question` (`Blank_Filling_Question_ID`),
  CONSTRAINT `fk_blank_filling_junction_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `Student_ID` BIGINT(20) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Student_ID`, `Orders`, `test_paper_Exam_ID`),
  INDEX `Student_StudentID_ChoiceAnswer_tk` (`Student_ID` ASC),
  INDEX `fk_choice_answer_of_student_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `Student_StudentID_ChoiceAnswer_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `fk_choice_answer_of_student_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `Title` TEXT NOT NULL,
  `Choice1` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice2` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice3` VARCHAR(4000) NULL DEFAULT NULL,
  `Choice4` VARCHAR(4000) NULL DEFAULT NULL,
  `Answer` VARCHAR(4000) NULL DEFAULT NULL,
  PRIMARY KEY (`Choice_Question_ID`),
  UNIQUE INDEX `Choice_Question_ID_UNIQUE` (`Choice_Question_ID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 20
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
  `Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Choice_Question_ID`, `Exam_ID`),
  INDEX `Choice_Question_ID_choice_Junction_tk` (`Choice_Question_ID` ASC),
  INDEX `Test_Paper_ExamID_choice_Junction_tk` (`Exam_ID` ASC),
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
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Student_ID`, `Orders`, `test_paper_Exam_ID`),
  INDEX `Student_ID_Eassy_Answer_tk` (`Student_ID` ASC),
  INDEX `fk_eassy_answer_of_student_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `Student_ID_Eassy_Answer_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `fk_eassy_answer_of_student_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`eassy_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`eassy_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`eassy_question` (
  `Title` TEXT NULL DEFAULT NULL,
  `Answer` TEXT NOT NULL,
  `Eassy_Question_ID` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Eassy_Question_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
  `Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Eassy_Question_ID`, `Exam_ID`),
  INDEX `EassyQuestion_ID_Junction_tk` (`Eassy_Question_ID` ASC),
  INDEX `TestPaper_ExamID_EassyQuestionJunction_tk` (`Exam_ID` ASC),
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
  `Exam_ID` VARCHAR(200) NOT NULL,
  `score` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Student_ID`, `Exam_ID`),
  INDEX `Student_StudentID_StudentExamJunction_tk` (`Student_ID` ASC),
  INDEX `testpaper_ExamID_StudentExamJunction_tk` (`Exam_ID` ASC),
  CONSTRAINT `Student_StudentID_StudentExamJunction_tk`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`),
  CONSTRAINT `testpaper_ExamID_StudentExamJunction_tk`
    FOREIGN KEY (`Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`))
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
-- Table `examination`.`count_exam_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`count_exam_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`count_exam_junction` (
  `teacher_COUNT` VARCHAR(20) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`teacher_COUNT`, `test_paper_Exam_ID`),
  INDEX `fk_count_exam_junciton_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_count_exam_junciton_teacher1`
    FOREIGN KEY (`teacher_COUNT`)
    REFERENCES `examination`.`teacher` (`COUNT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_count_exam_junciton_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`multiple_choice_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`multiple_choice_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`multiple_choice_question` (
  `titlt` TEXT NOT NULL,
  `multiple_choice_question_id` INT NOT NULL AUTO_INCREMENT,
  `choice1` VARCHAR(45) NULL,
  `choice2` VARCHAR(45) NULL,
  `choice3` VARCHAR(45) NULL,
  `choice4` VARCHAR(45) NULL,
  `answer` VARCHAR(45) NULL,
  PRIMARY KEY (`multiple_choice_question_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`multiple_choice_question_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`multiple_choice_question_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`multiple_choice_question_junction` (
  `multiple_choice_question_multiple_choice_question_id` INT NOT NULL,
  `order` VARCHAR(45) NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`multiple_choice_question_multiple_choice_question_id`, `test_paper_Exam_ID`),
  INDEX `fk_multiple_choice_question_junction_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_table1_multiple_choice_question1`
    FOREIGN KEY (`multiple_choice_question_multiple_choice_question_id`)
    REFERENCES `examination`.`multiple_choice_question` (`multiple_choice_question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_multiple_choice_question_junction_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`true_false_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`true_false_question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`true_false_question` (
  `true_false_question_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `answer` VARCHAR(45) NULL,
  PRIMARY KEY (`true_false_question_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`true_false_question_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`true_false_question_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`true_false_question_junction` (
  `true_false_question_true_false_question_id` INT NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  `order` VARCHAR(45) NULL,
  PRIMARY KEY (`true_false_question_true_false_question_id`, `test_paper_Exam_ID`),
  INDEX `fk_table2_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_table2_true_false_question1`
    FOREIGN KEY (`true_false_question_true_false_question_id`)
    REFERENCES `examination`.`true_false_question` (`true_false_question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table2_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`true_false_answer_of_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`true_false_answer_of_student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`true_false_answer_of_student` (
  `Orders` INT NOT NULL,
  `Score` VARCHAR(45) NULL,
  `Answer` VARCHAR(45) NULL,
  `student_Student_ID` BIGINT(20) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Orders`, `student_Student_ID`, `test_paper_Exam_ID`),
  UNIQUE INDEX `orders_UNIQUE` (`Orders` ASC),
  INDEX `fk_true_false_answer_of_student_student1_idx` (`student_Student_ID` ASC),
  INDEX `fk_true_false_answer_of_student_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_true_false_answer_of_student_student1`
    FOREIGN KEY (`student_Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_true_false_answer_of_student_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`multiple_answer_of_student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`multiple_answer_of_student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`multiple_answer_of_student` (
  `Orders` INT NOT NULL,
  `Score` VARCHAR(45) NULL,
  `Answer` VARCHAR(45) NULL,
  `student_Student_ID` BIGINT(20) NOT NULL,
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Orders`, `student_Student_ID`, `test_paper_Exam_ID`),
  INDEX `fk_multiple_answer_of_student_student1_idx` (`student_Student_ID` ASC),
  INDEX `fk_multiple_answer_of_student_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_multiple_answer_of_student_student1`
    FOREIGN KEY (`student_Student_ID`)
    REFERENCES `examination`.`student` (`Student_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_multiple_answer_of_student_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`exam_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`exam_info` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`exam_info` (
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  `question_type` VARCHAR(45) NOT NULL,
  `score` INT NULL,
  `exam_name` VARCHAR(45) NULL,
  PRIMARY KEY (`test_paper_Exam_ID`, `question_type`),
  INDEX `fk_exam_info_test_paper1_idx` (`test_paper_Exam_ID` ASC),
  CONSTRAINT `fk_exam_info_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`question` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT(1000) NOT NULL,
  `answer` TEXT(8000) NULL,
  `question_type` VARCHAR(45) NULL,
  `choice1` VARCHAR(45) NULL,
  `choice2` VARCHAR(45) NULL,
  `choice3` VARCHAR(45) NULL,
  `choice4` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `examination`.`question_exam_junction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `examination`.`question_exam_junction` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `examination`.`question_exam_junction` (
  `test_paper_Exam_ID` VARCHAR(200) NOT NULL,
  `question_id` INT NOT NULL,
  `order` INT NULL,
  PRIMARY KEY (`test_paper_Exam_ID`, `question_id`),
  INDEX `fk_question_exam_junction_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_question_exam_junction_test_paper1`
    FOREIGN KEY (`test_paper_Exam_ID`)
    REFERENCES `examination`.`test_paper` (`Exam_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_exam_junction_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `examination`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
