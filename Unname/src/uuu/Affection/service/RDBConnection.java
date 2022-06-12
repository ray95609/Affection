package uuu.Affection.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import uuu.Affection.exception.AffectionException;
					//用來建立連線及儲存帳號密碼，使其他類別可以取得連線
class RDBConnection {	
	
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/affection_base";
	private static final String user="root";
	private static final String pwd="su3cl3";
										//java 預設是 throws RuntimeException  所以要變更為Exception
										//強迫前端做錯誤處理
	static Connection getConnection() throws AffectionException {		//static可以讓其他類別共用
		
		//1.載入JDBC drive  Class.forName(drive) surround with try catch
		try {
			Class.forName(driver);
			
			//2.建立連線  Connection connection surround with try catch
			try {
				Connection connection =DriverManager.getConnection(url, user, pwd);
				
				return connection;
				
			} catch (SQLException e) {
				//e.printStackTrace(); 系統預設的通知前端錯誤
				throw new AffectionException("建立連線失敗",e);//用來通知前端，當錯誤發生即輸出()內容
				
			}
						
		} catch (ClassNotFoundException e) {
			throw new AffectionException("無法載入JDBC Driver"+driver,e);//用來通知前端，當錯誤發生即輸出()內容
		}	
		
		

		
		
	}
}
