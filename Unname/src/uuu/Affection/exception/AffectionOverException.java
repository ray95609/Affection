package uuu.Affection.exception;

import uuu.Affection.entity.Product;

public class AffectionOverException extends AffectionException {

	private final Product p;	
	
	public AffectionOverException(Product p) {
		this(p, "需求目標已達，可考慮捐贈其他物資");
		
	}

	public AffectionOverException(Product p, String message, Throwable cause) {
		super(message, cause);
		this.p = p;
	}

	public AffectionOverException(Product p, String message) {
		super(message);
		this.p=p;
	}

	/**
	 * @return the p
	 */
	public Product getProduct() {
		return p;
	}

	@Override
	public String toString() {
		return (p!=null?p.getName():"") + getMessage();
	}	
 
 
	
	
	
	
	
	
	
	
	
}
