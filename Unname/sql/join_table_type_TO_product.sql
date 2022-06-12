/*INNer JOIN*/
SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date, type_name 
FROM affection_base.product
JOIN product_type 
ON product.id=product_type.type_id;
