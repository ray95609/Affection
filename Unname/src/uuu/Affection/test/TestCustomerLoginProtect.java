package uuu.Affection.test;

import java.sql.*;
import java.util.Scanner;

//Prevent SQL injection
//把指令執行跟輸入資料分開 


public class TestCustomerLoginProtect {
	
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/affection_base";
	private static final String user="root";
	private static final String pwd="su3cl3";
	//正式系統要用設定檔讀取，不能擺在程式碼中
	
	//""內第一個字都要+空白 避免字串合併錯誤
	private final static String SELECT_CUSTOMERS_BY_ID=//建立查詢指令
			" SELECT id, password, name, email, birthday, gender,"//必要欄位
			+ " phone, address, subscribe FROM customers"//非必要欄位//sql指令雙引號裡不要有;
			+" WHERE id=? AND password=?";   //查詢指定id出來
	//sql 的關鍵字大小寫區分不大	//?就可以把指令跟輸入資料分開  避免injecttion
			
	
	
	public static void main(String[] args) {
			
		String id,password;						//宣告變數
		Scanner scanner=new Scanner(System.in);//建立輸入物件
		
		System.out.println("請輸入帳號:");
		id=scanner.next();						//id內容宣告為輸入內容
		
		System.out.println("請輸入密碼:");
		password=scanner.next();				//password內容宣告為輸入內容
		

		//已經下final所以不能改囉~
//		SELECT_CUSTOMERS_BY_ID = SELECT_CUSTOMERS_BY_ID
//				+" WHERE id ='"+id+"' AND password='"+password+"'";
												//查詢指令內容(查詢並顯示全部內容)加上where(查詢特定"+id+")
												//"+id+"為特定語法 為了配合sql程式碼
		//try(跑完之後要關閉的程序){判斷是否有例外程式碼(有不確定要素或連結其他程式語言)}
		//catch{有例外發生時執行的程式碼}
		//try catch不一定要加(),但是一定有{}
		try {			
			//1.載入jdbc drive
			Class.forName(driver);			
			
			
			try 
			//2.建立連線
			(Connection connection =DriverManager.getConnection(url, user, pwd);
					//這裡不用new,而是用static方法(無須創造物件)
					//這裡用overriding 上層類別方法參考下層類別物件
					
			//3.準備指令
			PreparedStatement pstmt=connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);
					//這裡不用new,而是用static方法(無須創造物件)
					//建立一個針對connction連線的指令
					//PrepareStatement是常用的防範機制
					
			)
			{//3-1.輸入內容傳入?變數內容
				pstmt.setString(1,id);
				pstmt.setString(2,password);
			try(//4.執行指令
			ResultSet rs= pstmt.executeQuery();						//try(要關閉元件){要跑的程式}
			){		//執行指令											//catch{try無法運行才會跑到這裡}
				int count=0;
				while(rs.next())//迴圈(如果有列就繼續往下跑，跑到沒有列為止)//有幾列
			{count++;
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("birthday"));
			System.out.println(rs.getString("gender"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getBoolean("subscribe"));}
					
			System.out.println(connection.getCatalog());//test
			
			if (count==0)
			{System.out.println("查無資料");}
			
			System.out.println("查詢結果:\n總共有"+count+"筆符合資料");
			} 
			}
			catch (SQLException e) {System.out.println("建立連線失敗: " + e);	}
			
		} 
		catch (ClassNotFoundException e)
		{System.out.println("無法載入JDBC Driver: " + driver);}
		
		
		
		
	}

}
