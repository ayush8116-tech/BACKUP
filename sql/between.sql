select count(*) from payment
where amount not between 8 and 9;

select * from payment
where payment_date between '2007-02-14' and '2007-02-16'
order by payment_date desc