SELECT * FROM affection_base.product;
SELECT * FROM affection_base.product_type;

SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date 
	   ,product_price.price_price as price 
FROM affection_base.product
LEFT JOIN product_price ON product.id=product_price.price_id
WHERE id='24';
