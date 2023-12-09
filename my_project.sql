CREATE TABLE `humanFriends`.`dogs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `humanFriends`.`cats` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);  

CREATE TABLE `humanFriends`.`hamsters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `humanFriends`.`horses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
CREATE TABLE `humanFriends`.`camels` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
CREATE TABLE `humanFriends`.`donkeys` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `comands` TEXT(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
INSERT INTO `humanFriends`.`dogs` (name, date_of_birth, comands) VALUES
 ('Peach', '2019-03-16', 'sit_down, give_me_a_paw, to_me'),
 ('Jack', '2023-02-03', 'to_me, sit_down'),
 ('Bonnie', '2022-10-12', 'give_me_a_paw, voice');
 
INSERT INTO `humanFriends`.`cats` (name, date_of_birth, comands) VALUES
 ('Katty', '2017-03-17', 'sit_down, give_me_a_paw, to_me'),
 ('Snowy', '2023-01-03', 'to_me, sit_down'),
 ('Court', '2022-12-12', 'give_me_a_paw, voice');
 
INSERT INTO `humanFriends`.`hamsters` (name, date_of_birth, comands) VALUES
 ('Ham', '2021-03-18', 'sit_down, give_me_a_paw, to_me'),
 ('Oil', '2022-01-07', 'to_me, sit_down'),
 ('Noi', '2020-12-12', 'give_me_a_paw, voice'); 
 
 INSERT INTO `humanFriends`.`horses` (name, date_of_birth, comands) VALUES
 ('James', '2015-03-02', 'sit_down, give_me_a_paw, to_me'),
 ('Steven', '2016-01-07', 'to_me, sit_down'),
 ('Franklin', '2019-12-12', 'give_me_a_paw, voice'); 
 
 INSERT INTO `humanFriends`.`camels` (name, date_of_birth, comands) VALUES
 ('Ali', '2014-03-02', 'sit_down, give_me_a_paw, to_me'),
 ('Mufasa', '2015-01-07', 'to_me, sit_down'),
 ('Annie', '2018-12-12', 'give_me_a_paw, voice');  
 
 INSERT INTO `humanFriends`.`donkeys` (name, date_of_birth, comands) VALUES
 ('Donkey', '2020-03-02', 'sit_down, give_me_a_paw, to_me'),
 ('Arthur', '2021-01-07', 'to_me, sit_down'),
 ('Bruce', '2022-12-12', 'give_me_a_paw, voice');
 
TRUNCATE `humanFriends`.`camels`; 