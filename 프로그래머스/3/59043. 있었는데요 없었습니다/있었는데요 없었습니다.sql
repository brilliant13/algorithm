-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS i
JOIN ANIMAL_OUTS o on i.animal_id = o.animal_id 
WHERE i.datetime > o.datetime
ORDER BY i.datetime;

/*
ANIMAL_INS 테이블 (동물 보호소에 들어온 동물들)
: 보호 시작일(DATETIME)
ANIMAL_OUTS 테이블 (동물 보호소에서 입양 보낸 동물들)
: 입양일(DATETIME)

관리자의 실수로 일부 동물의 입양일이 잘못 입력되었다.
보호 시작일(DATETIME)보다 입양일(DATETIME)이 더 빠른 동물의 아이디와 이름을 조회하는
SQL문 작성. 결과는 "보호 시작일이 빠른 순"으로 조회해야 한다. order by


*/