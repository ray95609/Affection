SELECT * FROM affection_base.product;
SELECT * FROM affection_base.product_type;

SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date 
	   ,product_type.type_name as type 
FROM affection_base.product
LEFT JOIN product_type ON product.id=product_type.type_id
WHERE id='1';
