SELECT M.MEMBER_NAME, R3.REVIEW_TEXT, DATE_FORMAT(R3.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M JOIN (SELECT R1.MEMBER_ID, R1.REVIEW_TEXT, R1.REVIEW_DATE
                            FROM REST_REVIEW R1 JOIN (SELECT MEMBER_ID, COUNT(MEMBER_ID) AS CNT
                                                      FROM REST_REVIEW
                                                      GROUP BY MEMBER_ID
                                                      ORDER BY CNT DESC
                                                      LIMIT 1) R2 ON R1.MEMBER_ID=R2.MEMBER_ID) R3 ON M.MEMBER_ID=R3.MEMBER_ID
ORDER BY R3.REVIEW_DATE, R3.REVIEW_TEXT;
