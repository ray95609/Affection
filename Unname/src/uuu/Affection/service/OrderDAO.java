package uuu.Affection.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.Order;
import uuu.Affection.entity.OrderItem;
import uuu.Affection.entity.OrderStatusLog;
import uuu.Affection.entity.PaymentType;
import uuu.Affection.entity.Product;
import uuu.Affection.entity.ReceiptType;
import uuu.Affection.exception.AffectionException;
import uuu.Affection.exception.AffectionOverException;

	public class OrderDAO {

		private static final String INSERT_ORDER=" INSERT INTO  affection_base.order  "
				+ " ( id , order_date , order_time , paymentType , paymentNote , "
				+ "  recipient_name , recipient_phone , recipient_address , ReceiptType , "
				+ "  status , customer_id ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,0,?) ";
						
				
		private static final String	INSERT_ORDERITEM="INSERT INTO  affection_base . order_item  "
				+ " ( order_id , product_id , price , quantity ) "
				+ " VALUES(?,?,?,?)";
		
		
		 private static final String UPDATE_NEED ="UPDATE product  SET need=need-? "
			 		+ " WHERE need>=?  AND id=?";
			 
		 private static final String UPDATE_STOCK="UPDATE product SET stock=stock+? "
			 		+ " WHERE id=?";
				
		
	void insert(Order order) throws AffectionException {
		
		
		try(
				//1.建立連線
				Connection connection =RDBConnection.getConnection();
				//2.準備指令並帶回自動給號資料
				PreparedStatement pStmt1=connection.prepareStatement(INSERT_ORDER,Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pStmt2=connection.prepareStatement(INSERT_ORDERITEM);
				
				PreparedStatement pstmtU1 = connection.prepareStatement(UPDATE_NEED);//3.準備指令U1
				PreparedStatement pstmtU2 = connection.prepareStatement(UPDATE_STOCK);//3.準備指令U2
				) {
			
			try {
			//begin tran
				connection.setAutoCommit(false); //將connection的自動commit機制關掉，要由程式自行commit/rollback
			//減少need	
			for(OrderItem item:order.getOrderItemSet()) {
				Product p = item.getProduct();
				int quantity = item.getQuantity();
				
				//3.1 傳入1, 2, 3
				pstmtU1.setInt(1, quantity);
				pstmtU1.setInt(2, quantity);
				pstmtU1.setInt(3, p.getId());
				
				//4. 執行pstmt0並取得修改筆數
				int rows = pstmtU1.executeUpdate();
				if(rows==0) throw new AffectionOverException(p);
				
			}
			
			
			//增加stock
			for(OrderItem item:order.getOrderItemSet()) {
				Product p = item.getProduct();
				int quantity = item.getQuantity();
				
				//3.1 傳入1, 2, 3
				pstmtU2.setInt(1, quantity);
				pstmtU2.setInt(2, p.getId());
				
				//4. 執行pstmt0並取得修改筆數
				int rows = pstmtU2.executeUpdate();
				if(rows==0) throw new AffectionOverException(p);
				
			}
			
			//寫入訂單資料
			//3-1.pStmt1傳入?值
			pStmt1.setInt(1, order.getId());
			pStmt1.setString(2, order.getOrderDate().toString());
			pStmt1.setString(3, order.getOrderTime().toString());
			pStmt1.setString(4, order.getPaymentType().name());
			pStmt1.setString(5, order.getPaymentnote());
			pStmt1.setString(6, order.getOrdername());
			pStmt1.setString(7, order.getOrderphone());
			pStmt1.setString(8, order.getOrderaddress());
			pStmt1.setString(9, order.getReceiptType().name());
			pStmt1.setString(10, order.getMember().getId());
			
			//status 有給預設值為0 可以不給?值
			
			
			//4-1.執行pstmt1
			pStmt1.executeUpdate();
			
			//5.取得pStmt1自動給號的值
			try(ResultSet rs=pStmt1.getGeneratedKeys()){
				
				if(rs!=null) {
					while(rs.next()) {
						int genKey=rs.getInt(1);
						order.setId(genKey);
					}
					
				}
				
			}
			
			
			//寫入訂單內容物
			//3-2.pStmt2傳入值
			for(OrderItem item:order.getOrderItemSet()) {
				pStmt2.setInt(1, order.getId());
				pStmt2.setInt(2, item.getProduct().getId());
				pStmt2.setDouble(3, item.getPrice());
				pStmt2.setInt(4, item.getQuantity());
			//執行pstmt2指令	
				pStmt2.executeUpdate();
			}
			
			//commit
			connection.commit();
			}catch(Exception e){
			//rollback
				connection.rollback();
				throw e; //讓Exception e回歸原來的錯誤處理
			}finally {
				connection.setAutoCommit(true);
			}	
				
			
		} catch (SQLException e) {
			
			throw new AffectionException("建立訂單失敗",e);
			
		}
				
	}
	
	private static final String SELECT_ORDER_HISTORY_BY_CUSTOMER_ID="SELECT id,status,customer_id,paymentType,"
			+ " order_date,order_time,status  "
			+ " ,price,quantity,price*quantity as amount, "
			+ " sum(price*quantity) as total_amount "
			+ " FROM affection_base.order "
			+ " JOIN order_item "
			+ " ON affection_base.order.id = order_item.order_id "
			+ " WHERE customer_id=? "
			+ " GROUP BY id "
			+ " ORDER BY id desc";
	
	
	 List<Order> selectOrderHistoryByCustomerId(String customerId) throws AffectionException {
		List<Order> list =new ArrayList<>();
		
		
		try(	Connection connection =RDBConnection.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(SELECT_ORDER_HISTORY_BY_CUSTOMER_ID);
				) {
			//3.1傳入?值
			pstmt.setString(1,customerId);
			
			try(ResultSet rs=pstmt.executeQuery();){
				while(rs.next()) {
					Order order=new Order();
					order.setId(rs.getInt("id"));
					order.setStatus(rs.getInt("status"));
					order.setOrderDate(LocalDate.parse(rs.getString("order_date")));
					order.setOrderTime(LocalTime.parse(rs.getString("order_time")));
					
					Customer c=new Customer();
					c.setId(rs.getString("customer_id"));
					
					String pTypename=rs.getString("PaymentType");//轉型
					if(pTypename!=null) {
						PaymentType pType=PaymentType.valueOf(pTypename);
						order.setPaymentType(pType);
					}
					//order.setPaymentType(rs.getString("PaymentType"));
					
					order.setTotalAmount(rs.getDouble("total_amount"));
					
					list.add(order);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//start
	
	private static final String SELECT_ORDER_HISTORY_BY_CUSTOMER_ID_DETAIL="SELECT  order.id, status, "
			+ " customer_id, name, paymentType, paymentNote, recipient_name, recipient_phone, "
			+ " recipient_address, ReceiptType, order_id, product_id, order_item.price, quantity, "
			+ "	order_date, order_time,(order_item.price*quantity) as amount "
			+ " FROM affection_base.order "
			+ "	JOIN order_item ON order.id=order_id "
			+ " JOIN product ON product_id=product.id "
			+ " WHERE order.id=? AND customer_id=? ";
		
	 Order selectOrderHistoryByCustomerIdDetail(String OrderId, String customerId) throws AffectionException {
		 Order order =null;
	
		try(	Connection connection =RDBConnection.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(SELECT_ORDER_HISTORY_BY_CUSTOMER_ID_DETAIL);
				){
			//3.1傳入?值
			pstmt.setString(1,OrderId);
			pstmt.setString(2,customerId);
			
			
			try(ResultSet rs=pstmt.executeQuery();){
				while(rs.next()) {
					if(order==null) {
					order=new Order();
					
					//讀取訂單
					order.setId(rs.getInt("id"));
					order.setStatus(rs.getInt("status"));
					order.setOrderDate(LocalDate.parse(rs.getString("order_date")));
					order.setOrderTime(LocalTime.parse(rs.getString("order_time")));
					order.setOrdername(rs.getString("recipient_name"));
					order.setOrderaddress(rs.getString("recipient_address"));
					order.setOrderphone(rs.getString("recipient_phone"));
					order.setTotalAmount(rs.getDouble("amount"));
										
					Customer c=new Customer();
					c.setId(rs.getString("customer_id"));
					order.setMember(c);
										
					String rTypeName=rs.getString("ReceiptType");//轉型
					if(rTypeName!=null) {
						ReceiptType rType=ReceiptType.valueOf(rTypeName);
						order.setReceiptType(rType);
					}
					
					String pTypename=rs.getString("PaymentType");//轉型
					if(pTypename!=null) {
						PaymentType pType=PaymentType.valueOf(pTypename);
						order.setPaymentType(pType);
					}
					
				}
				//讀取訂單明細
				OrderItem oItem=new OrderItem();
				Product p=new Product();
					
					p.setId(rs.getInt("product_id"));
					p.setName(rs.getString("name"));
					oItem.setProduct(p);
					oItem.setPrice(rs.getDouble("price"));
					oItem.setQuantity(rs.getInt("quantity"));
					
					
				
				order.add(oItem);
				
				
			}
			}
			
			
		}catch (SQLException e) {
			throw new AffectionException("查詢訂單明細失敗",e);
			
		}
		
		return order;
	}
	//end

	 
	 
	 
	 private static final String UPDATE_STATUS_TO_TRANSFERED = "UPDATE affection_base.order "
	 		+ " SET status=1,paymentNote=? "
	 		+ " WHERE customer_id=? AND id=? "
	 		+ " AND status=0 AND paymentType='"+PaymentType.ATM.name()+"'";
	 
	 
	 void updateStatusToTransfered(String customerId, String orderId, String note) throws AffectionException {
		
		
		try(	Connection connect=RDBConnection.getConnection();
				PreparedStatement pstmt=connect.prepareStatement(UPDATE_STATUS_TO_TRANSFERED);
				) {
			pstmt.setString(1,note);
			pstmt.setString(2,customerId);
			pstmt.setString(3,orderId);
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new AffectionException("通知已轉帳失敗",ex);
		}
		 
	}

	 
	 private static final String SELECT_ORDERSTATUSLOG="SELECT order_id, old_status, "
	 		+ " new_status, update_time "
	 		+ " FROM order_status_log "
	 		+ " WHERE order_id=?";
	 
	public List<OrderStatusLog> selectOrderStatusLog(String orderId) throws AffectionException {
		List<OrderStatusLog> list = new ArrayList<>();
		
		try(	Connection connection=RDBConnection.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(SELECT_ORDERSTATUSLOG);
				) {
			pstmt.setString(1,orderId);
			
			try(ResultSet rs=pstmt.executeQuery()){
				while(rs.next()) {
					OrderStatusLog log = new OrderStatusLog();
            		log.setOrderId(rs.getInt("order_id"));
            		log.setUpdateTime(
            				LocalDateTime.parse(rs.getString("update_time").replace(' ', 'T')));
            		log.setOldStatus(rs.getInt("old_status"));
            		log.setNewStatus(rs.getInt("new_status"));            		
            		list.add(log);
					
				}
			}
			return list;
		} catch (SQLException e) {
			throw new AffectionException("通知已轉帳失敗",e);
		}				
		
				
	
	}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
