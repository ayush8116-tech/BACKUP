select btrim(title, 'Diayscngsuoerd') from film
where title like 'D%';

select title,char_length(title) from film
group by char_length(title), title;

select title from film;

select title, position('a' in title) from film
where position('a' in title) = 0;

select * from actor;
select rpad(first_name,10,'0') from actor;

select upper(substring(first_name from 2)) as part_of_name from actor
