SELECT T.FLAVOR
FROM (SELECT F.FLAVOR, F.TOTAL_ORDER + J.TOTAL AS TOTAL
      FROM FIRST_HALF F, (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL
                          FROM JULY
                          GROUP BY FLAVOR) AS J
      WHERE F.FLAVOR=J.FLAVOR
      ORDER BY TOTAL DESC) AS T
LIMIT 3;