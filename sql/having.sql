select * from payment;
select customer_id , sum(amount) from payment
group by customer_id
having sum(amount) between 170 and 190
