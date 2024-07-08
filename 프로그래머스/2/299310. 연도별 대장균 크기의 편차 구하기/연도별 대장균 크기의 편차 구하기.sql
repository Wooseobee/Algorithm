-- 코드를 작성해주세요
select b.year, (b.big - a.size_of_colony) as year_dev, a.id
from ecoli_data a, (select max(size_of_colony) as big, year(differentiation_date) as year
      from ecoli_data
      group by year(differentiation_date)) b
where year(a.differentiation_date) = b.year
order by b.year, year_dev;