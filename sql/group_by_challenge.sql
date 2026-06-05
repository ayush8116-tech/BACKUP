select * from payment;

select staff_id, count(*) from payment
group by staff_id;
 --challenge - 2

select * from film;
select rating,avg(replacement_cost) from film
group by rating;

--chalenge - 3
select * from payment;
select customer_id , sum(amount) from payment
group by customer_id
order by sum(amount) DESC
limit 5
