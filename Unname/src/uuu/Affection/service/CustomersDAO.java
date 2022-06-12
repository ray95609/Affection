package uuu.Affection.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.management.RuntimeErrorException;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionException;
					//用來取得連線到後台資料庫						
class CustomersDAO {					//用預設讀取權限即可public太大  private太小
	
	
	//登入
	private final static String SELECT_CUSTOMERS_BY_ID=//建立查詢指令
			" SELECT id, password, name, email, birthday, gender,"//必要欄位
			+ " phone, address, subscribe FROM customers"//非必要欄位//sql指令雙引號裡不要有;
			+" WHERE id=? OR email=?";   //查詢指定id出來
	//sql 的關鍵字大小寫區分不大	//?就可以把指令跟輸入資料分開  避免injecttion
	
										//RDBC建立連線所以 throws 一樣要加 AffectionExceptio
	Customer selectCustomerById(String id) throws AffectionException{
		Customer c=null;		
		
		
		//connection.prepareStatement()  surround with try catch
		try (	//try(執行完畢後必須關閉的程式){}
				//1,2取得連線
				//因為RDB有static方法,所以可以直接給其他class使用,無須建立物件
				Connection connection =RDBConnection.getConnection();
				//3準備連線
				PreparedStatement pstmt=connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);
				){
			//3-1傳入?值
			pstmt.setString(1, id);				//pstmt.setString(where後第一個?,等於id);
			pstmt.setString(2, id);				//用email+密碼也能登入(第2個問號的值,等於主建值)
						
			try(//4執行指令
					ResultSet rs=pstmt.executeQuery();
					){			
			//5處理rs
				while(rs.next()) {										//迴圈(如果有列就繼續往下跑，跑到沒有列為止)//有幾列
				c=new Customer();										//如果有查詢到結果，才建立一個C物件
				c.setId(rs.getString("id"));
				c.setPassword(rs.getString("password"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setBirthday(rs.getString("birthday"));
				c.setGender(rs.getString("gender").charAt(0));
				c.setPhone(rs.getString("phone"));
				c.setAddress(rs.getString("address"));
				c.setSubscribed(rs.getBoolean("subscribe"));
				}
			}	
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new AffectionException("查詢客戶失敗",e);			//通知前端，錯誤訊息，e為連線內容
		}
		
		return c;
		
		}; 
		//註冊
		//INSERT INTO tableName +(參數)+(n個?)
		private static final String INSERT_CUSTOMER="INSERT INTO customers"
				+ "(id,password,name,email,birthday,gender,phone,address,subscribe)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		void insert (Customer c) throws AffectionException {
			
			try(//1,2建立連線
					Connection connection=RDBConnection.getConnection();
				//3準備指令
					PreparedStatement pstmt=connection.prepareStatement(INSERT_CUSTOMER);	
				){
				//3.1傳入?值
				pstmt.setString(1,c.getId());
				pstmt.setString(2,c.getPassword());
				pstmt.setString(3,c.getName());
				pstmt.setString(4,c.getEmail());
				pstmt.setString(5,String.valueOf(c.getBirthday()));
				pstmt.setString(6,String.valueOf(c.getGender()));
				pstmt.setString(7,c.getPhone());
				pstmt.setString(8,c.getAddress());
				pstmt.setBoolean(9,c.isSubscribed());
				
				//4執行新增指令
				int rows =pstmt.executeUpdate();
				System.out.println("新增成功:"+rows);
				
			} 
			catch(SQLIntegrityConstraintViolationException e) {
				String errMsg="重複註冊";
				if(e.getMessage().indexOf("customers.PRIMARY")>=0)//主建值重複
				{
				errMsg="ID"+errMsg;					
				}
				else if(e.getMessage().indexOf("customers.email_UNIQUE")>=0)//主建值重複
				{
				errMsg="EMAIL"+errMsg;					
				}else {
				errMsg=e.getMessage();
				}
				
				throw new AffectionException("新增客戶失敗:"+errMsg,e);	
			}
			catch (SQLException e) {
				throw new AffectionException("新增客戶失敗",e);	
			}
			
		}
		
		
		//會員修改
				private static final String UPDATA_CUSTOMER="UPDATE customers "
						+ " SET name=?, email=?, password=?, birthday=?, "
						+ "	gender=?, address=?, phone=?, subscribe=? "
						+ " WHERE id=?";
		
		public void updata(Customer c)  throws AffectionException {
			
			try(//1,2建立連線
					Connection connection=RDBConnection.getConnection();
				//3準備指令
					PreparedStatement pstmt=connection.prepareStatement(UPDATA_CUSTOMER);	
				){
				//3.1傳入?值
				pstmt.setString(1,c.getName());
				pstmt.setString(2,c.getEmail());
				pstmt.setString(3,c.getPassword());
				pstmt.setString(4,String.valueOf(c.getBirthday()));
				pstmt.setString(5,String.valueOf(c.getGender()));
				pstmt.setString(6,c.getAddress());
				pstmt.setString(7,c.getPhone());
				pstmt.setBoolean(8,c.isSubscribed());
				pstmt.setString(9,c.getId());
				
				//4執行新增指令
				int rows =pstmt.executeUpdate();
				System.out.println("修改成功:"+rows);
				
			} 
			catch(SQLIntegrityConstraintViolationException e) {
				String errMsg="會員資料與他人重複";
				if(e.getMessage().indexOf("customers.PRIMARY")>=0)//主建值重複
				{
				errMsg="ID"+errMsg;					
				}
				else if(e.getMessage().indexOf("customers.email_UNIQUE")>=0)//主建值重複
				{
				errMsg="EMAIL"+errMsg;					
				}else {
				errMsg=e.getMessage();
				}
				
				throw new AffectionException("修改客戶資料失敗:"+errMsg,e);	
			}
			catch (SQLException e) {
				throw new AffectionException("修改客戶資料失敗",e);	
			}
			
			
		};
		
		
		
		
		
		
		
		
	}
	
