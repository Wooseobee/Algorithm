-- 코드를 입력하세요
SELECT DISTINCT CAR_ID,
    CASE
    WHEN CAR_ID IN (SELECT CAR_ID
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                              WHERE DATE_FORMAT(START_DATE, '%Y-%m-%d')<=DATE_FORMAT('2022-10-16', '%Y-%m-%d')
                                AND DATE_FORMAT(END_DATE, '%Y-%m-%d')>=DATE_FORMAT('2022-10-16', '%Y-%m-%d')) THEN '대여중'
    ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
ORDER BY CAR_ID DESC;