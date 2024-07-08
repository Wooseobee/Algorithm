-- 코드를 작성해주세요
select count(*) as fish_count, a.fish_name
from (select fi.fish_type, fni.fish_name
      from fish_info fi join fish_name_info fni on fi.fish_type = fni.fish_type) a
group by a.fish_name
order by fish_count desc;