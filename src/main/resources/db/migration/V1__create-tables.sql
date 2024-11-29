-- -----------------------------------------------------
-- Schema challenge_foro
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `challenge_foro`.`users`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(250) NULL,
  `email` VARCHAR(250) NULL,
  `password` VARCHAR(250) NULL,
  `created_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `email_INDEX` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `challenge_foro`.`profiles`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`profiles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `name_INDEX` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `challenge_foro`.`users_profiles`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`users_profiles` (
  `user_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `profile_id`),
  INDEX `fk_users_profiles_profiles1_idx` (`profile_id` ASC) ,
  CONSTRAINT `fk_users_profiles_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `challenge_foro`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_profiles_profiles1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `challenge_foro`.`profiles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `challenge_foro`.`course`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`courses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `category` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `challenge_foro`.`topical`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`topicals` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(250) NOT NULL,
  `message` VARCHAR(250) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `answers` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_topical_course1_idx` (`course_id` ASC) ,
  INDEX `fk_topical_users1_idx` (`user_id` ASC) ,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) ,
  UNIQUE INDEX `message_UNIQUE` (`message` ASC) ,
  CONSTRAINT `fk_topical_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `challenge_foro`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_topical_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `challenge_foro`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `challenge_foro`.`answers`
-- -----------------------------------------------------
CREATE TABLE `challenge_foro`.`answers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(250) NOT NULL,
  `topital_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `solution` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_answers_topical1_idx` (`topital_id` ASC) ,
  INDEX `fk_answers_users1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_answers_topical1`
    FOREIGN KEY (`topital_id`)
    REFERENCES `challenge_foro`.`topicals` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answers_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `challenge_foro`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;