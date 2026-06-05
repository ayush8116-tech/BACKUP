select to_char(payment_date, 'month'), round(sum(amount) / count(*)) as average from payment
group by to_char(payment_date, 'month')
