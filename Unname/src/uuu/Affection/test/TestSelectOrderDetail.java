package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.Order;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;
import uuu.Affection.service.OrderService;

public class TestSelectOrderDetail {

	public static void main(String[] args) {
		CustomerService cService=new CustomerService(); 
		try {
			Customer c=cService.login("A123456789", "bgg654");	
			
			//System.out.println("c:"+c);
			
			OrderService oService=new OrderService();
			Order order=oService.getOrderHistoryByCustomerIdDetail("14", c.getId());
			
		
			
			
			System.out.println("order:"+order);
			
		}catch (AffectionException e) {
			Logger.getLogger("查訂單明細").log(Level.SEVERE,e.getMessage(),e);
		}
		
		
		

	}

}
