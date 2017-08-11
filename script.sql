
CREATE TABLE `librarytest`.`usertype` (
`iduserType` INT NOT NULL,
`type` VARCHAR(45) NOT NULL,
PRIMARY KEY (`iduserType`));  
  
 
INSERT INTO usertype VALUES (1, "NORMAL");
INSERT INTO usertype VALUES (2, "ADM");
  

CREATE TABLE `librarytest`.`user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `idusertype` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `birthDate` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `idusertype_idx` (`idusertype`),
  CONSTRAINT `idusertype` FOREIGN KEY (`idusertype`) REFERENCES `usertype` (`iduserType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `bookstatus` (
  `idbookstatus` int(11) NOT NULL,
  `bookstatus` varchar(45) NOT NULL,
  PRIMARY KEY (`idbookstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO librarytest.bookstatus VALUES (1,"RESERVED");
INSERT INTO librarytest.bookstatus VALUES (2,"WITHDRAWN");
INSERT INTO librarytest.bookstatus VALUES (3,"AVAILABLE");

CREATE TABLE `book` (
  `idbook` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `editor` varchar(45) NOT NULL,
  `yearPubli` varchar(45) NOT NULL,
  `writer` varchar(45) NOT NULL,
  `edition` varchar(45) NOT NULL,
  `bookstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbook`),
  KEY `bookstatus_idx` (`bookstatus`),
  CONSTRAINT `bookstatus` FOREIGN KEY (`bookstatus`) REFERENCES `bookstatus` (`idbookstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

  
insert INTO user (
`idusertype`,
`email`,
`password`,
`name`,
`address`,
`birthDate`) values (2, "adm@adm.com", "root", "adm name", "adm adress", "2000");