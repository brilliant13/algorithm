-- 코드를 입력하세요
SELECT ANIMAL_ID, ANIMAL_TYPE, NAME
FROM ANIMAL_OUTS
WHERE SEX_UPON_OUTCOME NOT IN ('Intact MALE','Intact Female')
AND ANIMAL_ID IN 
(SELECT ANIMAL_ID FROM ANIMAL_INS WHERE SEX_UPON_INTAKE IN ('Intact Male','Intact Female'))
ORDER BY ANIMAL_ID;


/*
ANIMAL_INS (동물 보호소에 들어온 동물들)
: SEX_UPON_INTAKE(성별 및 중성화 여부)
ANIMAL_ID (동물 보호소에서 입양 보낸 동물들)
: SEX_UPON_OUTCOME(성별 및 중성화 여부)

보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다
보호소에 들어올 당시에는 "중성화 되지 않았지만", 
보호소를 "나갈 당시에는 중성화된" 
동물의 아이디와 생물 종, 이름을 조회하는 "아이디 순"으로 조회하는 SQL. order by

INS에서 INTACT인 애들 서브쿼리로 가져오고,
ANIMAL_OUTS테이블에서 해당 ANIMAL_ID인 애들 SEX가 INTACT가 아니면 나갈 때 중성화수술이 된것이다.

WHERE 조건 2개 달면 되겠는데, ID같고, SEX가 INTACT가 아니고
*/