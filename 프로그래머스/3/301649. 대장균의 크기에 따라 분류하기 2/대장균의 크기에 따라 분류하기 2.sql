with cte as (
    select id, rank() over(order by size_of_colony desc) as rnk, max(id) over() as total
    from ecoli_data
)

select id,
    case 
        when rnk <= total * 0.25 then 'CRITICAL'
        when rnk <= total * 0.5 then 'HIGH'
        when rnk <= total * 0.75 then 'MEDIUM'
        else 'LOW'
    end as colony_name
from cte
order by id;