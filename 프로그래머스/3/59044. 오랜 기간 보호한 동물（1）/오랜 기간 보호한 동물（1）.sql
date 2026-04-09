-- 코드를 입력하세요
# select version();


# SELECT NAME, DATETIME
# FROM ANIMAL_INS
# WHERE NAME IN
# (SELECT NAME FROM ANIMAL_INS EXCEPT SELECT NAME FROM ANIMAL_OUTS)
# ORDER BY DATETIME ASC LIMIT 3;

SELECT NAME, DATETIME
FROM ANIMAL_INS
WHERE ANIMAL_ID IN
(SELECT ANIMAL_ID FROM ANIMAL_INS EXCEPT SELECT ANIMAL_ID FROM ANIMAL_OUTS)
ORDER BY DATETIME ASC LIMIT 3;


-- ORDER BY DATETIME LIMIT 3;
-- JOIN ON
-- WHERE
-- ORDER BY LIMIT 3
/*
ANIMAL_INS (동물 보호소에 들어온 동물들)
ANIMAL_OUTS (동물 보호소에서 입양 보낸 동물들)

아직 입양을 못 간 동물들 중, 
가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문. 결과는 "보호 시작일"순으로 조회해야 한다. order by

입양을 못 간거면, OUTS테이블에 없는 놈만 찾아야 하는데,
그럼 뺴야하나? INS - OUTS 관계대수 차집합 연산하면 목표한 것만 남는데.

*/