DROP TRIGGER IF EXISTS log_orders_status;
delimiter //
CREATE  TRIGGER log_orders_status AFTER UPDATE ON affection_base.order FOR EACH ROW
BEGIN
		IF (old.status != new.status) THEN
            INSERT INTO order_status_log(order_id, old_status, new_status) 
		VALUES (new.id, old.status, new.status);        
    END IF;    
END;//
delimiter ;log_orders_status
