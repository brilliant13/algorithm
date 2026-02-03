
SELECT ROUND(AVG(DAILY_FEE),0) as AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR as a WHERE a.CAR_TYPE = 'SUV' group by a.CAR_TYPE;
# 다음은 어느 자동차 대여 회사에서 대여중인 자동차들의 정보를 담은 CAR_RENTAL_COMPANY_CAR테이블이다.
# 이 테이블은 CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS라는 속성으로 이루어져있다.
# 자동차 종류 => 세단, SUV, 승합차, 트럭, 리무진
# 자동차 옵션 => 주차감지센서, 스마트키, 네비게이션, 통풍시트, 열선시트, 후방카메라, 가죽시트

#CAR_RENTAL_COMPANY_CAR 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문