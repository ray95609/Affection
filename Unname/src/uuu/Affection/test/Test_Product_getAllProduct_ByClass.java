package uuu.Affection.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.Affection.exception.AffectionException;
import uuu.Affection.service.CustomerService;
import uuu.Affection.service.ProductService;

public class Test_Product_getAllProduct_ByClass {

	public static void main(String[] args) {
		
				ProductService pService=new ProductService();
							
				try {
					System.out.println(pService.getProductByType("Food"));
				} catch (AffectionException e) {
				System.out.println(e.getMessage());	//for user
				//e.printStackTrace();				//for developer
				Logger logger =Logger.getLogger("Test_ProductDAO");
				//logger.addHandler(指定fileHandler);//記錄到錯誤日誌中 方便日後查詢 fileHandler也需要宣告
				logger.log(Level.SEVERE, e.getMessage(), e);
				//Logger.getLogger("...").log(Level.SEVERE,e.getMessage(),e );
				}

	}

}
