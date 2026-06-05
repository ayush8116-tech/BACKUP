select email
from customer
inner join address
on customer.address_id = address.address_id
where district = 'California';

-- challenge - 2 
select * from film;
select * from actor;
select * from film_actor;

select title.title, first_name, last_name from actor
inner join film_actor id
on actor.actor_id = id.actor_id
inner join film title
on id.film_id = title.film_id
where first_name = 'Nick' and last_name = 'Wahlberg';