select distinct(customer_id) from customer
where first_name not ilike 'J%';

select count(customer_id) from customer
where first_name not ilike 'J%';

-- select * from customer
-- where first_name not ilike 'J%'
