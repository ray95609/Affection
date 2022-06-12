package uuu.Affection.service;

import java.time.LocalDateTime;
import java.util.List;

import uuu.Affection.entity.CartItem;
import uuu.Affection.entity.Order;
import uuu.Affection.entity.OrderStatusLog;
import uuu.Affection.entity.Product;
import uuu.Affection.exception.AffectionException;

public class OrderService {
	
	private OrderDAO dao=new OrderDAO();
	
	public void checkout(Order order) throws AffectionException {
		
		dao.insert(order);
		
	}
	
	
	public List<Order>getOrderHistoryByCustomerId(String customerId)throws AffectionException{
		return dao.selectOrderHistoryByCustomerId(customerId);
	}
	
	
	public Order getOrderHistoryByCustomerIdDetail(String OrderId, String customerId)throws AffectionException{
		return dao.selectOrderHistoryByCustomerIdDetail(OrderId, customerId);
	}

	public void updateStatusToTransfered(String customerId, String orderId,
			String bank, String trans_account, double trans_amount, LocalDateTime transDateTime) throws AffectionException {
		String note="銀行:" + bank + ", 後5碼:" + trans_account + ", 金額:" + trans_amount + ",轉帳日期:" + transDateTime;
		dao.updateStatusToTransfered(customerId,orderId, note);
	}
	
	
	/**
	 * @param orderId
	 * @return
	 * @throws VGBException
	 * @see uuu.vgb.service.OrdersDAO#selectOrderStatusLog(java.lang.String)
	 */
	public List<OrderStatusLog> getOrderStatusLog(String orderId) throws AffectionException {
		return dao.selectOrderStatusLog(orderId);
	}
	

}
