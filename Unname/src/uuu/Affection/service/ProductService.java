package uuu.Affection.service;

import java.util.List;

import uuu.Affection.entity.CartItem;
import uuu.Affection.entity.Product;
import uuu.Affection.exception.AffectionException;

public class ProductService {
	private ProductDAO dao =new ProductDAO();
	public List<Product> getAllProduct() throws AffectionException{
		return dao.selectAllProduct();
		
	};
	
	public List<Product> getProductByKeyword(String keyword) throws AffectionException{
		return dao.selectProductByKeyword(keyword);
	}
	
	public List<Product> getProductByType(String type) throws AffectionException{
		return dao.selectProductByType(type);
	}
	
	
	public Product getProductId(String id) throws AffectionException{
		return dao.selectProductId(id);
		
	}
	
	public List<Product> getProductSos(String sos) throws AffectionException{
		return dao.selectProductSos(sos);
		
	}
	
	
	public int selectNeed(CartItem item) throws AffectionException {
		int need=0;
		Product p =item.getProduct();
		need=dao.selectNeed(String.valueOf(p.getId()));
		
		return need;
	}
	
	
	
}
