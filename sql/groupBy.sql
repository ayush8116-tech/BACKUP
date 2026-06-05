select customer_id, staff_id, sum(amount), count(amount) from payment
group by staff_id, customer_id
order by customer_id;

select date(payment_date), sum(amount) from payment
group by date(payment_date)



