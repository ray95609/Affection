package uuu.Affection.test;

import uuu.Affection.entity.Customer;
import uuu.Affection.entity.VIP;

public class TestEqualTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer c1=new Customer("A123456789","bgg","123");
		
		Customer c2=new Customer("A123456789","BGG","123");
		
		VIP c3=new VIP();
		c3.setId("Y222222222");
		
		VIP c4=new VIP();
		c4.setId("A123456789");
		
		System.out.println(c1==c2);//全部都要相同
		
		System.out.println(c1.equals(c2));//id相同即相同
		
		System.out.println(c1.equals(c3));
	
		System.out.println(c1.equals(c4));
		
	}

}
