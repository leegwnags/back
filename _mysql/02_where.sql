-- where 조건
-- 조건 설정은 equal, non-equal 형식이 있다

-- equal (=)
select * from emp
where empno = 7839;

select * from emp
where deptno = 30;

-- not equal (!=, <>, not, is)
select  * from  emp
where empno != 7839;

select * from emp
where deptno <> 30;

select * from  emp
where ename <> 'KING';

select * from emp
where not sal = 3000;

select * from emp
where comm is null;

select * from emp
where not comm is null;

select * from emp
where comm is not null;

-- not-equal (>, <, <=, >=, not)
select * from emp
where sal > 1000;

select * from emp
where sal <= 2000;

select * from emp
where not ename > 'F';

-- 논리연산 (and, or, not)
-- and 
select * from emp
where sal > 1000 and sal < 2000;

select * from emp
where sal <1000 or sal > 2000;

select * from emp
where sal between 1250 and 3000; -- 이상 이하 검색 : 값을 포함!

select * from emp
where sal not between 1250 and 3000; -- 미만 초과 검색 : 값 미포함!

-- king의 정보를 모두 출력하는데
-- king이라는 이름사용x, sal=5000 사용X, job='president' 사용X
select * from emp where mgr is null;

-- 문자검색 : %(포함), _(문자자리수) 와일드카드
-- 사원명에 S가 포함되는 사원정보
select * from emp
where ename like '%S%';

-- 사원명이 M으로 시작되는 사원정보
select * from emp
where ename like 'M%';

-- 사원명이 T로 끝나는 사원정보
select * from
where ename like '%T';

-- 직책명이 두번째 알파벳이 N으로 시작되는 사원들의 정보
select * from emp
where job like '_N%';

-- 직책명이 뒤에서 세번째 알파벳이 M이며 S로 시작하는 사원들의 정보
select * from emp
where job like 'S%M__';

-- 직책명이 앞에서 세번째 알파벳이 T가 아닌 사원들의 정보
select * from emp
where job not like '__A%';

-- in 연산자 : or 연산자와 비슷함
select * from emp
where sal < 1000 or sal = 3000 or sal = 5000;

select * from emp
where sal = 800 or sal = 1500 or sal = 3000;

select * from emp
where sal in (800, 1500, 3000);

select * from emp
where job in ('SALESMAN', 'CLERK');

-- 추가 수당이 존재하지 않고 상급자가 있고 직책기 MANAGER, CLERK인 사원중에서
-- 사원 이름의 두 번째 글자가 L이 아닌 사원의 정보를 출력하는 SQL문을 작성해보세요.
select * from emp
where comm is null 
and mgr is not null 
and job in ('MANAGER', 'CLERK')
and ename not like '_L%';