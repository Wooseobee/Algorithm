-- 코드를 작성해주세요
select b.QUARTER, count(b.QUARTER) as ECOLI_COUNT
from ECOLI_DATA a join (select 
case 
    when convert(substr(DIFFERENTIATION_DATE, 6, 2),unsigned) between 1 and 3 then '1Q'
    when convert(substr(DIFFERENTIATION_DATE, 6, 2),unsigned) between 4 and 6 then '2Q'
    when convert(substr(DIFFERENTIATION_DATE, 6, 2),unsigned) between 7 and 9 then '3Q'
    when convert(substr(DIFFERENTIATION_DATE, 6, 2),unsigned) between 10 and 12 then '4Q'
end as QUARTER, id
from ECOLI_DATA) b on a.id = b.id
group by b.QUARTER
order by b.QUARTER;