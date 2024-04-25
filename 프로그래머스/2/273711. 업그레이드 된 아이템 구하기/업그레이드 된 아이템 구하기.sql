-- 코드를 작성해주세요
select i.item_id, i.item_name, i.rarity
from item_info i right join (select t.item_id
                        from item_tree t join item_info i on i.item_id = t.parent_item_id
                        where rarity = 'rare') s on i.item_id = s.item_id
order by i.item_id desc;