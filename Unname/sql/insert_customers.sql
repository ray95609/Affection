USE affection;

/*sql的註解
 * sql都用單引號''
 * 避免與""java雙引號衝突*/

SELECT id, password, name, email, birthday, gender, phone, address, subscribe FROM affection_base.customers;

INSERT INTO `affection_base`.`customers` (`id`, `password`, `name`, `email`, `birthday`, `gender`, `phone`, `address`, `subscribe`) 
VALUES ('A123123123', 'CTT', '尤構豪笑', 'CTT@gmail.com', '2000-01-01', 'M', '0911111111', '台東市富岡區海灣3333號', '0');

INSERT INTO `affection_base`.`customers` (`id`, `password`, `name`, `email`, `birthday`, `gender`, `phone`, `address`, `subscribe`) 
VALUES ('A123456789', 'bgg', '杜紫萼', 'bgg@mail.com', '1991-07-04', 'F', '0900000000', '台南市永康區成功路20000號', '1');