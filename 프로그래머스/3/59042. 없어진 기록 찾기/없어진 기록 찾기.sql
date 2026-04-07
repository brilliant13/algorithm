
SELECT o.ANIMAL_ID, o.NAME
from animal_ins i
right join animal_outs o on i.animal_id = o.animal_id
-- where i.name is null
where i.animal_id is null
order by animal_id;

/*
*/