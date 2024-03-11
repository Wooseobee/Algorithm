-- 코드를 작성해주세요

select HE.EMP_NO, HE.EMP_NAME,
    case
        when avg(HG.SCORE) >= 96 then 'S'
        when avg(HG.SCORE) >= 90 then 'A'
        when avg(HG.SCORE) >= 80 then 'B'
        else 'C'
    end as 'GRADE',
    case
        when avg(HG.SCORE) >= 96 then HE.SAL*0.2
        when avg(HG.SCORE) >= 90 then HE.SAL*0.15
        when avg(HG.SCORE) >= 80 then HE.SAL*0.1
        else 0
    end as 'BONUS'
from HR_EMPLOYEES HE join HR_GRADE HG on HE.EMP_NO=HG.EMP_NO
group by EMP_NO
order by EMP_NO;