package uuu.Affection.entity;

public class VIP extends Customer{
	//繼承了所有內容
	//super class>父類別
	//sub class>子類別
	//類別只能單一繼承(extend),但是可以多重實作(implement)介面(interface)
	//介面可以多重繼承介面
	
	private	int discount;
	
	public VIP() {super();}

	public VIP(String id, String name, String password)
	{super(id, name, password);	}

	public int getDiscount() {return discount;}

	public void setDiscount(int discount) {this.discount = discount;}
	
	public String getDiscounting() 
	{int discount=(100-this.discount);
	if (discount%10==0)
	{return (discount/10+"折");}	//台灣人習慣用x折(8折)
	else
	return discount+"折"	;//台灣人習慣用xx折(85折)
	}

		
	@Override
	public String toString() {
		return super.toString()
				+"\n優惠折扣:" + discount+"折" 
				+ "\n優惠折扣:" + getDiscount() 
				+ "\n優惠折扣:"+ getDiscounting();
	}
	
	
	
	
	
}
