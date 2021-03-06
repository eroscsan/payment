DROP TABLE IF EXISTS BB_TRANSACTIONS;
DROP TABLE IF EXISTS BB_PAYMENT_TYPE;
DROP TABLE IF EXISTS BB_PARTNERS;
DROP DATABASE IF EXISTS payment;

CREATE DATABASE payment;

USE payment;

CREATE TABLE `BB_PAYMENT_TYPE`(
  PTYP_ID int  NOT NULL AUTO_INCREMENT,
  NAME_TYPE varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (PTYP_ID)
);

CREATE TABLE `BB_PARTNERS`(
  PARTNER_ID int  NOT NULL AUTO_INCREMENT,
  FULL_NAME varchar(20),
  ACCOUNT_NUMBER varchar(40),
  PRIMARY KEY (PARTNER_ID)
);

CREATE TABLE `BB_TRANSACTIONS`(
  TRANSACTION_ID int  NOT NULL AUTO_INCREMENT,
  PAYMENT_TYPE int,
  PARTNER_ID int,
  TRANSFER_DATE bigint(15),
  CREATE_DATE bigint(15),
  AMOUNT float(40),
  DESCRIPTION varchar(40) NOT NULL DEFAULT'',
  FEE_CALCULATION tinyint(1),
  PRIMARY KEY (TRANSACTION_ID),
  FOREIGN KEY (PAYMENT_TYPE)
  REFERENCES BB_PAYMENT_TYPE(PTYP_ID),
  FOREIGN KEY (PARTNER_ID)
  REFERENCES BB_PARTNERS(PARTNER_ID)
);

INSERT INTO BB_PAYMENT_TYPE(PTYP_ID, NAME_TYPE)
VALUES(1,"asd");

INSERT INTO BB_PARTNERS(PARTNER_ID, FULL_NAME, ACCOUNT_NUMBER)
VALUES(1, "Kertész Géza", "10000000-00000000-00000000");

INSERT INTO BB_TRANSACTIONS(TRANSACTION_ID, PAYMENT_TYPE, PARTNER_ID, 
												TRANSFER_DATE, CREATE_DATE, AMOUNT, DESCRIPTION, FEE_CALCULATION)
VALUES(1, 1, 1, 20171204, 20171204, 10000, "NINCS", 0);