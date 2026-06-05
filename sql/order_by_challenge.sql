select customer_id from payment
order by payment_date
limit 10;

--challenge - 2
select title from film
order by length
limit 5;

 --bonus challenge
select count (length) from film
where length <= 50