-- id,name,password,ssn,regdate 자바의 Bean과 DB의 값이 일치해야한다
SELECT * FROM Member;--getter call이라고 한다
SELECT * FROM Member WHERE name ='김기근';
SELECT COUNT(*) AS count FROM Member;--모든 카운트를 가져온다, 함수 이름은 COUNT(*)다
INSERT INTO Member(id,name,password,ssn,regdate)--DML 구조 (컬럼명 : id,name,password,ssn,regdate)
VALUES('hong','홍길동','1','861114-1025114',SYSDATE);--""가 아닌 ''로 문자열을 표기
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('byeon','변용주','a','861014-1030114',SYSDATE);--SYSDATE는 자동으로 날짜를 계산해주는 명령어
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim','김하윤','a','931122-2015415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('cho','조봉기','a','842115-1014415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('hong','홍지후','a','891115-1035415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('park','박준용','a','881135-1019415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('song','송상훈','a','861125-1013315',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim2','김기근','a','851125-1014615',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim1','김기근','a','851015-1014615',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim3','김기군','a','851015-1014615',SYSDATE);
