-- 코드를 작성해주세요
select f.id, ff.fish_name, f.length
from fish_info f join (select fi.fish_type, fni.fish_name, fi.length
                       from (select fish_type, max(length) as length
                             from fish_info
                             group by fish_type) fi join fish_name_info fni on fi.fish_type = fni.fish_type) ff on f.fish_type=ff.fish_type and f.length=ff.length;