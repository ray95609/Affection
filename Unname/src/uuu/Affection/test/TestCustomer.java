package uuu.Affection.test;

import java.time.LocalDate;

import uuu.Affection.entity.Customer;
import uuu.Affection.exception.AffectionAtaInvalidException;

public class TestCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		//創造物件連結customer>給屬性值
		Customer customer =new Customer();//創造物件連結類別，創造port口~
		customer.setId("A123456789");
		customer.setPassword(" 1656464 ");
		customer.setName(" 岡舞扣玲 ");
		customer.setEmail("bgg@gmail.com");
//		customer.birthday=LocalDate.parse("1996-06-13");//字串轉日期，須符合iso8601
		customer.setBirthday("1990-06-13");
//		customer.birthday=LocalDate.of(1996,06,13);//整數轉日期
		customer.setBirthday(1996, 06, 13);
		customer.setGender('F');
				
		
		System.out.println(customer.getId());
		System.out.println(customer.getPassword());
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getBirthday().getDayOfMonth());//一個月的第幾天
		System.out.println(customer.getBirthday().getDayOfYear());//一整年的第幾天
		System.out.println(customer.getBirthday().getDayOfWeek());//星期幾
		System.out.println(customer.getBirthday().minusDays(20));//減去日數
		System.out.println(customer.getBirthday().plusDays(20));//增加日數
		System.out.println(customer.getAge());
		System.out.println(customer.getGender());
		System.out.println(customer.getPhone());
		System.out.println(customer.getAddress());
		System.out.println(customer.isSubscribed());
		}catch(AffectionAtaInvalidException e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		//基本型別(8個)以外的都是參考型別
		//基本型別變數會自行創造並參考固定記憶體
		//參考型別無固定記憶體，故會參考相近物件記憶體
		//修改參考型別參考之物件記憶體，會影響參考她的參考型別變數
		//除非將參考型別變數皆宣告給獨立物件記憶體
		
		//int i=1;
		//int j=i;
		//i++;
		//i的值=1,寫入i的固定物件記憶體
		//j的值=1,寫入j的固定物件記憶體
		//所以i++只影響i的值(只寫入i的固定記憶體),不影響j的值
		
		//student bob =new student();
		//bob.name=bob
		//jean=bob;
		//jean.name=jean
		//參考型別的bob變數,創造一個bob參考型別記憶體
		//指派name=bob(寫入bob的參考型別記憶體)
		//jean=bob(讓jean這個變數去參考bob的記憶體內容)
		//jean.name=jean(jean寫入了bob的記憶體,所以name變更了)
		//必須創造獨立的jean物件記憶體,否則等於一個物件有兩個port可以讀跟寫
		
		//System.out.println(customer);
		
	}

}
