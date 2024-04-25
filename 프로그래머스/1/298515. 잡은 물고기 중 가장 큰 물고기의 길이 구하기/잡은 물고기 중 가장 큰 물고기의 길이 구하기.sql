-- 코드를 작성해주세요

select max(concat(length, 'cm')) as max_length
from fish_info
order by length desc
limit 1;