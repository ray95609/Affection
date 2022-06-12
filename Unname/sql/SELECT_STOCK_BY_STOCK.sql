/*查詢 need stock BY id*/
SELECT id, need ,stock
FROM product
WHERE id='14';


/*UPDATE need stock BY id*/
UPDATE product  SET need=need-2
WHERE need>=2  AND id='14';

UPDATE product SET stock=stock+2
WHERE id='14';