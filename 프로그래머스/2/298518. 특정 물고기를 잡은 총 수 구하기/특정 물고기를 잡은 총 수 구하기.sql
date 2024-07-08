-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info fi join (select fish_type
                        from fish_name_info
                        where fish_name='BASS' or fish_name='SNAPPER') fni on fi.fish_type = fni.fish_type;