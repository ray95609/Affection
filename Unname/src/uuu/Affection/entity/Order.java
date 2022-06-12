package uuu.Affection.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private int id;//PK
	private LocalDate orderDate=LocalDate.now(); //yyyy-mm-dd
	private LocalTime orderTime=LocalTime.now(); //hh:mm:ss.sss

	private Customer member;
	
	private ReceiptType receiptType;
	private PaymentType paymentType;
	private String paymentnote="";
	
	private String ordername;
	private String orderemail;
	private String orderphone;
	private String orderaddress;
	
	private double totalAmount;
	
	
	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		if(orderItemSet!=null&&orderItemSet.size()>0) {
				double sum=0;
				for(OrderItem item:orderItemSet) {
					sum=sum+item.getPrice()*item.getQuantity();
					
				}
				return sum;
				
		}
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private Set<OrderItem> orderItemSet =new HashSet<>();
		
	
	private int status;//0=新訂單 1=已轉帳 2=已入帳 3=已出貨...
	
	
	
	/**
	 * @return the orderItemSet
	 */
	public Set<OrderItem> getOrderItemSet() {
		return new HashSet<OrderItem>(orderItemSet) ;
	}
	
	/*
	 * 從購物車把變成訂單明細再加入訂單的orderSet
	 * */
	public void add(ShopingCart cart) {
		
		if(cart==null || cart.size()==0) throw new IllegalArgumentException("建立訂單失敗,訂單空白");
		for(CartItem cartItem:cart.getCartItemSet()) {
			
			OrderItem orderItem =new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setPrice(cartItem.getProduct().getPrice());
			orderItem.setQuantity(cart.getQuantity(cartItem));
			
			orderItemSet.add(orderItem);
			}
			
	};
		
	
	/*TODO add orderItem*/
	public void add(OrderItem item) {		//item是DAO從資料庫讀出一筆訂單明細石，就建立一個OrderItem，並加到Order中
		if(item==null) throw new IllegalArgumentException("加入訂單明細時，orderItem不得為null");
		orderItemSet.add(item);
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}



	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * @return the orderTime
	 */
	public LocalTime getOrderTime() {
		return orderTime;
	}



	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}



	/**
	 * @return the member
	 */
	public Customer getMember() {
		return member;
	}



	/**
	 * @param member the member to set
	 */
	public void setMember(Customer member) {
		this.member = member;
	}



	/**
	 * @return the paymentType
	 */	public PaymentType getPaymentType() {
		 return paymentType;	}



	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}



	/**
	 * @return the paymentnote
	 */
	public String getPaymentnote() {
		return paymentnote;
	}



	/**
	 * @param paymentnote the paymentnote to set
	 */
	public void setPaymentnote(String paymentnote) {
		this.paymentnote = paymentnote;
	}



	public ReceiptType getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(ReceiptType receiptType) {
		this.receiptType = receiptType;
	}

	/**
	 * @return the ordername
	 */
	public String getOrdername() {
		return ordername;
	}



	/**
	 * @param ordername the ordername to set
	 */
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}



	/**
	 * @return the orderemail
	 */
	public String getOrderemail() {
		return orderemail;
	}



	/**
	 * @param orderemail the orderemail to set
	 */
	public void setOrderemail(String orderemail) {
		this.orderemail = orderemail;
	}



	/**
	 * @return the orderphone
	 */
	public String getOrderphone() {
		return orderphone;
	}



	/**
	 * @param orderphone the orderphone to set
	 */
	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}



	/**
	 * @return the orderaddress
	 */
	public String getOrderaddress() {
		return orderaddress;
	}



	/**
	 * @param orderaddress the orderaddress to set
	 */
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}



	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	public String getStatusString() {
		  String str ="";
		  switch(status) {
		   case 0:
		    str = "0-新訂單";
		    break;
		   case 1:
		    str = "1-已轉帳";
		    break;
		   case 2:
		    str = "2-已購買";
		    break;
		   case 3:
		    str = "3-已使用";
		    break;
		  }
		  return str;
		 }
	
	
	
	

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ","
				+ " orderDate=" + orderDate + ","
				+ " orderTime=" + orderTime + ","
				+ " member=" + member+ ", "
				+ " paymentType=" + paymentType +","
				+ "receiptType="+ receiptType+ ","
				+ "paymentnote=" + paymentnote + ","
				+ " ordername=" + ordername + ","
				+ " orderemail=" + orderemail
				+ ", orderphone=" + orderphone + ","
				+ " orderaddress=" + orderaddress + ","
				+ " orderItemSet=" + orderItemSet
				+ ", status=" + status + "]";
	}







	
}
