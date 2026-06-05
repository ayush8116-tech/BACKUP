select * from payment;
-- select customer_id, count(*) from payment
-- group by customer_id
-- having count(*) >= 40;

--challenge - 2
select customer_id,sum(amount) from payment
group by customer_id, staff_id
having sum(amount) > 100 and staff_id = 2