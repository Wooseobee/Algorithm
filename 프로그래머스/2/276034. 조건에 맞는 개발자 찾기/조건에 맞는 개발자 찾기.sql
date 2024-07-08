-- 코드를 작성해주세요

select distinct(d.id), d.email, d.first_name, d.last_name
from developers d join (select code
                        from skillcodes 
                        where name in ('Python', 'C#')) s on d.skill_code & s.code >= 1
order by d.id;