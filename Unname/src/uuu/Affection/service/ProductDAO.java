package uuu.Affection.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uuu.Affection.entity.Outlet;
import uuu.Affection.entity.Product;
import uuu.Affection.entity.Product_type;
import uuu.Affection.exception.AffectionException;

import java.sql.*;

class ProductDAO {
	/*查詢全部*/
	private static final String SELECT_ALL_PRODUCT="SELECT id, name, price,"
			+ "discount, stock, need, photoUrl, type , description FROM product";
	
	List<Product>selectAllProduct() throws AffectionException{
		
		List<Product> list =new ArrayList<>();
		
		
		try(Connection connection =RDBConnection.getConnection();//1-取得連線
				PreparedStatement pstmt =connection.prepareStatement(SELECT_ALL_PRODUCT);//2-準備指令
				ResultSet rs =pstmt.executeQuery();//4-執行指令
				) {
			//5-處理rs
			while(rs.next()) {
				Product p;
				int discount=rs.getInt("discount");
				if(discount>0) {
					p =new Outlet();  //多型  上層型別參考下層型別
					((Outlet)p).setDiscount(discount);  //轉型  才能看到下層型別的方法
										
				}else {
					p=new Product();
					
				}
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setNeed(rs.getInt("need"));
				p.setDescription(rs.getString("description"));
				p.setPhotoUrl(rs.getString("photoUrl"));
				p.setType(rs.getString("type"));
				
				list.add(p);
				
				
				
			}
			
			
		} catch (SQLException e) {
			
			throw new AffectionException("查詢產品失敗!", e);
		}
		
		return list;
	}

	
	/*關鍵字查詢*/
	private static final String SELECT_PRODUCT_BY_KEYWORD="SELECT id, name, price, discount, stock,"
			+ " need, photoUrl, description, shelf_date, type  FROM affection_base.product"
			+ "	WHERE name LIKE ?";
		List<Product> selectProductByKeyword(String keyword) throws AffectionException {
		List<Product> list =new ArrayList<Product>();
		
		
		try (	Connection connection =RDBConnection.getConnection();//1-取得連線
				PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUCT_BY_KEYWORD);//2-準備指令
				){
			//3.1-傳入?值
			pstmt.setString(1, '%'+keyword+'%');		//%=>LIKE 語法
			
			//4-執行指令
			try(ResultSet rs =pstmt.executeQuery();
					){
			//5.處理rs
				while(rs.next()) {
					Product p;
					int discount=rs.getInt("discount");
					if(discount>0) {
						p =new Outlet();  //多型  上層型別參考下層型別
						((Outlet)p).setDiscount(discount);  //轉型  才能看到下層型別的方法
											
					}else {
						p=new Product();
						
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setPrice(rs.getDouble("price"));
					p.setStock(rs.getInt("stock"));
					p.setNeed(rs.getInt("need"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl(rs.getString("photoUrl"));
					p.setType(rs.getString("type"));
					
					list.add(p);
					
					
					
				}
			}
		} catch (SQLException e) {
			throw new AffectionException("關鍵字查詢失敗",e);
		}//4-執行指令
		
		return list;
	}
	
		
		/*分類查詢*/
		private static final String SELECT_PRODUCT_BY_TYPE="SELECT id, name, price, discount, stock,"
				+ " need, photoUrl, description, shelf_date, type  FROM affection_base.product"
				+ "	WHERE type= ?";
			List<Product> selectProductByType(String type) throws AffectionException {
			List<Product> list =new ArrayList<Product>();
			
			
			try (	Connection connection =RDBConnection.getConnection();//1-取得連線
					PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUCT_BY_TYPE);//2-準備指令
					){
				//3.1-傳入?值
				pstmt.setString(1, type);		//
				
				//4-執行指令
				try(ResultSet rs =pstmt.executeQuery();
						){
				//5.處理rs
					while(rs.next()) {
						Product p;
						int discount=rs.getInt("discount");
						if(discount>0) {
							p =new Outlet();  //多型  上層型別參考下層型別
							((Outlet)p).setDiscount(discount);  //轉型  才能看到下層型別的方法
												
						}else {
							p=new Product();
							
						}
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setPrice(rs.getDouble("price"));
						p.setStock(rs.getInt("stock"));
						p.setNeed(rs.getInt("need"));
						p.setDescription(rs.getString("description"));
						p.setPhotoUrl(rs.getString("photoUrl"));
						p.setType(rs.getString("type"));
						
						list.add(p);
						
						
						
					}
				}
			} catch (SQLException e) {
				throw new AffectionException("分類查詢失敗",e);
			}//4-執行指令
			
			return list;
		}
			/*舊ID搜尋*/ 
			/*private final static String SELECT_PRODUCT_BY_ID="SELECT id, name, price, discount, stock, "
					+ "need, photoUrl, description, shelf_date,type  FROM affection_base.product "
					+ "WHERE id= ?";*/
			
			private final static String SELECT_PRODUCT_BY_ID_JOIN="SELECT id, name, price "
					+ " ,discount, stock, need, photoUrl, description, shelf_date "
					+ " ,type "
					+ " FROM affection_base.product "
					+ " LEFT JOIN product_type ON product.id=product_type.type_id "
					+ " WHERE id=?";
					
			
			Product selectProductId(String id) throws AffectionException{
				 Product p =null;
			
			try(
				Connection connection =RDBConnection.getConnection();//1,2取得連線	
				PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUCT_BY_ID_JOIN);	//3準備指令
				) {
				//3-1傳入?值
				pstmt.setString(1, id);
				
				try(//4執行指令
					ResultSet rs=pstmt.executeQuery();	
					){
				while(rs.next()) {
					if(p==null) {
					int discount=rs.getInt("discount");
					if(discount>0) {
						p=new Outlet();
						((Outlet)p).setDiscount(discount);
					}else {
						p=new Product();
						
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setPrice(rs.getDouble("price"));
					p.setStock(rs.getInt("stock"));
					p.setNeed(rs.getInt("need"));
					p.setDescription(rs.getString("description"));
					p.setPhotoUrl(rs.getString("photoUrl"));
					p.setType(rs.getString("type"));
					}
					
					/*讀取JOIN的type資烙*/
					/*String typeName=rs.getString("type_name");
					if(typeName!=null) {
						Product_type type=new Product_type();
						type.setType_name(typeName);
						
						p.add(type)
					}*/
						}	
					
				}
						
				
			} catch (SQLException e) {
				throw new AffectionException("ID查詢產品失敗", e);
			}
			
				 
				 return p;
			}

			
			
			
			private final static String SELECT_PRODUCT_BY_SOS="SELECT id, name, price, discount, "
					+ " stock, need, photoUrl, description, shelf_date,type, "
					+ " (stock/need) as  percentage "
					+ " FROM affection_base.product "
					+ " WHERE type= ?"
					+ " ORDER BY percentage " ;
			
			
			 List<Product> selectProductSos(String sos) throws AffectionException {
				 List<Product> list =new ArrayList<Product>();
				 
				 try(
					 Connection connect =RDBConnection.getConnection();
					 PreparedStatement pStmt =connect.prepareStatement(SELECT_PRODUCT_BY_SOS); 
						 ) {
					 
					 pStmt.setString(1, sos);
					
					 try(
							 ResultSet rs=pStmt.executeQuery(); 
							 ) {
						 while(rs.next()) {
							Product p=new Product();
							
							p.setId(rs.getInt("id"));
							p.setName(rs.getString("name"));
							p.setPrice(rs.getDouble("price"));
							p.setStock(rs.getInt("stock"));
							p.setNeed(rs.getInt("need"));
							p.setDescription(rs.getString("description"));
							p.setPhotoUrl(rs.getString("photoUrl"));
							p.setType(rs.getString("type"));
							
							list.add(p);				
						
						 }
					 }
					 
					 
				} catch (SQLException e) {
					throw new AffectionException("需求度查詢失敗", e);
					
				}
				 return list;
				 
			}

			 
			 

			 
			 private static final String SELECT_NEED="SELECT id, need FROM product WHERE id=?";
			 
			 	 
			 int selectNeed(String pid) throws AffectionException {
				
				int need=0;
				
				
				try(
						Connection connection = RDBConnection.getConnection();
						PreparedStatement pstmt=connection.prepareStatement(SELECT_NEED);
					) {
					pstmt.setNString(1, pid);
					
					try(ResultSet rs=pstmt.executeQuery();){
						while(rs.next()) {
							need=rs.getInt("need");
						}
						
					}

					
				} catch (SQLException e) {
					throw new AffectionException("查詢需求量失敗",e);
				}

				
				return need;
			}
		
			
			
	
}
