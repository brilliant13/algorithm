-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK b
JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE b.CATEGORY ='경제'
ORDER BY PUBLISHED_DATE ASC

/*
'경제' 카테고리에 속하는 도서들의 도서 ID,저자명,출판일 리스트를 출력하라.
출판일을 기준으로 오름차순 order by
PUBLISHED_DATE의 데이트 포맷이 예시와 동일해야 정답처리 됩니다.
SELECT DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
*/