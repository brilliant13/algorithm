-- 코드를 입력하세요
SELECT i.FLAVOR
FROM FIRST_HALF f
JOIN ICECREAM_INFO i ON f.flavor = i.flavor
WHERE TOTAL_ORDER >= 3000 AND INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC;

/*
상반기 주문 정보 담은 테이블
아이스크림 성분에 대한 정보 테이블

상반기 아이스크림 총주문량이 3,000보다 높으면서
아이스크림의 주 성분이 과일인 아이스크림의 맛을
*/