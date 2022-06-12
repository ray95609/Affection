SELECT id, name, price, discount, stock, need, photoUrl, description,
 shelf_date,type, 
 (stock/need) as  percentage
 FROM affection_base.product 
 WHERE type= 'food'
ORDER BY percentage desc ;