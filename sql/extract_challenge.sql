select distinct(to_char(payment_date, 'MONTH')) from payment;
--challenge - 2
select count(extract(dow from payment_date)) from payment
where extract(dow from payment_date) = 1;

select to_char(payment_date, 'day') as payment_day from payment
where trim(to_char(payment_date, 'day')) = 'monday'
