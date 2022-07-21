-- sql built-in functions

-- String functions
select ename, upper(ename), lower(ename) from emp;
select upper('Three');

select ename, length(ename) from emp;
select ename, length(ename) from emp
where length(ENAME) > 5;

-- substr(col, start, count), substring(col, start, count)
select job, substr(job, 1, 4), substring(job, 1, 4)
from emp;
select job, substr(job, 3) from emp;

-- instr(data, 'search value')
select ename, instr(ename, 'T') from emp;

select * from emp where ename like '%S%';
select * from emp where instr(ename, 'S') > 0;

-- replace(data, 'old', 'new')
select job, replace(job, 'MANAGER', 'MGR') from emp;

-- rpad(data,count,'exp'), lpad(data,count,'exp')
select empno, rpad(empno,6,'#'), lpad(empno,7,'@') from emp;
select rpad(substr('123456-1446788',1,8),14,'*') as idNum;

-- string + string => concat('string', 'string', ...)
-- ename : job
select concat(ename, ' : ', job) as matching from emp;

-- trim, ltrim, rtrim
select trim('    remove space    '), ltrim('    remove space    '),
rtrim('    remove space    ');

-- repeat
select repeat('#', 10);

-- 123456-2*******를 repeat와 concat 사용해서 만들어보기
select concat(substr('123456-2134895',1,8),repeat('*',6));

-- Numeric Functions
select format(avg(sal),2) from emp;
select sum(sal) from emp;
select max(sal) from emp;
select min(sal) from emp;
select count(sal) from emp;
select count(ename) from emp;
select count(comm) from emp; -- null은 미포함
select count(*) from emp; -- 성능고려하여 권장하지 않음
select avg(sal), truncate(avg(sal),4) from emp;

-- Waring : truncate emp; 데이터 복구 불가

-- 월평균 근무일수 21.5일, 하루 근무시간 8시간
-- 사원들 하루급여 : DAY_PAY, 시급 : TIME_PAY
-- 하루급여 소수접 세번째 자리에서 버리고, 시급은 두 번째 소수접에서 반올림
select empno, ename, sal,
truncate(sal/21.5, 2) as DAY_PAY,
round(sal/21.5/8, 1) as TIME_PAY
from emp;

select avg(SAL) as "10번부서평균연봉"
from emp
where deptno = 10;

-- Date 관련 표현 및 추출 함수
select date_format(hiredate, '%Y') from emp;
select date_format(hiredate, '%Y-%m') from emp;
select date_format(hiredate, '%Y-%m-%d') from emp;
select date_format(hiredate, '%Y-%m-%d %T') from emp;
select date_format(hiredate, '%Y-%m-%d %H') from emp;
select date_format(hiredate, '%Y-%m-%d %H:%i') from emp;
select date_format(hiredate, '%Y-%m-%d %H:%i:%s') from emp;
select date_format(hiredate, '%Y-%m-%d %H:%i:%s.%f') from emp;

select dayofmonth(hiredate) from emp; 
select month(hiredate) from emp;
select dayofyear(hiredate) from emp; 
select dayofyear(hiredate),
365-dayofyear(hiredate) as "holiday base" from emp; 

-- 원하는 데이터를 DATETIME 타입에서 추출하는 유용한 함수
select extract(quarter from hiredate) from emp;

-- Date 관련 연산 함수
-- 년도, 월, 일, 시, 분, 초, 밀리초 등

select adddate(hiredate, interval 60 day) from emp; 
select HIREDATE, adddate(hiredate, interval 6 month) from emp;
select subdate(hiredate, interval 60 day) from emp; 
select HIREDATE, subdate(hiredate, interval 6 month) from emp;

-- addtime(datetime, 'string format') => format된 문자가 곧 값
select date_format(hiredate, '%T'),
addtime(hiredate, 1) from emp; 
select date_format(hiredate, '%T'),
subtime(hiredate, 1) from emp; 

-- 연산 'YYMM', 'YYYYMM'을 기준으로 월 연산, 음수 허용함
select period_add(date_format(hiredate, '%Y%m'), 6) from emp; 
select period_add(date_format(hiredate, '%Y%m'), -6) from emp; 

-- 특정 날짜나 시간의 차이 연산
select datediff(hiredate, current_date()) from emp; 
select datediff(current_timestamp(), HIREDATE) from emp; 
select timediff(current_timestamp(), '2017-06-15 13:10:10');

-- 고급 함수
-- 조건 관련 함수
select ename, if(sal > 2000, 'HIGH', 'LOW') from emp;
select ename,
case 
	when sal > 2000 then 'HIGH'
	else 'LOW'
end
from emp;

select ename,
case 
	when sal > 3000 then 'SUPER'
	when sal > 2000 then 'HIGH'
	when sal > 1000 then 'MID'
	else 'LOW'
end
from emp;
select * from dept;
-- case 함수의 등가 조건
select ename,
case deptno
when 10 then 'ACCOUNTING'
when 20 then 'RESEARCH'
when 30 then 'SALES'
else 'OPERATIONS'
end as DNAME
from emp;

-- null 조건 판단
select sal, comm, ifnull(comm, 0) from emp;
select sal, comm, sal+comm as total from emp;
select sal, comm, sal+comm as total, sal + ifnull(comm,0) as real_total 
from emp;

-- null 여부 판단
select ename, isnull(comm) as "커미션을 받지 않는 사람" from emp;
select ename, if(ifnull(comm, 0) != 0, 'Y', null) as "커미션을 받는 사람"
from emp;

-- nullif : 두 값을 비교하여 같으면 null, 아니면 첫번째 파라미터 값을 출력
select sal, comm, sal+comm as total, sal + ifnull(comm,0) as real_total,
nullif(sal, sal + ifnull(comm,0)) as "커미션 받는 사람"
from emp; 

-- 타입 변환 함수
select ename, cast(HIREDATE as CHAR) from emp;
select ename, cast(HIREDATE as DECIMAL) from emp;
select ename, convert(hiredate, BINARY) from emp;

select * from emp;

-- 기타 시스템 함수
select connection_id();
select database();
select last_insert_id() from emp;
select user();

-- 입사일을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됩니다.
-- 사원들이 정직원이 되는 날짜를 YYYY-MM-DD 형식으로 R_JOB 컬럼에
-- 추가수당이 없는 사원은 comm을 N/A로 출력하세요
select empno, ename, hiredate,
case weekday(date_add(HIREDATE, interval 3 month))
when 6 then date_add(date_add(HIREDATE, interval 3 month), interval 1 day)
when 5 then date_add(date_add(HIREDATE, interval 3 month), interval 2 day)
when 4 then date_add(date_add(HIREDATE, interval 3 month), interval 3 day)
when 3 then date_add(date_add(HIREDATE, interval 3 month), interval 4 day)
when 2 then date_add(date_add(HIREDATE, interval 3 month), interval 5 day)
when 1 then date_add(date_add(HIREDATE, interval 3 month), interval 6 day)
else date_add(date_add(HIREDATE, interval 3 month), interval 7 day)
end as R_JOB,
ifnull(comm, 'N/A') as comm from emp;

-- by 엄성현
select empno, ename, hiredate,
ADDDATE(ADDDATE(HIREDATE, INTERVAL 3 month),
INTERVAL 7-(WEEKDAY(ADDDATE(HIREDATE, INTERVAL 3 month))) day)
as 'R_JOB',
ifnull(comm, 'N/A') as comm from emp;

-- CHG_MGR 컬럼에 직속 상관의 사원번호가 존재하지 않을 경우 : 0000
-- 앞 두자리가 75일 경우 : 5555
-- 앞 두자리가 76일 경우 : 6666
-- 앞 두자리가 77일 경우 : 7777
-- 앞 두자리가 78일 경우 : 8888
-- 그 외는 : 본래 직속 상관의 사원번호 그대로 출력
select ename, empno, mgr,
case 
	when mgr is null then '0000'
	when substr(mgr, 1, 2) = '78' then '8888'
	when substr(mgr, 1, 2) = '77' then '7777'
	when substr(mgr, 1, 2) = '76' then '6666'
	when substr(mgr, 1, 2) = '77' then '5555'
	else cast(mgr as CHAR) -- concat(mgr)도 가능
end as CHG_MGR
from emp;


