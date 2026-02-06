-- 코드를 입력하세요
-- FIRST_HALF 테이블은 아이스크림 가게의 상반기 주문 정보를 담은 테이블
-- SHIPMENT_ID, FLAVOR, TOTAL_ORDER
-- 총주문량을 기준으로 내림차순 정렬
SELECT flavor from first_half order by total_order desc, shipment_id;