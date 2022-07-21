-- select query
-- 1. 테이블 명, 2. 조건여부, 3. 컬럼 선택
select EMPNO , ENAME from emp;
select * from emp;
select empno, ename, sal from emp
where sal > 1500;

-- 내부적으로 데이터베이스가 쿼리를 수행하는 순서
select EMPNO, ENAME, SAL, COMM -- 3
from emp -- 1
where sal > 1000; -- 2

-- 컬럼 출력의 방법 및 연산자 활용
select empno, ename, sal
from emp;

-- 컬럼 출력 방법 : alias(별칭)
select empno as "사원번호",
ename as "사원이름",
sal as "급여"
from emp;

select empno as 사원번호,
ename as 사원이름,
sal as 급여
from emp;

-- as 생략하고 띄어쓰기를 사용 (권장하지 않음)
select empno employee_no,
ename 사원이름,
sal 급여
from emp;

select "사원 번호",
ename "사원 이름",
sal "급여"
from emp;

-- 연산자 활용
-- 연산이 가능한 데이터 타입 && 연산 수행의 결과가 유의미 해야함
select * from emp;
select empno, ename, sal+comm total
from emp;

