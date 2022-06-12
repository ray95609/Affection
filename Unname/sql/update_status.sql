UPDATE affection_base.order 
SET status=1,paymentNote='郵局'
WHERE customer_id='A123456789' AND id=3 
AND status=0 AND paymentType='ATM';

SELECT id, customer_id, status,
 paymentNote, paymentType
 FROM affection_base.order
 WHERE  customer_id='A123456789' AND id=3;