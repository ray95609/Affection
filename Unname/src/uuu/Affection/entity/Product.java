package uuu.Affection.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product {
	public Product() {}//無參數建構式,可寫可不寫
	
	/**
	 * 有參數建構式
	 * 用於快速檢查之用(test程式用)
	 * @param id
	 */
	public Product(int id) {	super();this.setId(id);}

	public static final NumberFormat FORMAT = new DecimalFormat("#.0#"); 

	private int id;//產品編號>Pkey
	private String name;//產品名稱>Pkey
	private double price;//產品價格>Pkey
	private int stock;//產品庫存>Pkey//可建立需求屬性(attribution)配合stock
	private int need;//目前需求>Pkey
	private String description="";//產品描述>非必要欄位>給初值
	private String photoUrl="";//產品照片(都用網址)>非必要欄位>給初值
	private String type;
	
	/*Map寫法*/
	/*private Map<String, Product_type> typesMap=new HashMap<>();
	
	
	//????為什麼要建這個
	//public Product() {}	//需要提供符合JAVA Bean規格
	
	
	//????為什麼要set
	public Product(int id,String name,double price) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		
	}
	//????發生甚麼事情???
	public Map<String,Product_type>getTypesMap(){
		return typesMap;
	}
	//????WHY????
	public void add(Type Product_type) {
		typesMap.put(Product_type.getType_name(), type);
		
	}*/
	
	
//	public Product(String id,String name,double price)//有參數建構式//不要用!不要用!
//	{this.id=id; this.name=name; this.price=price;}
	
	
//getter && setter//resouce>generate Get&Set
	


	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	public int getNeed() {return need;}
	public void setNeed(int need) {this.need = need;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public String getPhotoUrl() {return photoUrl;}
	public void setPhotoUrl(String photoUrl) {this.photoUrl = photoUrl;}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	@Override
	public String toString() {
		return '\n'+this.getClass().getSimpleName()
				+ "\n產品編號:" + id 
				+ "\n產品名稱:" + name 
				+ "\n產品價格:" +(int) price
				+ "\n產品庫存:" + stock 
				+ "\n產品需求:" + need
				+ "\n產品描述:" + description 
				+ "\n產品圖片:" + photoUrl
				+ "\n產品種類:" + type	;
										//跑出怪怪的東西
				
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * id相同則product相同
	 * 判斷是否為相同產品別
	 * 判斷物品多不使用instanceof
	 */
/*	@Override
		public boolean equals(Object obj) 
		{if (this == obj)
		{return true;}
		if (obj == null) 
		{return false;}
		if (getClass() != obj.getClass())
		{return false;}
		Product other = (Product) obj;
		if (id == null)
		{if (other.id != null) {return false;}
		} 
		else if (!id.equals(other.id))
		{return false;}
		return true;
		}*/
	
	
	
	
	
}
