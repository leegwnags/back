-- order by : 정렬 후 출력 : select 한 후 수행하기 때문에 성능고려 대상
select * -- 3
from emp -- 1
where empno != 7839; -- 2
order by empno desc; -- 4 => 출력 결과를 재배치하므로 성능에 최악이 될 수 있음

-- pk 가 아닌 컬럼을 기준으로 정렬할 때 최악의 성능 저하가 발생할 수 있음
select empno, ename, sal ,deptno
from emp
where deptno = 10
order by sal desc; -- 역정렬

select empno, ename, sal, deptno
from emp
where deptno = 10
order by sal; -- 순차정렬 asc가 생략되어 있는 것임

select empno, ename, sal, deptno
from emp
where deptno = 10
order by 3; -- 출력한 컬럼 중 3번째

select empno as eno, ename as en, sal as s, deptno as eno
from emp
where deptno = 10
order by s desc;

-- 정렬의 기준이 2개 이상인 경우? : 같은 값인 경우에 한해 다음 정렬 기준을 따른다
-- 정렬한 후 같은 값이 있을 경우,로 분리된 정렬 기준을 순차적으로 적용한다
select empno as eno, ename as en, sal as s, deptno as eno
from emp
where sal >= 1000
order by s desc, 2;

-- 부서번호가 빠른 사원부터 출력하되 같은 부서 내의 사원을 출력할 경우
-- 최근에 입사한 사원부터 출력
-- 출력 컬럼 : 부서번호, 사원번호, 입사일, 사원명, 급여
select deptno, empno, hiredate, ename, sal 
from emp 
order by deptno, hiredate desc;