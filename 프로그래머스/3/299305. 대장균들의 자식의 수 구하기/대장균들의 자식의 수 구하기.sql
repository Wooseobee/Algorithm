-- 코드를 작성해주세요
select e3.id, ifnull(e4.cnt, 0) as child_count
from ecoli_data e3 left join
(select e1.id, count(e1.id) as cnt
from ecoli_data e1 join ecoli_data e2 on e1.id = e2.parent_id
group by e1.id) e4 on e3.id = e4.id
order by e3.id;