SELECT  affection_base.order.id, status, customer_id, name, 
	    order_item.*,
		order_date, order_time
        ,(order_item.price*order_item.quantity) as amount
FROM affection_base.order 
		JOIN order_item ON affection_base.order.id=order_item.order_id
        JOIN product ON order_item.product_id=product.id
WHERE customer_id="A123456789"
ORDER BY id desc ;