-- 코드를 입력하세요
SELECT car_id,
        case
            when max(start_date <='2022-10-16' and end_date >= '2022-10-16') = 1
            then '대여중'
            else '대여 가능'
        end as availability
from car_Rental_company_rental_history
group by car_id
order by car_id desc;