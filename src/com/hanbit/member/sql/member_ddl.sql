-- id,name,password,ssn,regdate
CREATE TABLE Member(--DDL은 구조 
	id VARCHAR2(10),
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);
SELECT * FROM Member;
DROP TABLE Member;--DDL 구조
