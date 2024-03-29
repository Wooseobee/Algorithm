-- 코드를 입력하세요
SELECT F1.CATEGORY, MAX(F1.PRICE) AS MAX_PRICE, F1.PRODUCT_NAME
FROM FOOD_PRODUCT F1, (SELECT CATEGORY, MAX(PRICE) AS PRICE
                       FROM FOOD_PRODUCT
                       GROUP BY CATEGORY
                       HAVING CATEGORY IN ('과자', '국', '김치', '식용유')) F2
WHERE F1.PRICE = F2.PRICE AND F1.CATEGORY = F2.CATEGORY
GROUP BY F1.CATEGORY
ORDER BY F1.PRICE DESC;