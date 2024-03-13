select sc.score, sc.emp_no, he.emp_name, he.position, he.email
from (select emp_no, sum(score) as score
    from hr_grade
    group by emp_no) sc join hr_employees he on sc.emp_no = he.emp_no
order by score desc
limit 1;