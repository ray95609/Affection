SELECT  affection_base.order.id, status, customer_id, name,
		paymentType, paymentNote, recipient_name, recipient_phone,
        recipient_address, ReceiptType,
	    order_item.order_id, order_item.product_id, order_item.price, order_item.quantity,
		order_date, order_time
        ,(order_item.price*order_item.quantity) as amount
FROM affection_base.order 
		JOIN order_item ON affection_base.order.id=order_item.order_id
        JOIN product ON order_item.product_id=product.id
WHERE affection_base.order.id='14' AND customer_id='A123456789'
ORDER BY id desc ;