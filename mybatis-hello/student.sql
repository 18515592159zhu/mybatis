CREATE TABLE `student` (
   `id` INT ( 11 ) NOT NULL,
   `name` VARCHAR ( 255 ) DEFAULT NULL,
   `email` VARCHAR ( 255 ) DEFAULT NULL,
   `age` INT ( 11 ) DEFAULT NULL,
   PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8;