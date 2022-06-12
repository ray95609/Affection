package uuu.Affection.test;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//多型的宣告Test
		//上層型別宣告的變數參考下層型別的物件
		//多用於方法中的參數及回傳型別
		
		Object o =new Customer();//多型宣告//一個object 參考Customer
		
		Object o_1="BGG";//多型宣告//區域變數直接使用多型宣告
		
		VIP vip=new VIP();//一般宣告//new 一個VIP物件
		vip.setId("A223511111");
		vip.setName("BGG");
		vip.setPassword("11235");
		vip.setDiscount(30);
		
		Customer v= vip;//有一個Customer v資料參考vip//本質上是顧客不是vip
//		Customer v=new Customer();//註一:
		System.out.println(v.getId());
		System.out.println(v.getName());
		System.out.println(vip.getDiscount());
//		System.out.println(v.getDiscount());//因為本質上是customer 所以看不到vip的專屬discount
		
		if (v instanceof Customer)//v本身是一個Customer  如果v是參考Customer 
		{System.out.println("如果v是Customer,強制轉型成VIP,抓Discount\t"+((VIP)v).getDiscount()+"折");}//把客戶強制轉型成VIP//不是vip
		//註1:如果v是參考Customer他本身也是一個Customer//他跟VIP無關所以compile的時候抓不到VIP的資料所以轉型錯誤
		//因為v然參考VIP,就一定有參考Customer,因為VIP繼承自Customer

		if (v instanceof VIP)//如果Customer v參考一個VIP的資料//確保變數本身有參考強制轉成的型別//確保轉型撈得到資料
		{System.out.println("如果v是參考VIP,強制轉型成VIP,抓Discount\t"+((VIP)v).getDiscount()+"折");}
		//v是Customer,因為他有參考VIP所以強制轉型成VIP才會成功
		//如果v沒有參考VIP，那他從頭到尾都沒有VIP的資料，就會轉型失敗
		
//		VIP v2= v;//一個VIP變數參考Customer v
		VIP v2=(VIP)v;//一個VIP 變數參考轉型為VIP的Customer v
		System.out.println("v2強制轉型成VIP去抓Discount\t"+v2.getDiscount()+"折");
		
		
		
		
	}

}
