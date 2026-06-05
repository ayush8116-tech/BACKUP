select * from film;
select a.title as one, b.title as two from film as a
join film as b
on a.length = b.length
where a.title != b.title
