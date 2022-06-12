SELECT  order.id, status, customer_id, name,
		paymentType, paymentNote, recipient_name, recipient_phone,
        recipient_address, ReceiptType,
	    order_id, product_id, order_item.price, quantity,
		order_date, order_time
        ,(order_item.price*quantity) as amount
FROM affection_base.order 
		JOIN order_item ON order.id=order_id
        JOIN product ON product_id=product.id
WHERE order.id='14' AND customer_id='A123456789' ;