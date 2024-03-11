select 
    case
        when D.SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') and D.SKILL_CODE & (select sum(CODE) from SKILLCODES where NAME = 'Python') then 'A'
        when D.SKILL_CODE & (select sum(CODE) from SKILLCODES where NAME = 'C#') then 'B'
        when D.SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = 'Front End') then 'C'
    end as GRADE, D.ID, D.EMAIL
from DEVELOPERS D
group by GRADE, D.ID, D.EMAIL
HAVING GRADE IS NOT null
order by GRADE, D.ID;