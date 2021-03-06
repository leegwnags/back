-- 데이터베이스 생성
-- create database sqlclass;

-- 사용 데이터베이스 변경
-- use sqlclass;

-- 연습용 테이블 및 더미 데이터
DROP TABLE IF EXISTS BONUS CASCADE;
DROP TABLE IF EXISTS DEPT CASCADE;
DROP TABLE IF EXISTS EMP CASCADE;
DROP TABLE IF EXISTS SALGRADE CASCADE;

CREATE TABLE IF NOT EXISTS BONUS (
  ENAME varchar(10) DEFAULT NULL,
  JOB varchar(9) DEFAULT NULL,
  SAL double DEFAULT NULL,
  COMM double DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS DEPT (
  DEPTNO int(11) NOT NULL,
  DNAME varchar(14) DEFAULT NULL,
  LOC varchar(13) DEFAULT NULL,
  PRIMARY KEY (DEPTNO)
);



INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');


CREATE TABLE IF NOT EXISTS EMP (
  EMPNO int(11) NOT NULL,
  ENAME varchar(10) DEFAULT NULL,
  JOB varchar(9) DEFAULT NULL,
  MGR int(11) DEFAULT NULL,
  HIREDATE date DEFAULT NULL,
  SAL double DEFAULT NULL,
  COMM double DEFAULT NULL,
  DEPTNO int(11) DEFAULT NULL,
  PRIMARY KEY (EMPNO),
  KEY PK_EMP (DEPTNO)
);


INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000, NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30),
(7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10);

CREATE TABLE IF NOT EXISTS SALGRADE (
  GRADE double DEFAULT NULL,
  LOSAL double DEFAULT NULL,
  HISAL double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES
(1, 700, 1200),
(2, 1201, 1400),
(3, 1401, 2000),
(4, 2001, 3000),
(5, 3001, 9999);


ALTER TABLE EMP
  ADD CONSTRAINT PK_EMP FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO) ON DELETE SET NULL ON UPDATE CASCADE;