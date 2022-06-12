package uuu.Affection.test;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.Product;
import uuu.Affection.entity.ShopingCart;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;
import uuu.Affection.service.ProductService;

public class testCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductService pService =new ProductService();
		CustomerService cService= new CustomerService();
		
		
		try {
			Customer c =cService.login("A123456789", "bgg654");
			Product p1=pService.getProductId("1");
			Product p5=pService.getProductId("6");
						
			ShopingCart SpCart=new ShopingCart();
			
			SpCart.setCustomer(c);		
			
			SpCart.add(p1,1);
			SpCart.add(p5,3);
			
			System.out.println(SpCart);
			
			
			
			
		} catch (AffectionException e) {
			// TODO Auto-generated catch block
			System.out.println("購物失敗");;
		}
		
		
		
		
	}

}
