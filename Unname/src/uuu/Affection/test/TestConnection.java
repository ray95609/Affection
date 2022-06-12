package uuu.Affection.test;

import java.sql.*;

public class TestConnection {
	
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/affection_base";
	private static final String user="root";
	private static final String pwd="su3cl3";
	//正式系統要用設定檔讀取，不能擺在程式碼中
	
	private static final String SELECT_ALL_CUSTOMERS=//建立查詢指令
			"SELECT id, password, name, email, birthday, gender,"//必要欄位
			+ " phone, address, subscribe FROM customers;";//非必要欄位
			
	
	
	public static void main(String[] args) {
			
		try {			
			//1.載入jdbc drive
			Class.forName(driver);			
			
			
			try 
			//2.建立連線
			(Connection connection =DriverManager.getConnection(url, user, pwd);
					//這裡不用new,而是用static方法(無須創造物件)
					//這裡用overriding 上層類別方法參考下層類別物件
					
			//3.建立指令
			Statement stmt=connection.createStatement();
					//這裡不用new,而是用static方法(無須創造物件)
					//建立一個針對connction連線的指令
					
			//4.執行指令
			ResultSet rs= stmt.executeQuery(SELECT_ALL_CUSTOMERS);
					//執行針對connection連線指令的查詢指令，參考參數
			)
			{while(rs.next()) 
			//5.處理rs內容
				
			{System.out.println(rs.getString("id"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("birthday"));
			System.out.println(rs.getString("gender"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getBoolean("subscribe"));}
				
				//System.out.println(connection.getCatalog());//test
			} 
			catch (SQLException e) {System.out.println("建立連線失敗: " + e);	}
			
		} 
		catch (ClassNotFoundException e)
		{System.out.println("無法載入JDBC Driver: " + driver);}
		
		
		
		
	}

}
