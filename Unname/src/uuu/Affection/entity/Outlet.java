package uuu.Affection.entity;

public class Outlet extends Product {
 
	private int discount;
		 
	public Outlet() {super();}

	public Outlet(int id) {super(id);}

	public int getDiscount() {return discount;}
	 
	public void setDiscount(int discount) {this.discount = discount;}
	 
	public String getDiscounting() 
	{int discount=(100-this.discount);
	if (discount%10==0)
	{return (discount/10+"折");}	//台灣人習慣用x折(8折)
	else
	return discount+"折"	;//台灣人習慣用xx折(85折)
	}
	
	
	/**
	 * 折扣後售價
	 * 將父類別中的getPrice(售價)方法以overriding重新定義成折扣後售價
	 */
	//overriding method
	//子類別中的方法 1.存取權限一樣或更大 2.回傳型別一樣或為子類別 3.方法名稱一樣 4.參數一樣
	//父類別的舊方法,子類別重新定義
	//super呼叫父類別方法
	@Override
	public double getPrice() 
	{double unitprice=super.getPrice()*(100-this.discount)/100;//product中的price須改為protected
	return unitprice;}
	
	
	/**
	 * 查原價
	 * 因為getPrice方法被overriding重新定義成折扣後價格
	 * 所以在做一支原價的方法
	 * @return
	 */
	public double getListPrice() 
	{return super.getPrice();}//super.可以呼叫父類別的方法

	@Override
	public String toString() {
		return super.toString()
				+"\n優惠折扣:"+ discount+"%off" 	
				+ "\n優惠折扣:" + getDiscounting() 
				+"\n售價:" +(int) getPrice()
				+ "\n定價:" +(int)  getListPrice() ;
	}
	
	
	
	
	
	
}
 
