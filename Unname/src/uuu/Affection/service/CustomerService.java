package uuu.Affection.service;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionException;

public class CustomerService {								//前端呼叫元件,都使用public
	private CustomersDAO dao =new CustomersDAO();			//Data Access Object=資料讀取元件 
	public Customer login(String id,String password) throws AffectionException {
		
		if(id==null || id.length()==0						//id跟password是null或是空字串
				|| password==null || password.length()==0) 
		{throw new IllegalArgumentException("客戶登入必須有帳號及密碼");}	
															//用來通知前端，當錯誤發生即輸出()內容
		
		
		Customer c=dao.selectCustomerById(id);				//創立c物件(用來包回傳值)
															//c內容為查詢到的id
															//(查詢id時會進行驗證,所以id不是null就一定是正確的)
															//如果id是null或者id正確但是密碼錯誤
		if(c==null||(c!=null && !password.equals(c.getPassword()))) {
		throw new AffectionException("登入失敗,帳號密碼錯誤");	//用來通知前端，當錯誤發生即輸出()內容
		}
		
		return c;
	} 
	
	public void register(Customer c) throws AffectionException {
		if(c==null) {throw new IllegalArgumentException("客戶註冊時customer不得為null");}
		
		dao.insert(c);
		
		};
	
		
	public void updata(Customer c) throws AffectionException {
			if(c==null) {throw new IllegalArgumentException("會員修改時customer不得為null");}
			
			dao.updata(c);
			
			};	
		
}
