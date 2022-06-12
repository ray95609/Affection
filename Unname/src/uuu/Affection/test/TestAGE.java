package uuu.Affection.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import uuu.Affection.entity.Customer;

public class TestAGE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer_1 =new Customer();//創造連結Customer類別中的customer_1物件
		
//		System.out.println("請輸入生日(yyyy-mm-dd)");
		
		Scanner scanner =new Scanner(System.in);
//		String datetype =scanner.next();
		
		System.out.println("請輸入姓名");
		String typename =scanner.next(); 
		
		System.out.println("請輸入身分證字號");
		String typeid=scanner.next();
		
		System.out.println("請輸入密碼");
		String typepassword=scanner.next();
		
		System.out.println("請輸入E-mail");
		String typeemail=scanner.next();
		
		System.out.println("請輸入生日年份(yyyy)");
		String datetype_year =scanner.next();
		
		System.out.println("請輸入生日月份(mm)");		
		String datetype_month =scanner.next();
		
		System.out.println("請輸入生日年份(dd)");
		String datetype_day =scanner.next();
		
		System.out.println("請輸入性別");
		char typegenger=scanner.next().charAt(0);
				
		System.out.println("請輸入行動電話號碼");
		String typephone=scanner.next();
		
		System.out.println("請輸入地址");
		String typeaddress=scanner.next();
		
		System.out.println("是否訂閱電子報");
		Boolean typesuscribe=scanner.nextBoolean();
		
		int sety =Integer.parseInt(datetype_year);
		int setm =Integer.parseInt(datetype_month);
		int setd =Integer.parseInt(datetype_day);
		
		
		
		customer_1.setName(typename);
		
		customer_1.setId(typeid);
		
		customer_1.setPassword(typepassword);
		
		customer_1.setEmail(typeemail);
//		customer_1.birthday=LocalDate.now().minusYears(20);//今天-20年
//		customer_1.birthday=LocalDate.of(sety,setm,setd);
//		customer_1.birthday=LocalDate.parse(datetype);//字串yyyy-mm-dd輸入模式
		
		customer_1.setBirthday(sety, setm, setd);
		
		customer_1.setGender(typegenger);
		
		customer_1.setPhone(typephone);
		
		customer_1.setAddress(typeaddress);
		
		customer_1.setSubscribed(true);		
		
		//算年齡=今年-客戶生日年
//		int age =LocalDate.now().getYear()-customer_1.birthday.getYear();
//		int thisyear=LocalDate.now().getYear();
//		int birthyear=customer_1.birthday.getYear();
//		int age=thisyear-birthyear;
//		int age =customer_1.birthday;
		System.out.println("您的姓名是:");
		System.out.println(customer_1.getName());
		System.out.println("您的身分證字號是:");
		System.out.println(customer_1.getId());
	
		System.out.println("您的E-mail是:");
		System.out.println(customer_1.getEmail());
		
		System.out.println("您的出生年月日是:");
		System.out.println(customer_1.getBirthday());
			
		System.out.println("您的密碼是:");
		System.out.println(customer_1.getPassword());
		
		System.out.println("您的年齡是:");
		System.out.println(customer_1.getAge()+"歲");//去Customer類別中找到getAge()方法
		
		System.out.println("您的性別是:");
		System.out.println(customer_1.getGender());
		
		System.out.println("您的電話號碼是:");
		System.out.println(customer_1.getPhone());
		
		System.out.println("您的地址是:");
		System.out.println(customer_1.getAddress());
		
		System.out.println("您是否訂閱電子報:");
		System.out.println(customer_1.isSubscribed());
		
		

//		customer_1.setBirthday(datetype);
//		System.out.println(Period.between(LocalDate.parse(datetype),LocalDate.now()));
//		System.out.println(Period.between(customer_1.setBirthday
//				(Integer.parseInt(datetype_year), 
//				Integer.parseInt(datetype_month),
//				Integer.parseInt(datetype_day)),LocalDate.now()));
				
//		System.out.println(customer_1.setBirthday(datetype));//method 是void沒有值回傳
//		System.out.println(customer_1.getAge());
		
		
		//package裡面有class(類別或稱attribute)
		//class裡面有object
		
		
		
	}

}
