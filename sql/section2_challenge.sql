select count(amount) from payment
where amount > 5;   --3618

-- challenge - 2

select count(first_name) from actor
where first_name like 'P%';     --5

--challenge -3

select count(distinct(district)) from address; --378

--challenge -4
select distinct district from address ;

--challenge -5
select count(rating) from film
where rating = 'R' and replacement_cost between 5 and 15; --52

--challenge -6
select count(*) from film
where title like '%Truman%'; --5

--challenge -7


