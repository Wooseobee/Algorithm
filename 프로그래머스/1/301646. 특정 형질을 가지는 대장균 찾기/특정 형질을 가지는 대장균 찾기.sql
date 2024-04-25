-- 코드를 작성해주세요

select count(*) as count
from ecoli_data
where 2 & genotype != 2 and (1 & genotype = 1 or 4 & genotype = 4);