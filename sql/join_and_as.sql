select customer_id, sum(amount) as spent from payment
group by customer_id
order by spent;

select * from customer;
select * from payment;

select payment.customer_id, first_name, sum(amount)
from payment 
inner join customer
on payment.customer_id = customer.customer_id
group by payment.customer_id, first_name;

select *
from film
full outer join inventory 
on film.film_id = inventory.film_id
where inventory.film_id is null

-- select film.film_id, title, inventory_id, film.length, store_id
-- from film
-- left join inventory 
-- on film.film_id = inventory.film_id
-- where inventory.film_id is null
-- order by film_id;

-- select * from store


