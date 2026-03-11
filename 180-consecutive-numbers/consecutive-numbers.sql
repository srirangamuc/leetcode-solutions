# Write your MySQL query statement below
select distinct num as ConsecutiveNums
from (
    select 
        num,
        lead(num,1) over (order by id) as next_1,
        lead(num,2) over (order by id) as next_2
    from Logs
) as temp
where num = next_1 and next_1 = next_2;