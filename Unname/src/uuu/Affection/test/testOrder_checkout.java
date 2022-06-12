package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.Order;
import uuu.Affection.entity.PaymentType;
import uuu.Affection.entity.Product;
import uuu.Affection.entity.ReceiptType;
import uuu.Affection.entity.ShopingCart;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;
import uuu.Affection.service.OrderService;
import uuu.Affection.service.ProductService;

public class testOrder_checkout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductService pService =new ProductService();
		CustomerService cService= new CustomerService();
		
		
		try {
			Customer c =cService.login("A123456789", "bgg654");
			Product p14=pService.getProductId("14");
			Product p5=pService.getProductId("6");
						
			ShopingCart SpCart=new ShopingCart();
			
			SpCart.setCustomer(c);		
			
			SpCart.add(p14,1);
		
			
			Order order=new Order(); 
			order.setMember(c);
			order.setOrdername(c.getName());
			order.setOrderaddress("厲害區");
			order.setOrderphone("0922222222");
			
			order.setPaymentType(PaymentType.ATM);
			order.setReceiptType(ReceiptType.PAPER);
			
			order.add(SpCart);
			
			System.out.println(order);
			
			OrderService oService= new OrderService();
			oService.checkout(order);
			
				
			//System.out.println(order);
			
			
		} catch (AffectionException e) {
			
			System.out.println("購物失敗:"+e);
			Logger logger =Logger.getLogger("TtestOrder_checkout");
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
		
		
		
	}

}