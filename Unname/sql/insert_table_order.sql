INSERT INTO `affection_base`.`order`
(`id`,`order_date`,`order_time`,`paymentType`,`paymentNote`,
`recipient_name`,`recipient_phone`,`recipient_address`,`ReceiptType`,
`status`,`customer_id`)
VALUES (0,'2021-10-07','','ATM','','李三寶','0911223344','不500區','Electronic Receipt',0,'A132997293');
INSERT INTO `affection_base`.`order_item`
(`order_id`,`product_id`,`price`,`quantity`)
VALUES('1','1','100','1');
