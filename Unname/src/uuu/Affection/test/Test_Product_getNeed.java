package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.entity.CartItem;
import uuu.Affection.entity.Product;
import uuu.Affection.entity.ShopingCart;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.OrderService;
import uuu.Affection.service.ProductService;

public class Test_Product_getNeed {

	public static void main(String[] args) {
		
				OrderService oService =new OrderService();
				ProductService pService= new ProductService();
				
				Product p1;
				try {
					p1 = pService.getProductId("1");
					ShopingCart SpCart=new ShopingCart();
					CartItem item =new CartItem();
					item.setProduct(p1);
					
					int need=0;
					
					need=pService.selectNeed(item);
					System.out.println(need);
				} catch (AffectionException e) {
					System.out.println("查詢需求量失敗:"+e);
					Logger logger =Logger.getLogger("TtestNeed");
					logger.log(Level.SEVERE, e.getMessage(), e);
				}
				
				
				
}
}