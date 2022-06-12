package uuu.Affection.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShopingCart {
	
	private Customer customer;
	private Map<CartItem, Integer> cartMap=new HashMap<>();
	
	//替代集合得setter:add update delete
	public void add(Product p,int quantity) {
		if(p==null) throw new IllegalArgumentException("加入購物車產品不得為Null");
		
		
		CartItem cartitem =new CartItem();
		cartitem.setProduct(p);
		
		Integer oldQty = cartMap.get(cartitem);
		if(oldQty!=null) {
			quantity = quantity+oldQty;
		}
		
		cartMap.put(cartitem, quantity);
	};
	
		
	/**
	 * 購物車中明細
	 * @return
	 * @see java.util.Map#size()
	 */
	public int size() {			
		return cartMap.size();
	}
	/**
	 * 檢查購物車是否為空
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {	
		return cartMap.isEmpty();
	}

	/**
	 * 檢查購物車明細是否重複 boolean
	 * @param key
	 * @return
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {	
		return cartMap.containsKey(key);
	}

	/**
	 * 取得該明細購買數量
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Integer getQuantity(CartItem key) {
		return cartMap.get(key);
	}
	
	
	/**
	 * 將cartMap中item明細對應的購買數量改為qty的值
	 * @param item
	 * @param qty
	 */
	public void update(CartItem item, int qty) {		
		cartMap.put(item, qty);
	}
	
	
	
	/**
	 * 移除購買明細
	 * @param key
	 * @return
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public Integer remove(Object key) {
		return cartMap.remove(key);
	}

	/**
	 * 取得購買明細集合
	 * @return
	 * @see java.util.Map#keySet()
	 */
	public Set<CartItem>getCartItemSet() {
		return new HashSet<>(cartMap.keySet());//務必回傳集合的複本
		//return cartMap.keySet();//可能讓remove item在執行時期發生錯誤: java.util.ConcurrentModificationException
	}
	/*
	 * 取得小計金額
	 * */
	public double getAmount(CartItem key) {
		double price =key.getProduct().getPrice();
		Integer qty =cartMap.get(key);
				double amount=0;
				if(qty!=null) {
				amount=price*qty;
				}
		return amount;
	}
	/*
	 * 取得總計數量
	 * */
	public int getTotalQty() {
		int sum=0;
		for(Integer qty:cartMap.values()){
			if(qty!=null) {
				sum=sum+qty;
			}
		}
		return sum;
	}
	/*
	 * 取得總計金額
	 * */
	public double getTotalAmount() {
		double sum=0;
		for(CartItem item:cartMap.keySet()) {
			sum=sum+this.getAmount(item);
		}
			
		return sum;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	
	@Override
	public String toString() {
		return "\nShopingCart\n 顧客=" + customer 
				+ "購物明細=" + cartMap 
				+"\n"+size()+"項"
				+getTotalQty() +"件"
				+"總價:"+getTotalAmount()+"元";
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
