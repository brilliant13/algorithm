-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF F
JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR
GROUP BY INGREDIENT_TYPE;

/*
first_half 테이블(상반기 주문 정보) [출하 번호, 맛(PF), 총 주문량]

icecream_info 테이블(아이스크림 성분에 대한 정보) [맛(PF,FK), 성분타입]

INGREDIENT_TYPE에는 아이스크림의 주 성분이 설탕이면 sugar_based라고 입력되고, 아이스크림의 주 성분이 과일이면 fruit_based라고 입력됩니다.
*/