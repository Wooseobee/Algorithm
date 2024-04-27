-- 코드를 작성해주세요
select f.fish_count, f.max_length, f.fish_type
from
(select fish_type, avg(ifnull(length, 10)) as avg, max(length)as max_length, count(id) as fish_count
from fish_info
group by fish_type) as f
where f.avg >= 33
order by f.fish_type;