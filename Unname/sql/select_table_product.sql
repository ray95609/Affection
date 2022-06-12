SELECT * FROM affection_base.product
/*以id查詢*/
WHERE id="2" ;

/*查詢最新上架3筆*/
SELECT id, name, uni_price, discount, stock, need, photo_url, description, shelf_date FROM affection_base.product
ORDER BY shelf_date DESC LIMIT 5;

/*查詢全部*/
SELECT id, name, uni_price, discount, stock, need, photo_url, description, shelf_date FROM affection_base.product;

/*關鍵字查詢*/
SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date,type  FROM affection_base.product
WHERE name LIKE '%%';

/*分類查詢*/
SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date,type,  
(stock/need) as  percentage
FROM affection_base.product
WHERE type='Food'
ORDER BY percentage desc;

/*需求查詢*/
SELECT id, name, price, discount, stock, need, photoUrl, description, shelf_date,type,  
(stock/need) as  percentage
FROM affection_base.product
WHERE type='Food'
ORDER BY percentage desc;