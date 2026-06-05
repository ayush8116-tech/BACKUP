select extract(week from payment_date) from payment;
select age(payment_date) from payment;
select to_char(payment_date, 'week day') from payment;
-- select * from payment